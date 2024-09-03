package CONTROLLER;

import MODEL.*;
import VIEW.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings({"unused", "DuplicatedCode", "SpellCheckingInspection"})
public class Controller {
    private Login_Window login_window;
    private DeliveryService deliveryService;
    private Client_Window client_window;
    private Admin_Window admin_window;
    private BaseProduct_Frame baseProduct_frame;
    private CompositeProduct_Frame compositeProduct_frame;
    private  Employe_Frame employe_frame;
    private Reports_Frame reports_frame;
    public void start() {
        login_window = new Login_Window(this);
        login_window.setVisible(true);
        deliveryService =(DeliveryService) Serializator.Deserialization("deliveryService");//new DeliveryService();//
        deliveryService.hardcode();
        employe_frame=new Employe_Frame();
        deliveryService.addObserver(employe_frame);
        login_window.getBtnLogin().addActionListener(e -> login());
        login_window.getBtnRegister().addActionListener(e -> login_window_register());
        login_window.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                Serializator.Serialization(deliveryService,"deliveryService");
                e.getWindow().dispose();
            }
        });
    }

    //Login_Window
    //Login_window register button action
    public void login_window_register() {
        login_window.setRegister_window(new Register_Window());
        login_window.getRegister_window().getBtnRegister().addActionListener(s -> register());
        login_window.getRegister_window().setVisible(true);
    }

    //Login_Window login button action
    public void login() {
        String password = String.valueOf(login_window.getPasswordField().getPassword());
        String username = login_window.getText_Username().getText();
        Person user = deliveryService.findPerson(username, password);
        if (user != null) {
            deliveryService.setCurrentPerson(user);
            switch (user.getRole()) {
                case CLIENT -> start_Client_Window();
                case ADMIN -> start_Admin_Window();
                case EMPLOYEE ->{employe_frame=new Employe_Frame();
                employe_frame.setVisible(true);
                deliveryService.addObserver(employe_frame);
                }
            }
        } else
            JOptionPane.showMessageDialog(login_window, "Incorrect username or password !", "Error", JOptionPane.ERROR_MESSAGE);
    }

    //Register_Window
    //Register_Window register button action
    public void register() {
        Register_Window f = login_window.getRegister_window();
        String password = String.valueOf(f.getPasswordField().getPassword());
        String password_confirm = String.valueOf(f.getPasswordField_confirm().getPassword());
        String username = f.getTextUsername().getText();
        if (!password.equals(password_confirm))
            JOptionPane.showMessageDialog(f, "Passwords don't match !", "Error", JOptionPane.ERROR_MESSAGE);
        else if (password.isEmpty() || username.isEmpty())
            JOptionPane.showMessageDialog(f, "Empty fields !", "Error", JOptionPane.ERROR_MESSAGE);
        else if (deliveryService.findPerson(username, password) == null)
            JOptionPane.showMessageDialog(f, "User already exists !", "Error", JOptionPane.ERROR_MESSAGE);
        else {
            Person person = new Person(username, password, Job.CLIENT);
            deliveryService.addPerson(person);
            f.dispose();
        }
    }


    public DefaultTableModel setupProduct_table(Set<MenuItem> products) {
        DefaultTableModel model = new DefaultTableModel();
        Field[] fields = MenuItem.class.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            model.addColumn(f.getName());
        }
        products.forEach(menuItem -> {
            List<Object> row = new ArrayList<>();
            for (Field f : fields) {
                try {
                    row.add(f.get(menuItem));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            model.addRow(row.toArray());
        });
        return model;
    }



    //Admin_Window
    public void start_Admin_Window()
    {
        admin_window=new Admin_Window();
        admin_window.setVisible(true);
        admin_window.getTableProducts().setModel(setupProduct_table(deliveryService.getProducts()));
        admin_window.getBtnImportProducts().addActionListener(e -> importProducts());
        admin_window.getBtnDeleteProduct().addActionListener(e -> removeProduct());
        admin_window.getBtnCreateProduct().addActionListener(e -> addProduct());
        admin_window.getBtnEditProduct().addActionListener(e -> editProduct());
        admin_window.getBtnCreateMenu().addActionListener(e -> CreateMenu());
        admin_window.getBtnReports().addActionListener(e -> report());
    }
    //Admin_Window importProducts button action
    public void importProducts()
    {
        deliveryService.setProducts(FileManager.products());
        admin_window.getTableProducts().setModel(setupProduct_table(deliveryService.getProducts()));
        System.out.println("Import successful");
    }

    //Admin_Window removeProduct button action
    public void removeProduct()
    {
        JTable products=admin_window.getTableProducts();
        int row=products.getSelectedRow();
        String name= (String) products.getValueAt(row,0);
        MenuItem removed=deliveryService.findProduct(name);
        deliveryService.removeProduct(removed);
        products.setModel(setupProduct_table(deliveryService.getProducts()));
    }
    //Admin_Window addProduct button action
    public void addProduct()
    {
        baseProduct_frame=new BaseProduct_Frame();
        baseProduct_frame.setVisible(true);
        baseProduct_frame.getBtnProduct().addActionListener(e -> BaseProduct_Frame_createProduct());
    }

    public void report()
    {
        reports_frame=new Reports_Frame();
        reports_frame.setVisible(true);
        reports_frame.getBtnGenerate().addActionListener(e ->  reportsGeneration());
    }

    //BaseProduct_Frame button create action
    public void BaseProduct_Frame_createProduct()
    {
        baseProduct_frame.choise(null);
        String title=baseProduct_frame.getTextFieldName().getText();
        Double rating= Double.valueOf(baseProduct_frame.getTextFieldRating().getText());
        Double calories= Double.valueOf(baseProduct_frame.getTextFieldCalories().getText());
        Double proteins= Double.valueOf(baseProduct_frame.getTextFieldProteins().getText());
        Double fats= Double.valueOf(baseProduct_frame.getTextFieldFats().getText());
        Double sodium= Double.valueOf(baseProduct_frame.getTextFieldSodium().getText());
        Double price= Double.valueOf(baseProduct_frame.getTextFieldPrice().getText());
        MenuItem item=new BaseProduct(title,rating,calories,proteins,fats,sodium,price);
        deliveryService.addProduct(item);
        admin_window.getTableProducts().setModel(setupProduct_table(deliveryService.getProducts()));
        baseProduct_frame.dispose();
    }

    public void BaseProduct_Frame_editProduct()
    {
        String title=baseProduct_frame.getTextFieldName().getText();
        Double rating= Double.valueOf(baseProduct_frame.getTextFieldRating().getText());
        Double calories= Double.valueOf(baseProduct_frame.getTextFieldCalories().getText());
        Double proteins= Double.valueOf(baseProduct_frame.getTextFieldProteins().getText());
        Double fats= Double.valueOf(baseProduct_frame.getTextFieldFats().getText());
        Double sodium= Double.valueOf(baseProduct_frame.getTextFieldSodium().getText());
        Double price= Double.valueOf(baseProduct_frame.getTextFieldPrice().getText());
        MenuItem item=deliveryService.findProduct(baseProduct_frame.getMenuItemm().getTitle());
        System.out.println(deliveryService.findProduct(baseProduct_frame.getMenuItemm().getTitle()));
        item.setTitle(title);
        item.setRating(rating);
        item.setCalories(calories);
        item.setProteins(proteins);
        item.setFats(fats);
        item.setSodium(sodium);
        item.setPrice(price);
        System.out.println(deliveryService.findProduct(baseProduct_frame.getMenuItemm().getTitle()));
        admin_window.getTableProducts().setModel(setupProduct_table(deliveryService.getProducts()));
        baseProduct_frame.dispose();
    }

    public void editProduct()
    {
        JTable table=admin_window.getTableProducts();
        int row=table.getSelectedRow();
        String name= (String) table.getValueAt(row,0);
        MenuItem found=deliveryService.findProduct(name);
        if(found instanceof BaseProduct) {
            baseProduct_frame = new BaseProduct_Frame();
            baseProduct_frame.setVisible(true);
            baseProduct_frame.choise(found);
            baseProduct_frame.getBtnProduct().addActionListener(e -> BaseProduct_Frame_editProduct());
        }
        else
        {
            compositeProduct_frame=new CompositeProduct_Frame();
            compositeProduct_frame.setVisible(true);
            compositeProduct_frame.choise(found);
            compositeProduct_frame.getTableList().setModel(setupProduct_table(compositeProduct_frame.getItem().getMenu()));
            compositeProduct_frame.getBtnAction().addActionListener(e -> CompositeProduct_Frame_edit());
            compositeProduct_frame.getBtnRemoveFromList().addActionListener(e -> CompositeProduct_Frame_remove());
            compositeProduct_frame.getBtnAddToList().addActionListener(e -> CompositeProduct_Frame_add());
            compositeProduct_frame.getTableProducts().setModel(setupProduct_table(deliveryService.getProducts()));


        }
    }

    public void CreateMenu()
    {
        compositeProduct_frame=new CompositeProduct_Frame();
        compositeProduct_frame.setVisible(true);
        compositeProduct_frame.getTableProducts().setModel(setupProduct_table(deliveryService.getProducts()));
        setuplistmenu();
        compositeProduct_frame.getBtnAddToList().addActionListener(e ->  CompositeProduct_Frame_add());
        compositeProduct_frame.getBtnRemoveFromList().addActionListener(e -> CompositeProduct_Frame_remove());
        compositeProduct_frame.getBtnAction().addActionListener(e -> CompositeProduct_Frame_create());
    }
    //CompositeProduct_Frame
    //Setup JTable list
    public void setuplistmenu()
    {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        Field[] declaredFields = MenuItem.class.getDeclaredFields();
        for (Field f : declaredFields) {
            f.setAccessible(true);
            defaultTableModel.addColumn(f.getName());
        }
        compositeProduct_frame.getTableList().setModel(defaultTableModel);
    }
    //CompositeProduct_Frame
    
    //CompositeProduct_Frame addtoList button action
    public void CompositeProduct_Frame_add()
    {
        JTable products = compositeProduct_frame.getTableProducts();
        JTable list = compositeProduct_frame.getTableList();
        DefaultTableModel model = (DefaultTableModel) list.getModel();
        int selected_row = products.getSelectedRow();
        List<Object> row = new ArrayList<>();
        for (int i = 0; i < products.getColumnCount(); i++) {
            row.add(products.getValueAt(selected_row, i));
        }
        model.addRow(row.toArray());
    }
    
    //CompositeProduct_Frame removeromList button action
    public void CompositeProduct_Frame_remove()
    {
        JTable list = compositeProduct_frame.getTableList();
        int row = list.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) list.getModel();
        model.removeRow(row);
    }

    //CompositeProduct_Frame create action button action
    public void CompositeProduct_Frame_create()
    {
        JTable list=compositeProduct_frame.getTableList();
        String title=compositeProduct_frame.getTextFieldName().getText();
        Double rating= Double.valueOf(compositeProduct_frame.getTextFieldRating().getText());
        Double calories= Double.valueOf(compositeProduct_frame.getTextFieldCalories().getText());
        Double proteins= Double.valueOf(compositeProduct_frame.getTextFieldProteins().getText());
        Double fats= Double.valueOf(compositeProduct_frame.getTextFieldFats().getText());
        Double sodium= Double.valueOf(compositeProduct_frame.getTextFieldSodium().getText());
        Double price= Double.valueOf(compositeProduct_frame.getTextFieldPrice().getText());
        CompositeProduct item=new CompositeProduct(title,rating,calories,proteins,fats,sodium,price);
        for(int i=0;i<list.getRowCount();i++)
        {
            String name= (String) list.getValueAt(i,0);
            MenuItem delivery_item=deliveryService.findProduct(name);
            item.addProduct(delivery_item);
        }
        System.out.println(item);
        deliveryService.getProducts().add(item);
        admin_window.getTableProducts().setModel(setupProduct_table(deliveryService.getProducts()));
        compositeProduct_frame.dispose();
    }
    
    public void CompositeProduct_Frame_edit()
    {
        String title=compositeProduct_frame.getTextFieldName().getText();
        Double rating= Double.valueOf(compositeProduct_frame.getTextFieldRating().getText());
        Double calories= Double.valueOf(compositeProduct_frame.getTextFieldCalories().getText());
        Double proteins= Double.valueOf(compositeProduct_frame.getTextFieldProteins().getText());
        Double fats= Double.valueOf(compositeProduct_frame.getTextFieldFats().getText());
        Double sodium= Double.valueOf(compositeProduct_frame.getTextFieldSodium().getText());
        Double price= Double.valueOf(compositeProduct_frame.getTextFieldPrice().getText());
        CompositeProduct item=(CompositeProduct)deliveryService.findProduct(compositeProduct_frame.getItem().getTitle());
        System.out.println(item);
        item.setMenu(new HashSet<>());
        JTable list=compositeProduct_frame.getTableList();
        for(int i=0;i<list.getRowCount();i++)
        {
            String name= (String) list.getValueAt(i,0);
            MenuItem delivery_item=deliveryService.findProduct(name);
            item.addProduct(delivery_item);
        }
        item.setTitle(title);
        item.setRating(rating);
        item.setCalories(calories);
        item.setProteins(proteins);
        item.setFats(fats);
        item.setSodium(sodium);
        item.setPrice(price);
        System.out.println(item);
        admin_window.getTableProducts().setModel(setupProduct_table(deliveryService.getProducts()));
        compositeProduct_frame.dispose();
    }
    //Client_window
    public void start_Client_Window() {
        client_window = new Client_Window();
        client_window.setVisible(true);
        client_window.getTableProducts().setModel(setupProduct_table(this.deliveryService.getProducts()));
        setupcart();
        client_window.getBtnAddToCart().addActionListener(e -> addtoCart());
        client_window.getBtnRemoveFromCart().addActionListener(e -> removefromCart());
        client_window.getBtnCommand().addActionListener(e -> order());
        client_window.getBtnFilterOut().addActionListener(e -> filterOut());
    }

    //Client_window JTable cart setup action
    public void setupcart() {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        Field[] declaredFields = MenuItem.class.getDeclaredFields();
        for (Field f : declaredFields) {
            f.setAccessible(true);
            defaultTableModel.addColumn(f.getName());
        }
        client_window.getTableCart().setModel(defaultTableModel);
    }

    //Client_window add-toCart button action
    public void addtoCart() {
        JTable products = client_window.getTableProducts();
        JTable cart = client_window.getTableCart();
        DefaultTableModel model = (DefaultTableModel) cart.getModel();
        int selected_row = products.getSelectedRow();
        List<Object> row = new ArrayList<>();
        for (int i = 0; i < products.getColumnCount(); i++) {
            row.add(products.getValueAt(selected_row, i));
        }
        model.addRow(row.toArray());
        if (cart.getRowCount() == 1)
            computeTotal();
        else {
            model.removeRow(cart.getRowCount() - 2);
            computeTotal();
        }
    }

    //Client_window remove-fromCart button action
    public void removefromCart() {
        JTable cart = client_window.getTableCart();
        int row = cart.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) cart.getModel();
        model.removeRow(row);
        model.removeRow(cart.getRowCount() - 1);
        computeTotal();
    }
    

    //Client_window JTable last row containing sum of the first rows.
    public void computeTotal() {
        JTable cart = client_window.getTableCart();
        List<Object> row = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) cart.getModel();
        row.add("Total");
        for (int j = 1; j < cart.getColumnCount(); j++) {
            double total = 0;
            for (int i = 0; i < cart.getRowCount(); i++) {
                total += (Double) cart.getValueAt(i, j);
            }
            if (j == 1)
                total /= cart.getRowCount();
            row.add(total);
        }
        model.addRow(row.toArray());
    }

    //Client_window order button action
    public void order() {
        JTable cart = client_window.getTableCart();
        Order o = new Order(deliveryService.getCurrentPerson().getId(), LocalDateTime.now());
        List<MenuItem> list = new ArrayList<>();
        for (int i = 0; i < cart.getRowCount()-1; i++)
            list.add(deliveryService.findProduct((String) cart.getValueAt(i, 0)));
        int row=cart.getRowCount()-1;
        double rating=(double)cart.getValueAt(row,1);
        double calories=(double)cart.getValueAt(row,2);
        double proteins=(double)cart.getValueAt(row,3);
        double fats=(double)cart.getValueAt(row,4);
        double sodium=(double)cart.getValueAt(row,5);
        double price= (double) cart.getValueAt(row,6);
        MenuItem total=new BaseProduct("Total",rating,calories,proteins,fats,sodium,price);
        list.add(total);
        deliveryService.createOrder(o, list);
        FileManager.Bill(o,list);
        deliveryService.notifyUpdate("New " +o.toString());
    }

    //Client_window filterOut button action
    public void filterOut()
    {
        String title=client_window.getTextFieldName().getText();
        String rating= (String) client_window.getComboBoxRating().getSelectedItem();
        String calories= (String) client_window.getComboBoxCalories().getSelectedItem();
        String proteins= (String) client_window.getComboBoxProteins().getSelectedItem();
        String fats= (String) client_window.getComboBoxFats().getSelectedItem();
        String sodium= (String) client_window.getComboBoxSodium().getSelectedItem();
        String price= (String) client_window.getComboBoxPrice().getSelectedItem();
        assert rating != null;
        Double min_rating=choice_process(rating).get(0);
        Double max_rating=choice_process(rating).get(1);
        assert calories != null;
        Double min_calories=choice_process(calories).get(0);
        Double max_calories=choice_process(calories).get(1);
        assert proteins != null;
        Double min_proteins=choice_process(proteins).get(0);
        Double max_proteins=choice_process(proteins).get(1);
        assert fats != null;
        Double min_fats=choice_process(fats).get(0);
        Double max_fats=choice_process(fats).get(1);
        assert sodium != null;
        Double min_sodium=choice_process(sodium).get(0);
        Double max_sodium=choice_process(sodium).get(1);
        assert price != null;
        Double min_price=choice_process(price).get(0);
        Double max_price=choice_process(price).get(1);
        MenuItem minimum=new BaseProduct(title,min_rating,min_calories,min_proteins,min_fats,min_sodium,min_price);
        MenuItem maximum=new BaseProduct(title,max_rating,max_calories,max_proteins,max_fats,max_sodium,max_price);
        System.out.println(minimum);
        System.out.println(maximum);
        client_window.getTableProducts().setModel(setupProduct_table(deliveryService.filterOut(minimum,maximum)));
    }

    /**
     * The function receives a string containing the choice of the user
     * if the choice="No choice" then the number range is between negative and positive infinity
     * if the choice is the last one the range is between the last number and positive infinity
     * if the choice is any other the range is between the two number selected before and after '-'
     * @param choice a string formatted to find a number range
     * @return arraylist of two elements used as a range for filtering numbers between the 2 numbers
     */
    public ArrayList<Double> choice_process(String choice)
    {
        ArrayList<Double> range = new ArrayList<>();
        if(choice.contains("-"))
        {
            String[] split=choice.split("-");
            range.add(Double.valueOf(split[0]));
            range.add(Double.valueOf(split[1]));
        }
        else if(choice.contains("No"))
        {
            range.add(Double.NEGATIVE_INFINITY);
            range.add(Double.POSITIVE_INFINITY);
        }
        else
        {
            String split=choice.substring(0,choice.length()-1);
            range.add(Double.valueOf(split));
            range.add(Double.MAX_VALUE);
        }
        return range;
    }

    public void reportsGeneration()
    {
        int hourmin= Integer.parseInt(reports_frame.getTextFieldMinHour().getText());
        int hourmax= Integer.parseInt(reports_frame.getTextFieldMaxHour().getText());
        int productsordered=Integer.parseInt(reports_frame.getTextFieldProductsOrderd().getText());
        int client_amount=Integer.parseInt(reports_frame.getTextFieldClientsAmount().getText());
        int total_amount=Integer.parseInt(reports_frame.getTextFieldTotalPrice().getText());
        int products_date=Integer.parseInt(reports_frame.getTextFieldProductDay().getText());
        String date=reports_frame.getTextFieldDay().getText();
//        HashMap<Order,List<MenuItem>> orders=deliveryService.getOrders();
//        List<Order> keys= new ArrayList<>(orders.keySet());
////        System.out.println(keys=keys.stream().filter(order ->
////                order.getOrderDate().getHour()>=hourmin &&
////                        order.getOrderDate().getHour()<=hourmax
////        ).collect(Collectors.toList()));
        String report1=deliveryService.report1(hourmin,hourmax);
        String report2=deliveryService.report2(productsordered);
        String report3= deliveryService.report3(client_amount,total_amount);
        String report4=deliveryService.report4(products_date,date);
        FileManager.reports(report1,report2,report3,report4);
    }
}

