package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.controller;

import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.CategoryOfRecipe;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.Recipe;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.RecipeBook;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository.CategoryOfRecipeRepository;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository.RecipeBookRepository;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository.RecipeRepository;
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

    public InitializeController(CategoryOfRecipeRepository categoryOfRecipeRepository,
                                RecipeRepository recipeRepository, RecipeBookRepository recipeBookRepository) {
        this.categoryOfRecipeRepository = categoryOfRecipeRepository;
        this.recipeRepository = recipeRepository;
        this.recipeBookRepository = recipeBookRepository;
    }

    @GetMapping("/initialize")
    private String initializeDB() {
        CategoryOfRecipe italiaans = makeCategoryOfRecipe("Italiaans");
        CategoryOfRecipe aziatisch = makeCategoryOfRecipe("Aziatisch");
        CategoryOfRecipe mexicaans = makeCategoryOfRecipe("Mexicaans");

        Recipe lasagne = makeRecipe("Lasagne", italiaans);
        Recipe pizza = makeRecipe("Pizza", italiaans);
        Recipe nasiGoreng = makeRecipe("Nasi Goreng", aziatisch);
        Recipe tortilla = makeRecipe("Tortilla", mexicaans);

        RecipeBook mijnEersteReceptenboek = makeRecipeBook("Mijn eerste receptenboek", lasagne, pizza, nasiGoreng);
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

}

