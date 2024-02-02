package app;

public class Product {
    private double price;
    private int quantity;

    Product(double price, int quantity){
        this.price = price;
        this.quantity = quantity;
    }


    public double getPrice() {
        return price * quantity;
    }
}
