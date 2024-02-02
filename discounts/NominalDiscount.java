package discounts;

public class NominalDiscount implements IDiscount {
    private double discount;
    private double threshold;


    public NominalDiscount(double discount, double threshold){
        this.discount = discount;
        this.threshold = threshold;
    }

    public NominalDiscount(double discount){
        this(discount, 0);
    }


    @Override
    public double applyDiscount(double price, double startPrice) {
        if (startPrice >= threshold){
            double value = price - discount;
            return value >= 0 ? value : 0;
        }

        return price;
    }

}