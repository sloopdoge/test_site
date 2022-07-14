package com.sloopdoge.blog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/* Class for receiving and transferring data from a database  */
@Entity
public class Items {

    /* Every element in database will have unique id */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int num;
    private double price;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* Empty constructor */
    public Items() {
    }

    /* Constructor to save elements */
    public Items(int num, double price, String name) {
        this.num = num;
        this.price = price;
        this.name = name;
    }
}
