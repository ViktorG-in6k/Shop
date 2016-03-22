package com.model;


import javax.persistence.*;
import java.sql.Timestamp;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class shopping_cart extends com.model.base.Entity{





    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "product_order",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<product> products;

    public List<product> getProducts() {
        return products;
    }

    @Column
    private Timestamp date;

    @Column
    private String user_number;

    @Override
    public String toString() {
        return "shopping_cart{" +
                "professionList=" + products.toString() +

                '}';
    }

    public shopping_cart(){
    }
    public shopping_cart(String user_number,List<product>products, java.util.Date date){
         this.date = new Timestamp(date.getTime());;
        this.user_number = user_number;
        this.products = products;
    }


    public String getUser_number() {
        return user_number;
    }

    public void setUser_number(String user_number) {
        this.user_number = user_number;
    }


}
