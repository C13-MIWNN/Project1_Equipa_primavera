package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model;

import jakarta.persistence.*;

/**
 * @author Bram van Ham
 * To link a ingredient to a recipe
 **/
@Entity
public class RecipeIngredient {
    @Id
    @GeneratedValue
    private Long recipeIngredientId;
    @ManyToOne
    private Recipe recipe;
    @ManyToOne
    private Ingredient ingredient;
    private int amountOfIngredient;

    public RecipeIngredient(Recipe recipe, Ingredient ingredient, int amountOfIngredient) {
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.amountOfIngredient = amountOfIngredient;
    }

    public RecipeIngredient() {
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public int getAmountOfIngredient() {
        return amountOfIngredient;
    }

    public void setAmountOfIngredient(int amountOfIngredient) {
        this.amountOfIngredient = amountOfIngredient;
    }
}