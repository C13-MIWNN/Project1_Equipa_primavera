package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.controller;

import jakarta.servlet.http.HttpServletRequest;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.*;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    private final RecipeBookRepository recipeBookRepository;
    private final IngredientRepository ingredientRepository;
    private final MeasurementUnitRepository measurementUnitRepository;

    public RecipeController(RecipeRepository recipeRepository, CategoryOfRecipeRepository categoryOfRecipeRepository, RecipeBookRepository recipeBookRepository, IngredientRepository ingredientRepository, MeasurementUnitRepository measurementUnitRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryOfRecipeRepository = categoryOfRecipeRepository;
        this.recipeBookRepository = recipeBookRepository;
        this.ingredientRepository = ingredientRepository;
        this.measurementUnitRepository = measurementUnitRepository;
    }

    @ModelAttribute("allIngredients")
    public List<Ingredient> allIngredients() {
        return ingredientRepository.findAll();
    }
    @ModelAttribute("allCategories")
    public List<CategoryOfRecipe> allCategories() {
        return categoryOfRecipeRepository.findAll();
    }
    @ModelAttribute("allMeasurementUnit")
    public List<MeasurementUnit> allMeasurementUnits() {
        return measurementUnitRepository.findAll();
    }

    @GetMapping({"/", "recipe"})
    private String showRecipeOverview(Model model) {
        model.addAttribute("allRecipes", recipeRepository.findAll());
        return "recipeOverview";
    }

    @GetMapping("/recipe/new")
    private String showRecipeForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "recipeForm";
    }

    @PostMapping("recipe/new")
    private String saveRecipe(@ModelAttribute("recipe") Recipe recipeToBeSaved,
                              BindingResult bindingResult) {
        if (recipeToBeSaved.getRecipeId()==null &&
                recipeRepository.findByNameOfRecipe(recipeToBeSaved.getNameOfRecipe()).isPresent()) {
            return "redirect:/recipe/new";
        }
        if (!bindingResult.hasErrors()) {
            recipeRepository.save(recipeToBeSaved);
        }

//        for (IngredientRow row : recipeToBeSaved.getRows()) {
//            ingredientRepository.findById(row.getNameOfIngredient())
//
//        }

        return String.format("redirect:/recipe/detail/%s", recipeToBeSaved.getNameOfRecipe());
    }

    @GetMapping("/recipe/detail/{name}")
    private String showRecipeDetails(@PathVariable("name") String name, Model model) {
        Optional<Recipe> recipe = recipeRepository.findByNameOfRecipe(name);


        if (recipe.isEmpty()) {
            return "redirect:/recipe";
        }

        model.addAttribute("recipeToBeShown", recipe.get());
        model.addAttribute("allRecipebooks", recipeBookRepository.findAll());
        return "recipeDetail";
    }

    @GetMapping("/recipe/detail/{name}/edit")
    private String showEditRecipeForm(@PathVariable("name") String name, Model model) {
        Optional<Recipe> recipe = recipeRepository.findByNameOfRecipe(name);
        if (recipe.isEmpty()) {
            return "redirect:/recipe";
        }
        model.addAttribute("recipe", recipe.get());
        model.addAttribute("allCategories", categoryOfRecipeRepository.findAll());
        return "recipeForm";
    }

    @RequestMapping(value="/recipe/new", params={"addRow"})
    public String addRow(final Recipe recipe, final BindingResult bindingResult) {
        IngredientRow row = new IngredientRow();
        row.setRecipe(recipe);
        recipe.getRows().add(new IngredientRow());
        return "recipeForm";
    }


    @RequestMapping(value="/recipe/new", params={"removeRow"})
    public String removeRow(final Recipe recipe, final BindingResult bindingResult, final HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
        recipe.getRows().remove(rowId.intValue());
        return "recipeForm";
    }
}