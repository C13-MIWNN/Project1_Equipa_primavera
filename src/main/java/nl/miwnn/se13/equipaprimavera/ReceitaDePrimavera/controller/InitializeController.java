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
        CategoryOfRecipe italiaans = makeCategoryOfRecipe("Italiaans");
        CategoryOfRecipe aziatisch = makeCategoryOfRecipe("Aziatisch");
        CategoryOfRecipe mexicaans = makeCategoryOfRecipe("Mexicaans");

        Recipe lasagne = makeRecipe("Lasagne", italiaans);
        Recipe pizza = makeRecipe("Pizza", italiaans);
        Recipe nasiGoreng = makeRecipe("Nasi Goreng", aziatisch);
        Recipe tortilla = makeRecipe("Tortilla", mexicaans);

        RecipeBook mijnEersteReceptenboek = makeRecipeBook("Mijn eerste receptenboek", lasagne, pizza, nasiGoreng);
        RecipeBook vegetarischeRecepten = makeRecipeBook("Vegetarische recepten", lasagne,pizza, nasiGoreng);

        MeasurementUnit gram = makeMeasurementUnit("gram");
        MeasurementUnit milliliter = makeMeasurementUnit("milliliter");
        MeasurementUnit stuk = makeMeasurementUnit("stuk");
        MeasurementUnit theelepel = makeMeasurementUnit("theelepel");
        MeasurementUnit eetlepel = makeMeasurementUnit("eetlepel");

        Ingredient lasagnebladen = makeIngredient("Lasagnebladen", stuk);
        Ingredient gehakt = makeIngredient("Gehakt", gram);
        Ingredient paprika = makeIngredient("Paprika", stuk);
        Ingredient ui = makeIngredient("Ui", stuk);
        Ingredient champignons = makeIngredient("Champignons", gram);
        Ingredient tomatenblokjes = makeIngredient("Tomatenblokjes", gram);
        Ingredient oregano = makeIngredient("Oregano", theelepel);
        Ingredient paprikapoeder = makeIngredient("Paprikapoeder", theelepel);
        Ingredient cayennePoeder = makeIngredient("Cayenne poeder", theelepel);
        Ingredient geraspteKaas = makeIngredient("Geraspte kaas", gram);

        RecipeIngredient lasagneLasagnebladen = makeRecipeIngredient(lasagne, lasagnebladen, 12);
        RecipeIngredient lasagneGehakt = makeRecipeIngredient(lasagne, gehakt, 300);
        RecipeIngredient lasagnePaprika = makeRecipeIngredient(lasagne, paprika, 2);
        RecipeIngredient lasagneUi = makeRecipeIngredient(lasagne, ui, 1);
        RecipeIngredient lasagneChampignons = makeRecipeIngredient(lasagne, champignons, 250);
        RecipeIngredient lasagneTomatenblokjes = makeRecipeIngredient(lasagne, tomatenblokjes, 750);
        RecipeIngredient lasagneOregano = makeRecipeIngredient(lasagne, oregano, 1);
        RecipeIngredient lasagnePaprikapoeder = makeRecipeIngredient(lasagne, paprikapoeder, 1);
        RecipeIngredient lasagneCayennePoeder = makeRecipeIngredient(lasagne, cayennePoeder, 1);
        RecipeIngredient lasagneGeraspteKaas = makeRecipeIngredient(lasagne, geraspteKaas, 50);


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