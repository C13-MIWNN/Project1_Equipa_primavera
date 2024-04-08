package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * @author Bram van Ham
 * Purpose for the class
 **/
@Entity
public class Recipe {
    @Id @GeneratedValue
    private Long recipeId;
    private String nameOfRecipe;
    private String ingredientsOfRecipe;
    private String categoryOfRecipe;

    public Recipe(String nameOfRecipe, String ingredientsOfRecipe, String categoryOfRecipe) {
        this.nameOfRecipe = nameOfRecipe;
        this.ingredientsOfRecipe = ingredientsOfRecipe;
        this.categoryOfRecipe = categoryOfRecipe;
    }
    public Recipe() {
    }
    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public String getNameOfRecipe() {
        return nameOfRecipe;
    }

    public void setNameOfRecipe(String nameOfRecipe) {
        this.nameOfRecipe = nameOfRecipe;
    }

    public String getIngredientsOfRecipe() {
        return ingredientsOfRecipe;
    }

    public void setIngredientsOfRecipe(String ingredientsOfRecipe) {
        this.ingredientsOfRecipe = ingredientsOfRecipe;
    }

    public String getCategoryOfRecipe() {
        return categoryOfRecipe;
    }

    public void setCategoryOfRecipe(String categoryOfRecipe) {
        this.categoryOfRecipe = categoryOfRecipe;
    }
}
