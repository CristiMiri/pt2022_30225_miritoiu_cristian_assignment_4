package MODEL;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Objects;

@SuppressWarnings("unused")
public abstract class MenuItem implements Serializable {
    private String title;
    private double rating;
    private double calories;
    private double proteins;
    private double fats;
    private double sodium;
    private double price;

    //Constructor
    public MenuItem(String title, double rating, double calories, double proteins, double fats, double sodium, double price) {
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.sodium = sodium;
        this.price = price;
    }

    //Abstract methods
    public abstract double computePrice();

    //Getters
    public String getTitle() {
        return title;
    }

    //Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //ToString
    @Override
    public String toString() {
        DecimalFormat df=new DecimalFormat("#.##");
        return title + " "
                +df.format(rating) + " * "
                +df.format(calories) + " calories, "
                +df.format(proteins) + " proteins, "
                +df.format(fats) + " fats, "
                +df.format(sodium) + " sodium, "
                +df.format(price) + " ron \n ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem item = (MenuItem) o;
        return Objects.equals(title, item.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
