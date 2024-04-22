package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.controller;

import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.*;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository.*;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.services.EquipaPrimaveraUserService;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
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

    private final EquipaPrimaveraUserService equipaPrimaveraUserService;

    public InitializeController(CategoryOfRecipeRepository categoryOfRecipeRepository,
                                RecipeRepository recipeRepository,
                                RecipeBookRepository recipeBookRepository,
                                MeasurementUnitRepository measurementUnitRepository,
                                IngredientRepository ingredientRepository,
                                RecipeIngredientRepository recipeIngredientRepository,
                                EquipaPrimaveraUserService equipaPrimaveraUserService) {
        this.categoryOfRecipeRepository = categoryOfRecipeRepository;
        this.recipeRepository = recipeRepository;
        this.recipeBookRepository = recipeBookRepository;
        this.measurementUnitRepository = measurementUnitRepository;
        this.ingredientRepository = ingredientRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.equipaPrimaveraUserService = equipaPrimaveraUserService;
    }

    @EventListener
    private void seed(ContextRefreshedEvent event) {
        if (equipaPrimaveraUserService.isNotInitialized()) {
            initializeDBRecipeAndRecipeBook();
        }
    }

    @GetMapping("/initialize")
    private String initializeDBRecipeAndRecipeBook() {
        makeEquipaPrimaveraUser("Bram", "Bram");
        makeEquipaPrimaveraUser("Mirjam", "Mirjam");
        makeEquipaPrimaveraUser("Vincent", "Vincent");


        String loremIpsum = new String("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor" +
                "incididunt ut labore et dolore magna aliqua. Nulla aliquet enim tortor at auctor urna nunc id cursus. " +
                "Nunc sed blandit libero volutpat sed cras ornare. Tellus integer feugiat scelerisque varius morbi enim." +
                " Sit amet volutpat consequat mauris nunc congue. Egestas egestas fringilla phasellus faucibus " +
                "scelerisque eleifend. Interdum posuere lorem ipsum dolor sit amet. Egestas diam in arcu cursus euismod " +
                "quis viverra nibh. Montes nascetur ridiculus mus mauris vitae. Semper auctor neque vitae tempus quam " +
                "pellentesque nec.\n" +
                "\n" +
                "Et odio pellentesque diam volutpat commodo sed. Ultrices vitae auctor eu augue ut lectus arcu bibendum." +
                " Odio pellentesque diam volutpat commodo sed egestas. Quis auctor elit sed vulputate mi sit amet. " +
                "Bibendum at varius vel pharetra vel turpis. Vitae justo eget magna fermentum iaculis eu non diam. " +
                "Ac ut consequat semper viverra nam libero justo laoreet. Ultrices gravida dictum fusce ut placerat " +
                "orci nulla pellentesque dignissim. Amet commodo nulla facilisi nullam. Mauris a diam maecenas sed enim " +
                "ut sem viverra. Eleifend mi in nulla posuere sollicitudin aliquam. Integer quis auctor elit sed " +
                "vulputate. Nullam ac tortor vitae purus faucibus ornare suspendisse. Id venenatis a condimentum vitae " +
                "sapien pellentesque habitant. Ipsum dolor sit amet consectetur adipiscing elit ut aliquam purus. " +
                "Aliquet enim tortor at auctor urna nunc id cursus. Et ultrices neque ornare aenean euismod elementum " +
                "nisi quis eleifend. Dictum fusce ut placerat orci nulla pellentesque dignissim enim. Mi in nulla " +
                "posuere sollicitudin aliquam ultrices. Aliquam sem fringilla ut morbi tincidunt augue interdum velit.");

        CategoryOfRecipe italian = makeCategoryOfRecipe("Italian");
        CategoryOfRecipe asian = makeCategoryOfRecipe("Asian");
        CategoryOfRecipe mexican = makeCategoryOfRecipe("Mexican");

        Recipe lasagne = makeRecipe("Lasagne", loremIpsum, italian);
        Recipe pizza = makeRecipe("Pizza", loremIpsum, italian);
        Recipe nasiGoreng = makeRecipe("Nasi Goreng", loremIpsum, asian);
        Recipe tortilla = makeRecipe("Tortilla", loremIpsum, mexican);

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

    private Recipe makeRecipe(String nameRecipe, String stepsOfRecipe, CategoryOfRecipe categoryOfRecipe) {
        Recipe recipe = new Recipe();
        recipe.setNameOfRecipe(nameRecipe);
        recipe.setStepsOfRecipe(stepsOfRecipe);

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

    private EquipaPrimaveraUser makeEquipaPrimaveraUser(String username, String password) {
        EquipaPrimaveraUser user = new EquipaPrimaveraUser();
        user.setUsername(username);
        user.setPassword(password);
        equipaPrimaveraUserService.saveUser(user);
        return user;
    }
}