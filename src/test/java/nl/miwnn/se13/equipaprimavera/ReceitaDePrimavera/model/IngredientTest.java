package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Mirjam Schmitz
 * <p>
 * Purpose for the class
 **/
class IngredientTest {

    @Test
    @DisplayName("Total of ingredients per recipe")
    void getTotalNumberOfRecipeIngredients() {
        //Arrange
        Recipe recipe = new Recipe();
        int expectedTotalRecipeIngredients = 0;

        //Act
        int actualTotalIngredients = recipe.getTotalNumberOfRecipeIngredients();

        // Assert
        assertEquals(expectedTotalRecipeIngredients, actualTotalIngredients);
    }

    @Test
    @DisplayName("Total of ingredients for this recipe is three")
    void totalOfIngredientsForThisRecipeIsTree() {
        //Arrange
        Recipe recipe = new Recipe();
        recipe.setNameOfRecipe("Lasagna");

        Ingredient ingredient = new Ingredient("salt", new MeasurementUnit("gr"));
        Ingredient ingredient2 = new Ingredient("water", new MeasurementUnit("ml"));
        Ingredient ingredient3 = new Ingredient("sugar", new MeasurementUnit("gr"));

        List<RecipeIngredient> recipeIngredients = new ArrayList<>();

        recipeIngredients.add(new RecipeIngredient(recipe, ingredient, 100));
        recipeIngredients.add(new RecipeIngredient(recipe, ingredient2, 100));
        recipeIngredients.add(new RecipeIngredient(recipe, ingredient3, 100));

        recipe.setRecipeIngredients(recipeIngredients);

        int expectedTotalOfIngredientsForThisRecipe = 3;

        // Act
        int actualTotal = recipe.getTotalNumberOfRecipeIngredients();

        // Assert
        assertEquals(expectedTotalOfIngredientsForThisRecipe, actualTotal);


    }





}