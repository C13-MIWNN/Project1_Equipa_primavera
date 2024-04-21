package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera;

import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.Recipe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author Mirjam Schmitz
 * <p>
 * Test
 **/
class ExampleTest {
    @Test
    void shouldShowSimpleAssertion() {
        assertEquals(1,1);
    }


//    @Test // kan je testen of het aantal en/of de namen van de toegevoegde recipes in een recipebook kloppen?
//    @DisplayName("Should check all items in the list")
//    void shouldCheckAllRecipesInTheRecipeBook() {
//        List<Recipe> recipeList = List.of(, rec, 5, 7);
//
//        Assertions.assertAll(() -> assertEquals(2, recipeList.get(0)),
//                () -> assertEquals(, recipeList.get(1)),
//                () -> assertEquals(, recipeList.get(2)),
//                () -> assertEquals(, recipeList.get(3)));
//    }

}