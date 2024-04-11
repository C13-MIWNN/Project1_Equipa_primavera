package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

/**
 * @author Bram van Ham
 * Purpose for the class
 **/
@Entity
public class Recipe {
    @Id @GeneratedValue
    private Long recipeId;
    @Column(unique = true)
    private String nameOfRecipe;
//    @ElementCollection @OrderColumn Misschien later toch weer aan de praat krijgen met DTO
    private String stepsOfRecipe;

    private String ingredientsOfRecipe;
    @ManyToMany
    private Set<CategoryOfRecipe> categoryOfRecipe;

    public Recipe(String nameOfRecipe, String stepsOfRecipe, String ingredientsOfRecipe, Set<CategoryOfRecipe> categoryOfRecipe) {
        this.nameOfRecipe = nameOfRecipe;
        this.stepsOfRecipe = stepsOfRecipe;
        this.ingredientsOfRecipe = ingredientsOfRecipe;
        this.categoryOfRecipe = categoryOfRecipe;
    }

    public Recipe() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(recipeId, recipe.recipeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId);
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

    public String getStepsOfRecipe() {
        return stepsOfRecipe;
    }

    public void setStepsOfRecipe(String stepsOfRecipe) {
        this.stepsOfRecipe = stepsOfRecipe;
    }
}