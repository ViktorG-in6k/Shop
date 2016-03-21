package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class categories extends com.model.base.Entity{
    @Column
    private String name;

    @OneToMany
    @JoinColumn(name = "id")
    List<product> p;


    public List<product> getP() {
        return p;
    }

    public void setP(List<product> p) {
        this.p = p;
    }

    public categories(String name) {
        this.name = name;
    }

    public categories() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
