package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.controller;

import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.Recipe;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bram van Ham
 * Purpose for the class
 **/

@Controller
public class RecipeController {
    private final RecipeRepository recipeRepository;
    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }
    @GetMapping("/")
    private String showRecipeOverview(Model model) {
        model.addAttribute("allRecipes", recipeRepository.findAll());
        return "recipeOverview";
    }

}