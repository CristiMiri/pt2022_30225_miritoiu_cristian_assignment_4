package MODEL;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unused"})
public class CompositeProduct extends MenuItem {
    private Set<MenuItem> menu;

    //Constructor
    public CompositeProduct(String title, double rating, double calories, double proteins, double fats, double sodium, double price) {
        super(title, rating, calories, proteins, fats, sodium, price);
        menu=new HashSet<>();
    }

    //Abstract method
    @Override
    public double computePrice() {
        double total= menu.stream().mapToDouble(MenuItem::getPrice).sum();
        super.setPrice(total);
        return total;
    }

    //Set menu methods

    public void addProduct(MenuItem product){
        menu.add(product);
    }

    public void removeProduct(MenuItem product)
    {
        menu.remove(product);
    }

    public MenuItem findProduct(String name)
    {
        for(MenuItem item:this.menu)
            if (item.getTitle().equals(name))
                return item;
        return null;
    }

    //Getters
    public Set<MenuItem> getMenu() {
        return menu;
    }

    //Setters
    public void setMenu(Set<MenuItem> menu) {
        this.menu = menu;
    }

}
