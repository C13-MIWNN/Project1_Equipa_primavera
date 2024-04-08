package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * @author Bram van Ham
 * Purpose for the class
 **/
@Entity
public class CategoryOfRecipe {
    @Id    @GeneratedValue
    private Long categoryOfRecipeId;
    private String nameOfCategoryOfRecipe;

    public CategoryOfRecipe(String nameOfCategoryOfRecipe) {
        this.nameOfCategoryOfRecipe = nameOfCategoryOfRecipe;
    }
    public CategoryOfRecipe() {
    }
    public Long getCategoryOfRecipeId() {
        return categoryOfRecipeId;
    }

    public void setCategoryOfRecipeId(Long categoryOfRecipeId) {
        this.categoryOfRecipeId = categoryOfRecipeId;
    }

    public String getNameOfCategoryOfRecipe() {
        return nameOfCategoryOfRecipe;
    }

    public void setNameOfCategoryOfRecipe(String nameOfCategoryOfRecipe) {
        this.nameOfCategoryOfRecipe = nameOfCategoryOfRecipe;
    }
}
