package com.company;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Kitchen kitchen = new Kitchen();

        while (true) {
            if (menu(kitchen)) {
                return;
            }
        }



    }

    public static boolean menu(Kitchen kitchen) {
        System.out.println("1. Add ingridient");
        System.out.println("2. Remove ingridient");
        System.out.println("3. Add recept");
        System.out.println("4. Remove recept");
        System.out.println("5. Show ingridients list");
        System.out.println("6. Show recepts list");
        System.out.println("7. Show recept description");
        System.out.println("8. Cook a dish");
        System.out.println("9. Show ready dishes list");
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Enter the ingredient parameters: Name, Quantity, Unit Price...");
                kitchen.addIngredient(new Ingredient(scanner.next(), scanner.nextDouble(), scanner.nextDouble()));
                System.out.println("Ingredient successfully added!");
                return false;
            case 2:
                System.out.println("Choose the ingredient to remove:");
                kitchen.printIngredientInfo();
                Ingredient ingredient = chooseIngredient(kitchen);
                if (ingredient != null) {
                    kitchen.removeIngredient(ingredient);
                    System.out.println("Ingredient successfully removed!");
                    return false;
                }
                System.out.println("No such ingredient.");
                return false;
            case 3:
                if (kitchen.getIngredients().size() == 0) {
                    System.out.println("No ingredients specified!");
                    return false;
                }
                System.out.print("Enter the recipe name: ");
                Recipe recipe = new Recipe(scanner.next());
                kitchen.addRecipe(recipe);
                while (true) {
                    if (recipeMenu(kitchen, recipe)) {
                        break;
                    }
                }
                return false;
            case 4:
                System.out.println("Choose recipe to remove...");
                kitchen.printRecipeInfo();
                int recipeToRemove = scanner.nextInt() - 1;
                if (recipeToRemove >= 0 && recipeToRemove < kitchen.getRecipes().size()) {
                    kitchen.removeRecipe(kitchen.getRecipes().get(recipeToRemove));
                    System.out.println("Recipe Successfully removed!");
                    return false;
                }
                System.out.println("No such recipe!");
                return false;

            case 5:
                System.out.println("Ingredients are:");
                kitchen.printIngredientInfo();
                System.out.println();
                return false;
            case 6:
                if (kitchen.getRecipes().size() == 0) {
                    System.out.println("No recipes added!");
                    return false;
                }
                System.out.println("Recipes are:");
                kitchen.printRecipeInfo();
                return false;


        }
        System.out.println("Invalid command!");
        return false;
    }

    public static boolean recipeMenu(Kitchen kitchen, Recipe recipe) {
        System.out.println("1. Add Ingredient.");
        System.out.println("2. Back to main menu.");

        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Choose an ingredient:");
                Ingredient ingredient = chooseIngredient(kitchen);
                if (ingredient != null) {
                    if (recipe.containsIngredient(ingredient)) {
                        System.out.println("This ingredient already added to recipe!");
                        return false;
                    }
                    System.out.println("Enter quantity of ingredient: ");
                    recipe.addIngredient(ingredient.cloneForRecipe(scanner.nextDouble()));
                    System.out.println("Ingredient successfully added!");
                    return false;
                }
                System.out.println("No such ingredient!");
                return false;
            case 2:
                return true;
            default:
                System.out.println("Invalid command!");
                return false;
        }

    }

    public static Ingredient chooseIngredient(Kitchen kitchen) {
        kitchen.printIngredientInfo();
        int ingredientIndex = scanner.nextInt() - 1;
        if (ingredientIndex >= 0 && ingredientIndex < kitchen.getIngredients().size()) {
            return kitchen.getIngredients().get(ingredientIndex);
        }
        return null;
    }

}
