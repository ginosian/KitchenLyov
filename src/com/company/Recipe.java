package com.company;

import java.util.ArrayList;

/**
 * Created by Marta on 3/14/2015.
 */
public class Recipe {
    // Instance Fields
    private ArrayList<Ingredient> ingredients;
    private String name;
    // endregion

    // region Constructors
    public Recipe(String name) {
        this.name = name;
        ingredients = new ArrayList<Ingredient>();
    }
    // endregion

    // region Member Methods
    public boolean containsIngredient(Ingredient ingredient) {
        for (int i = 0; i < ingredients.size(); i++) {
            if (ingredients.get(i).getName().equals(ingredient.getName())) {
                return true;
            }
        }
        return false;
    }
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }
    public void removeIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
    }
    @Override
    public String toString() {
        String descripion = "Name: " + name + "\n" + "Ingredients: " + ingredients.size() + "\n";
        for (int i = 0; i < ingredients.size(); i++) {
            descripion = String.join("", descripion, i+1 + ". ", ingredients.get(i) + "\n");
        }
        return descripion;
    }

    // region Setters and Getters
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    // endregion
}
