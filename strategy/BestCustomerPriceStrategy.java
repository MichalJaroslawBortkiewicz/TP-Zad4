package strategy;

import java.util.List;

import discounts.IDiscount;
import discounts.PercentageDiscount;

import java.util.ArrayList;

public class BestCustomerPriceStrategy implements IStrategy{
    private List<IDiscount> discounts = new ArrayList<IDiscount>();


    public BestCustomerPriceStrategy(List<IDiscount> discounts){
        this.discounts = discounts;
    
        for(int i = 1; i < discounts.size(); i++){
            if(this.discounts.get(i) instanceof PercentageDiscount){
                this.discounts.add(0, this.discounts.remove(i));
            }
        }
    }


    @Override
    public double calcPrice(double price){
        double newPrice = price;

        for (IDiscount discount : discounts){
            newPrice = discount.applyDiscount(newPrice, price);
        }

        return newPrice;
    }

    public List<IDiscount> geDiscounts(){
        return discounts;
    }
}