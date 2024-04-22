package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * @author Bram van Ham
 * Purpose for the class
 **/
@Entity
public class RecipeBook {
    @Id
    @GeneratedValue
    private Long recipeBookId;
    @Column(unique = true)
    private String nameOfRecipeBook;
    @ManyToMany
    private List<Recipe> listOfRecipes;

    public RecipeBook() {
    }

    public Long getRecipeBookId() {
        return recipeBookId;
    }

    public void setRecipeBookId(Long recipeBookId) {
        this.recipeBookId = recipeBookId;
    }

    public String getNameOfRecipeBook() {
        return nameOfRecipeBook;
    }

    public void setNameOfRecipeBook(String nameOfRecipeBook) {
        this.nameOfRecipeBook = nameOfRecipeBook;
    }

    public List<Recipe> getListOfRecipes() {
        return listOfRecipes;
    }

    public void setListOfRecipes(List<Recipe> listOfRecipes) {
        this.listOfRecipes = listOfRecipes;
    }
}
