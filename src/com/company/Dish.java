package com.company;

/**
 * Created by Marta on 3/14/2015.
 */
public class Dish {

    private String name;
    private int quantity;


    public Dish(String name) {
        this.name = name;
        this.quantity = 1;
    }

    @Override
    public String toString() {
        return name + ": " + quantity;
    }

    public void incrementQuantity() {
        ++quantity;
    }

    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
