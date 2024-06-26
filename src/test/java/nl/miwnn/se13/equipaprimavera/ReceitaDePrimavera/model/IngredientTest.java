package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        int actualTotalIngredients = recipe.totalNumberOfRecipeIngredients();

        // Assert
        assertEquals(expectedTotalRecipeIngredients, actualTotalIngredients);
    }

    @Test
    @DisplayName("Total of ingredients for this recipe is three")
    void totalOfIngredientsForThisRecipeIsThree() {
        //Arrange
        Recipe recipe = new Recipe();
        recipe.setNameOfRecipe("Lasagna");

        Ingredient ingredient = new Ingredient("salt", makeMeasurementUnit("gr"));
        Ingredient ingredient2 = new Ingredient("water", makeMeasurementUnit("ml"));
        Ingredient ingredient3 = new Ingredient("sugar", makeMeasurementUnit("gr"));

        List<RecipeIngredient> recipeIngredients = new ArrayList<>();

        recipeIngredients.add(new RecipeIngredient(recipe, ingredient, 100));
        recipeIngredients.add(new RecipeIngredient(recipe, ingredient2, 100));
        recipeIngredients.add(new RecipeIngredient(recipe, ingredient3, 100));

        recipe.setRecipeIngredients(recipeIngredients);

        int expectedTotalOfIngredientsForThisRecipe = 3;
        int notExpectedTotalOfIngredientsForThisRecipe = 4;

        // Act
        int actualTotal = recipe.totalNumberOfRecipeIngredients();

        // Assert
        assertEquals(expectedTotalOfIngredientsForThisRecipe, actualTotal);
        assertNotEquals(notExpectedTotalOfIngredientsForThisRecipe, actualTotal);

    }

    private MeasurementUnit makeMeasurementUnit(String nameMeasurementUnit) {
        MeasurementUnit measurementUnit = new MeasurementUnit();
        measurementUnit.setNameOfMeasurement(nameMeasurementUnit);
        return measurementUnit;
    }

}