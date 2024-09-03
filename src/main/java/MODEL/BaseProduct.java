package MODEL;

@SuppressWarnings("unused")
public class BaseProduct extends MenuItem {

    //Constructor
    public BaseProduct(String title, double rating, double calories, double proteins, double fats, double sodium, double price) {
        super(title, rating, calories, proteins, fats, sodium, price);
    }

    //Abstract methods
    @Override
    public double computePrice() {
        return super.getPrice();
    }

}
