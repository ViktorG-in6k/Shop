package com.model.base;

import javax.persistence.*;

@MappedSuperclass
public abstract class Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

}