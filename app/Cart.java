package app;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Product> products;
    
    Cart(List<Product> products){
        this.products = products;
    }

    Cart(){
        products = new ArrayList<Product>();
    }


    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(int ind){
        products.remove(ind);
    }

    public float getPrice(){
        float price = 0;

        for(Product product : products){
            price += product.getPrice();
        }

        return price;
    }
    
}
