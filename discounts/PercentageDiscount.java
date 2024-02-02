package discounts;

public class PercentageDiscount implements IDiscount{
    private double percentage;
    private double threshold;

    public PercentageDiscount(double percentage, double threshold){
        this.percentage = percentage;
        this.threshold = threshold;
    }

    public PercentageDiscount(double percentage){
        this(percentage, 0);
    }


    @Override
    public double applyDiscount(double price, double startPrice) {
        if (startPrice >= threshold){
            return price * percentage;
        }

        return price;
    }
}
