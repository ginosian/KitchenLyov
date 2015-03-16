package com.company;

import java.util.ArrayList;

/**
 * Created by Marta on 3/14/2015.
 */
public class Kitchen {

    private ArrayList<Ingredient> ingredients;
    private ArrayList<Recipe> recipes;
    private ArrayList<Dish> dishs;

    public Kitchen() {
        this.ingredients = new ArrayList<Ingredient>();
        this.recipes = new ArrayList<Recipe>();
        this.dishs = new ArrayList<Dish>();
    }

    public void printIngredientInfo() {
        for (int i = 0; i < ingredients.size(); i++) {
            System.out.println(i + 1 + ". " + ingredients.get(i));
        }
    }
    public void printRecipeInfo() {
        for (int i = 0; i < recipes.size(); i++) {
            System.out.println(i + 1 + ". " + recipes.get(i));
        }
    }
    public void printDishesInfo() {
        for (int i = 0; i < dishs.size(); i++) {
            System.out.println(i + 1 + ". " + dishs.get(i));
        }
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
    public void removeIngredient(Ingredient ingredient) {
        this.ingredients.remove(ingredient);
    }
    public void addRecipe(Recipe recipe) {
        this.recipes.add(recipe);
    }
    public void removeRecipe(Recipe recipe) {
        this.recipes.remove(recipe);
    }
    public void createDish(Recipe recipe) {
        for (int i = 0; i < dishs.size(); i++) {
            if (dishs.get(i).getName().equals(recipe.getName())) {
                dishs.get(i).incrementQuantity();
                return;
            }
        }
        this.dishs.add(new Dish(new String(recipe.getName())));
    }
    public void removeDish(Dish dish) {
        this.dishs.remove(dish);
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public ArrayList<Dish> getDishs() {
        return dishs;
    }
}
