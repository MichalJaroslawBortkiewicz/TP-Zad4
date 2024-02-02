package app;

import java.util.ArrayList;
import java.util.List;

import discounts.IDiscount;
import discounts.NominalDiscount;
import discounts.PercentageDiscount;
import strategy.IStrategy;
import strategy.BestCustomerPriceStrategy;
import strategy.BestShopPriceStrategy;
import strategy.ConcreateStrategy;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();

        Product monitor = new Product(799.99, 5);
        Product computer = new Product(2499.99, 3);
        
        cart.addProduct(monitor);
        cart.addProduct(computer);

        List<IDiscount> discounts = new ArrayList<IDiscount>();

        PercentageDiscount pdm15t100 = new PercentageDiscount(0.85, 100);
        PercentageDiscount pdm8t10000 = new PercentageDiscount(0.92, 10000);
        PercentageDiscount pdm2 = new PercentageDiscount(0.98);

        NominalDiscount ndm100t1000 = new NominalDiscount(100, 1000);
        NominalDiscount ndm1000t5000 = new NominalDiscount(1000, 5000);
        NominalDiscount ndm700 = new NominalDiscount(700);


        discounts.add(pdm15t100);
        discounts.add(pdm2);
        discounts.add(pdm8t10000);

        discounts.add(ndm100t1000);
        discounts.add(ndm1000t5000);
        discounts.add(ndm700);


        BestCustomerPriceStrategy bestCustomerPriceStrategy = new BestCustomerPriceStrategy (new ArrayList<IDiscount>(discounts));
        BestShopPriceStrategy bestShopPriceStrategy = new BestShopPriceStrategy (discounts);

        List<IStrategy> strategies = new ArrayList<IStrategy>();

        strategies.add(bestCustomerPriceStrategy);
        strategies.add(bestShopPriceStrategy);

        ConcreateStrategy concreateStrategy = new ConcreateStrategy(strategies);
        double p1 = concreateStrategy.calcPrice(cart.getPrice());
        concreateStrategy.nextStrategy();
        double p2 = concreateStrategy.calcPrice(cart.getPrice());

        System.out.println(p1);
        System.out.println(p2);
    }

}
