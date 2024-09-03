package MODEL;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@SuppressWarnings({"unused", "FieldMayBeFinal"})
public class DeliveryService extends Observable implements DeliveryServiceProcessing, Serializable {
    private HashMap<String, Person> people;
    private Set<MenuItem> products;
    private HashMap<Order, List<MenuItem>> Orders;
    private Person currentPerson;
    private List<Observer> employes = new ArrayList<>();

    public DeliveryService() {
        this.people = new HashMap<>();
        this.products = new HashSet<>();
        this.Orders = new HashMap<>();
    }

    public void hardcode() {
        this.addPerson(new Person("think", "basket", Job.ADMIN));
        this.addPerson(new Person("look", "bell", Job.CLIENT));
        this.addPerson(new Person("during", "basket", Job.EMPLOYEE));
        this.addPerson(new Person("confusion", "basket", Job.CLIENT));
        this.addPerson(new Person("client", "z", Job.CLIENT));
    }

    public void addObserver(Observer o) {
        employes.add(o);
    }

    public void removeObserver(Observer o) {
        employes.remove(o);
    }

    public void notifyUpdate(String notification) {
        employes.get(0).update(this, notification);
    }

    //Person Methods
    public void addPerson(Person person) {
        this.people.put(person.getUsername(), person);
    }

    public void removePerson(Person person) {
        people.remove(person.getUsername(), person);
    }

    public Person findPerson(String Username, String Password) {
        Person found = people.get(Username);
        if (found != null) {
            if (found.getPassword().equals(Password))
                return found;
            else
                return null;
        } else
            return null;
    }

    //Product methods
    @Override
    public void addProduct(MenuItem product) {
        products.add(product);
    }

    @Override
    public void removeProduct(MenuItem product) {
        products.remove(product);
    }

    @Override
    public MenuItem findProduct(String name) {
        System.out.println(name);
        for (MenuItem item : this.products)
            if (item.getTitle().equals(name))
                return item;
        return null;
    }

    public String report1(int hourmin, int hourmax) {
        Set<Order> keys = Orders.keySet();
        List<Order> found = keys.stream().filter(order ->
                order.getOrderDate().getHour() >= hourmin &&
                        order.getOrderDate().getHour() <= hourmax
        ).collect(Collectors.toList());
        String report = found.toString();
        return report;
    }

    public String report2(int numer) {
        HashMap<MenuItem, AtomicInteger> frecventa = new HashMap();
        Set<Order> keys = Orders.keySet();
        List<MenuItem> cart;
        for (Order order : keys) {
            cart = Orders.get(order);
            for (MenuItem item : cart) {
                if (frecventa.containsKey(item))
                    frecventa.get(item).incrementAndGet();
                else
                    frecventa.put(item, new AtomicInteger(1));
            }
        }
        List<MenuItem> filtru = frecventa.keySet()
                .stream()
                .filter(item -> frecventa.get(item).get() >= numer)
                .collect(Collectors.toList());
        String report2 = filtru.toString();
        return report2;
    }

    public String report3(int number, int value) {
        List<Integer> client_ids;
        Set<Order> keys = Orders.keySet();
        HashMap<Integer, AtomicInteger> frecventa = new HashMap<>();
        for (Order order : keys) {
            if (frecventa.containsKey(order.getOrderId()))
                frecventa.get(order.getOrderId()).incrementAndGet();
            else
                frecventa.put(order.getClientId(), new AtomicInteger(1));
        }
        client_ids = frecventa.keySet()
                .stream()
                .filter(integer -> frecventa.get(integer).get() > number)
                .collect(Collectors.toList());
        List<Person> clients = new ArrayList<>();
        for (String name : people.keySet()) {
            Person p = people.get(name);
            for (Integer i : client_ids) {
                if (p.getId() == i)
                    clients.add(p);
            }
        }
        String report3=clients.toString();
        return report3;
    }

    public String report4(int numer,String date)
    {
        HashMap<MenuItem, AtomicInteger> frecventa = new HashMap();
        Set<Order> keys = Orders.keySet();
        //LocalDateTime time=LocalDateTime.parse(date);
        //keys= (Set<Order>) keys.stream().filter(order -> order.getOrderDate()==LocalDateTime.now()).collect(Collectors.toList());
        List<MenuItem> cart;
        for (Order order : keys) {
            cart = Orders.get(order);
            for (MenuItem item : cart) {
                if (frecventa.containsKey(item))
                    frecventa.get(item).incrementAndGet();
                else
                    frecventa.put(item, new AtomicInteger(1));
            }
        }
        List<MenuItem> report=frecventa.keySet().stream().filter(item -> frecventa.get(item).get()>=numer).collect(Collectors.toList());
        String report4=report.toString();
        return null;
    }
    @Override
    public void createOrder(Order order, List<MenuItem> list) {
        Orders.put(order, list);
    }

    public Set<MenuItem> filterOut(MenuItem minimum, MenuItem maximum) {
        Set<MenuItem> result;
        result = products.stream().filter(menuItem ->
                menuItem.getTitle().contains(maximum.getTitle()) &&
                        menuItem.getRating() >= minimum.getRating() &&
                        menuItem.getRating() < maximum.getRating() &&
                        menuItem.getCalories() >= minimum.getCalories() &&
                        menuItem.getCalories() < maximum.getCalories() &&
                        menuItem.getProteins() >= minimum.getProteins() &&
                        menuItem.getProteins() < maximum.getProteins() &&
                        menuItem.getFats() >= minimum.getFats() &&
                        menuItem.getFats() < maximum.getFats() &&
                        menuItem.getSodium() >= minimum.getSodium() &&
                        menuItem.getSodium() < maximum.getSodium() &&
                        menuItem.getPrice() >= minimum.getPrice() &&
                        menuItem.getPrice() < maximum.getPrice()).collect(Collectors.toSet());
        return result;
    }

    //Getters
    public Person getCurrentPerson() {
        return currentPerson;
    }

    public void setCurrentPerson(Person currentPerson) {
        this.currentPerson = currentPerson;
    }

    public HashMap<String, Person> getPeople() {
        return people;
    }

    public Set<MenuItem> getProducts() {
        return products;
    }

    public void setProducts(Set<MenuItem> products) {
        this.products = products;
    }

    public HashMap<Order, List<MenuItem>> getOrders() {
        return Orders;
    }
}
