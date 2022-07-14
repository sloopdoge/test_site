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
    private Long id;

    private Integer num;
    private Double price;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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
    public Items(Integer num, Double price, String name) {
        this.num = num;
        this.price = price;
        this.name = name;
    }
}
