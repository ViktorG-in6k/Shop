package com.Classes;

import java.math.BigDecimal;
import java.util.ArrayList;


public class Order {
    private ArrayList<DataForShoppingCart>order = new ArrayList<DataForShoppingCart>();
    private BigDecimal totalPrice = new BigDecimal(0);

    public ArrayList<DataForShoppingCart> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<DataForShoppingCart> order) {
        this.order = order;
        totalPrice = new BigDecimal(0);
        for (DataForShoppingCart d:order) {
            totalPrice = totalPrice.add(d.getPrice());
        }
    }

    public void addToOrder(DataForShoppingCart data) {
            System.out.println(data.getPrice());
            boolean k = false;
            for (DataForShoppingCart aDataForShoppingCart : order) {
                if (aDataForShoppingCart.getProd().getId() == data.getProd().getId()) {
                    aDataForShoppingCart.setCountOfProducts(aDataForShoppingCart.getCountOfProducts()+1);
                    k = true;
                    break;
                }
            }
            if(!k){
                order.add(data);
            }

        totalPrice = totalPrice.add(data.getPrice());
        System.out.println(totalPrice.doubleValue());
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
    public void rePrice() {
        totalPrice = new BigDecimal(0);
        for (DataForShoppingCart d: order) {
            totalPrice = totalPrice.add(d.getPrice());
        }
    }
}
