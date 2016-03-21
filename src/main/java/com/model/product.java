package com.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class product extends com.model.base.Entity{

    @ManyToOne
    @JoinColumn(name = "category_id")
    private categories categori_id;

    @Column
    private String name;

    @Column
    private BigDecimal price;

    public product(){
    }

    public product(String name){
        this.name = name;
    }

    public product(categories categori_id, String name, BigDecimal price){
        this.categori_id = categori_id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public categories getCategori_id() {
        return categori_id;
    }

    public void setCategori_id(categories categori_id) {
        this.categori_id = categori_id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}