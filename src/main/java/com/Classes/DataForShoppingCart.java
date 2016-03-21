package com.Classes;

import com.model.product;

import java.math.BigDecimal;

/**
 * Created by employee on 3/18/16.
 */
public class DataForShoppingCart {
    private  product prod = new product();
    private int countOfProducts = 0;
    private BigDecimal price;
   public DataForShoppingCart(product p, int c){
       prod=p;
       countOfProducts=c;
       price = prod.getPrice().multiply(new BigDecimal(countOfProducts));
   }
    private void total(){
        price = prod.getPrice().multiply(new BigDecimal(countOfProducts));
    }


    public int getCountOfProducts() {
        return countOfProducts;
    }

    public void setCountOfProducts(int countOfProducts) {


        this.countOfProducts = countOfProducts;
        total();
    }

    public product getProd() {
        return prod;
    }

    public void setProd(product prod) {
        this.prod = prod;

    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
