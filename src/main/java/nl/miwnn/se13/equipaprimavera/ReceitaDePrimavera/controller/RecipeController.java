package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.controller;

import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.Recipe;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository.CategoryOfRecipeRepository;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Bram van Ham
 * Purpose for the class
 **/

@Controller
public class RecipeController {
    private final RecipeRepository recipeRepository;
    private final CategoryOfRecipeRepository categoryOfRecipeRepository;

    public RecipeController(RecipeRepository recipeRepository, CategoryOfRecipeRepository categoryOfRecipeRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryOfRecipeRepository = categoryOfRecipeRepository;
    }

    @GetMapping({"/", "recipe"})
    private String showRecipeOverview(Model model) {
        model.addAttribute("allRecipes", recipeRepository.findAll());
        return "recipeOverview";
    }
    @GetMapping("/recipe/new")
    private String showRecipeForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("allCategories", categoryOfRecipeRepository.findAll());
        return "recipeForm";
    }

    @PostMapping("recipe/new")
    private String saveRecipe(@ModelAttribute("recipe") Recipe recipeToBeSaved,
                              BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            recipeRepository.save(recipeToBeSaved);
        }
        return "redirect:/recipe";
    }
    @GetMapping("/recipe/detail/{name}")
    private String showRecipeDetails(@PathVariable("name") String name, Model model) {
        Optional<Recipe> recipe = recipeRepository.findByNameOfRecipe(name);

        if (recipe.isEmpty()) {
            return "redirect:/recipe";
        }

        model.addAttribute("recipeToBeShown", recipe.get());
        return "recipeDetail";
    }
}