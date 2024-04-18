package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.controller;

import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.*;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class InitializeController {
    private final CategoryOfRecipeRepository categoryOfRecipeRepository;
    private final RecipeRepository recipeRepository;
    private final RecipeBookRepository recipeBookRepository;
    private final MeasurementUnitRepository measurementUnitRepository;
    private final IngredientRepository ingredientRepository;
    private final RecipeIngredientRepository recipeIngredientRepository;

    public InitializeController(CategoryOfRecipeRepository categoryOfRecipeRepository,
                                RecipeRepository recipeRepository,
                                RecipeBookRepository recipeBookRepository,
                                MeasurementUnitRepository measurementUnitRepository,
                                IngredientRepository ingredientRepository,
                                RecipeIngredientRepository recipeIngredientRepository) {
        this.categoryOfRecipeRepository = categoryOfRecipeRepository;
        this.recipeRepository = recipeRepository;
        this.recipeBookRepository = recipeBookRepository;
        this.measurementUnitRepository = measurementUnitRepository;
        this.ingredientRepository = ingredientRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
    }

    @GetMapping("/initialize")
    private String initializeDBRecipeAndRecipeBook() {
        CategoryOfRecipe italian = makeCategoryOfRecipe("Italian");
        CategoryOfRecipe asian = makeCategoryOfRecipe("Asian");
        CategoryOfRecipe mexican = makeCategoryOfRecipe("Mexican");

        Recipe lasagne = makeRecipe("Lasagne", italian);
        Recipe pizza = makeRecipe("Pizza", italian);
        Recipe nasiGoreng = makeRecipe("Nasi Goreng", asian);
        Recipe tortilla = makeRecipe("Tortilla", mexican);

        RecipeBook myFirstRecipebook = makeRecipeBook("My first recipebook", lasagne, pizza, nasiGoreng);
        RecipeBook vegetarianRecipes = makeRecipeBook("Vegetarian recipes", lasagne,pizza, nasiGoreng);

        MeasurementUnit gr = makeMeasurementUnit("gr");
        MeasurementUnit ml = makeMeasurementUnit("ml");
        MeasurementUnit x = makeMeasurementUnit(" x ");
        MeasurementUnit tspn = makeMeasurementUnit("tspn");
        MeasurementUnit tbsp = makeMeasurementUnit("tbsp");
        MeasurementUnit pinch = makeMeasurementUnit("pinch");

        Ingredient lasagnaSheets = makeIngredient("Lasagna sheets", x);
        Ingredient groundBeef = makeIngredient("Ground beef", gr);
        Ingredient paprika = makeIngredient("Paprika", x);
        Ingredient onion = makeIngredient("Onion", x);
        Ingredient mushroom = makeIngredient("Mushroom", gr);
        Ingredient crushedTomatos = makeIngredient("Crushed tomatos", gr);
        Ingredient oregano = makeIngredient("Oregano", tspn);
        Ingredient paprikapowder = makeIngredient("Paprikapowder", tspn);
        Ingredient cayennepowder = makeIngredient("Cayennepowder", tspn);
        Ingredient gradedCheese = makeIngredient("Graded cheese", gr);

        RecipeIngredient lasagneLasagnebladen = makeRecipeIngredient(lasagne, lasagnaSheets, 12);
        RecipeIngredient lasagneGehakt = makeRecipeIngredient(lasagne, groundBeef, 300);
        RecipeIngredient lasagnePaprika = makeRecipeIngredient(lasagne, paprika, 2);
        RecipeIngredient lasagneUi = makeRecipeIngredient(lasagne, onion, 1);
        RecipeIngredient lasagneChampignons = makeRecipeIngredient(lasagne, mushroom, 250);
        RecipeIngredient lasagneTomatenblokjes = makeRecipeIngredient(lasagne, crushedTomatos, 750);
        RecipeIngredient lasagneOregano = makeRecipeIngredient(lasagne, oregano, 1);
        RecipeIngredient lasagnePaprikapoeder = makeRecipeIngredient(lasagne, paprikapowder, 1);
        RecipeIngredient lasagneCayennePoeder = makeRecipeIngredient(lasagne, cayennepowder, 1);
        RecipeIngredient lasagneGeraspteKaas = makeRecipeIngredient(lasagne, gradedCheese, 50);


        return "redirect:/";
    }


    private CategoryOfRecipe makeCategoryOfRecipe(String nameOfCategory) {

        CategoryOfRecipe categoryOfRecipe = new CategoryOfRecipe();
        categoryOfRecipe.setNameOfCategoryOfRecipe(nameOfCategory);
        categoryOfRecipeRepository.save(categoryOfRecipe);
        return categoryOfRecipe;
    }

    private RecipeBook makeRecipeBook(String nameOfRecipeBook, Recipe recipe, Recipe recipe1, Recipe recipe2) {
        RecipeBook recipeBook = new RecipeBook();
        recipeBook.setNameOfRecipeBook(nameOfRecipeBook);

        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(recipe);
        recipeList.add(recipe1);
        recipeList.add(recipe2);

        recipeBook.setListOfRecipes(recipeList);

        recipeBookRepository.save(recipeBook);
        return recipeBook;
    }

    private Recipe makeRecipe(String nameRecipe, CategoryOfRecipe categoryOfRecipe) {
        Recipe recipe = new Recipe();
        recipe.setNameOfRecipe(nameRecipe);

        Set<CategoryOfRecipe> categoryOfRecipeSet = new HashSet<>();
        categoryOfRecipeSet.add(categoryOfRecipe);
        recipe.setCategoryOfRecipe(categoryOfRecipeSet);

        recipeRepository.save(recipe);
        return recipe;
    }

    private MeasurementUnit makeMeasurementUnit(String nameMeasurementUnit) {
        MeasurementUnit measurementUnit = new MeasurementUnit();
        measurementUnit.setNameOfMeasurement(nameMeasurementUnit);
        measurementUnitRepository.save(measurementUnit);
        return measurementUnit;
    }

    private Ingredient makeIngredient(String nameIngredient, MeasurementUnit measurementUnit) {
        Ingredient ingredient = new Ingredient(nameIngredient, measurementUnit);
        ingredientRepository.save(ingredient);
        return ingredient;
    }

    private RecipeIngredient makeRecipeIngredient(Recipe recipe, Ingredient ingredient, int amountOfIngredient) {
        RecipeIngredient recipeIngredient = new RecipeIngredient(recipe, ingredient, amountOfIngredient);
        recipeIngredientRepository.save(recipeIngredient);
        return recipeIngredient;
    }
}