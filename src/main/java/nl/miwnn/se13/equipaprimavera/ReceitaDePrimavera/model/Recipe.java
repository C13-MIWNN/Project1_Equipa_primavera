package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Set;

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
    @ManyToMany
    private Set<CategoryOfRecipe> categoryOfRecipe;

    public Recipe(String nameOfRecipe, String ingredientsOfRecipe, Set<CategoryOfRecipe> categoryOfRecipe) {
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

    public Set<CategoryOfRecipe> getCategoryOfRecipe() {
        return categoryOfRecipe;
    }

    public void setCategoryOfRecipe(Set<CategoryOfRecipe> categoryOfRecipe) {
        this.categoryOfRecipe = categoryOfRecipe;
    }
}