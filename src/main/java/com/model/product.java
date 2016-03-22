package com.model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class product extends com.model.base.Entity{

    @ManyToOne
    @JoinColumn(name = "category_id")
    private categories category_id;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "product_order",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<shopping_cart> subjectList;
    public List<shopping_cart> getSubjectList() {
        return subjectList;
    }

    @Column
    private String name;

    @Column
    private BigDecimal price;

    public product(){
    }

    public product(String name){
        this.name = name;
    }

    public product(categories category_id, String name, BigDecimal price){
        this.category_id = category_id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public categories getCategory_id() {
        return category_id;
    }
}
