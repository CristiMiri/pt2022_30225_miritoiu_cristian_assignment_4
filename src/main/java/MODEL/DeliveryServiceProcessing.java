package MODEL;

import java.util.List;

public interface DeliveryServiceProcessing {
    //Person methods
    public void addPerson(Person person);
    public void removePerson(Person person);
    public Person findPerson(String Username,String Password);
    //Products methods
    public void addProduct(MenuItem product);
    public void removeProduct(MenuItem product);
    public MenuItem findProduct(String name);
    //Order methods
    public void createOrder(Order order, List<MenuItem> list);
}
