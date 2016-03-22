package com.model;

import javax.persistence.*;

@Entity
public class user{




    @Column
    private String name;

    @Id
    private String number;

    public user(String name,String number) {
        this.name = name;
        this.number = number;
    }

    public user(String name) {
        this.name = name;
    }

    public user() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
