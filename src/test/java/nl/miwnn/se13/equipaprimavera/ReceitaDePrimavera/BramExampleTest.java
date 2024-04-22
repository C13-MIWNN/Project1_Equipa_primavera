package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera;


import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.Recipe;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.RecipeBook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bram van Ham
 * Purpose for the class
 **/
class BramExampleTest {
    @Test
    @DisplayName("How many recipes are in a recipebook")
    void howManyRecipesAreInARecipebook() {

        Recipe lasagne = new Recipe();
        Recipe pizza = new Recipe();
        Recipe tortilla = new Recipe();

        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(lasagne);
        recipeList.add(pizza);
        recipeList.add(tortilla);

        RecipeBook recipeBook = new RecipeBook();

        recipeBook.setListOfRecipes(recipeList);

        //Onzinnig test, maar ik weet niet wat ik anders moet testen want we hebben geen methodes in
        //onze models en om nou een methode te gaan maken waarin wat hieronder staat heeft ook niet echt zin
        Assertions.assertEquals(3, recipeBook.getListOfRecipes().size());
    }
}
