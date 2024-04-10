package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.controller;

import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.CategoryOfRecipe;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.Recipe;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository.CategoryOfRecipeRepository;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class initializeController {
    private final CategoryOfRecipeRepository categoryOfRecipeRepository;
    private final RecipeRepository recipeRepository;

    public initializeController(CategoryOfRecipeRepository categoryOfRecipeRepository,
                                RecipeRepository recipeRepository) {
        this.categoryOfRecipeRepository = categoryOfRecipeRepository;
        this.recipeRepository = recipeRepository;
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

        return "redirect:/";
    }

    private CategoryOfRecipe makeCategoryOfRecipe(String nameOfCategory) {
        CategoryOfRecipe categoryOfRecipe = new CategoryOfRecipe();
        categoryOfRecipe.setNameOfCategoryOfRecipe(nameOfCategory);
        categoryOfRecipeRepository.save(categoryOfRecipe);
        return categoryOfRecipe;
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

