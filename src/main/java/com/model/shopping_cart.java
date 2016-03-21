package com.model;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class shopping_cart extends com.model.base.Entity{

  //  private ArrayList<product> prod = new ArrayList<product>();
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "product_order",
//            //foreign key for orderEntity in product_order table
//            joinColumns = @JoinColumn(name = "order_id"),
//            //foreign key for other side - EmployeeEntity in employee_car table
//            inverseJoinColumns = @JoinColumn(name = "product_id"))
//    public ArrayList<product> getProductsFromCategory () {
//        return prod;
//    }

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "product_order",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<product> professionList;

    public List<product> getProductsList() {
        return professionList;
    }

    @Column
    private int user_id;

    @Override
    public String toString() {
        return "shopping_cart{" +
                "professionList=" + professionList.toString() +
                ", user_id=" + user_id +
                '}';
    }

    public shopping_cart(){
    }


}
