package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model;

/**
 * @author Bram van Ham
 * Purpose for the class
 **/
public class Recipe {
    private Long recipeId;
    private String nameOfRecipe;
    private String ingredientsOfRecipe;
    private String categoryOfRecipe;

    //Todo kijken of we category nog moeten toevoegen aan de constructor
    public Recipe(String nameOfRecipe, String ingredientsOfRecipe) {
        this.nameOfRecipe = nameOfRecipe;
        this.ingredientsOfRecipe = ingredientsOfRecipe;
    }
    public Recipe() {
    }

}
