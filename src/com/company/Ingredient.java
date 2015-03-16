package com.company;

/**
 * Created by Marta on 3/14/2015.
 */
public class Ingredient {
    // region Instance Fields
    private String name;
    private double quantity;
    private double unitPrice;
    // endregion
    // Constructors
    public Ingredient(String name, double quantity, double unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
    // endregion
    // region Member Methods

    @Override
    public String toString() {
        return "Name: " + name + "\tQuantity: " + quantity + "\tUnit price: " + unitPrice;
    }

    public Ingredient cloneForRecipe(double quantity) {
        return new Ingredient(this.name, quantity, this.unitPrice);
    }
    // region Setters and Getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    // endregion
}
