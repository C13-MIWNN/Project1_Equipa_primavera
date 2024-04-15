package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.controller;

import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.Recipe;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.RecipeBook;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository.RecipeBookRepository;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Bram van Ham
 * Handles all requests regarding RecipeBooks
 **/
@Controller
public class RecipeBookController {
    private final RecipeBookRepository recipeBookRepository;
    private final RecipeRepository recipeRepository;

    public RecipeBookController(RecipeBookRepository recipeBookRepository, RecipeRepository recipeRepository) {
        this.recipeBookRepository = recipeBookRepository;
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/book")
    private String showRecipeBookOverview(Model model) {
        model.addAttribute("allRecipeBooks", recipeBookRepository.findAll());
        model.addAttribute("newRecipeBook", new RecipeBook());
        return "recipeBookOverview";
    }

    @PostMapping("/book")
    private String saveOrUpdateRecipeBook(@ModelAttribute("newRecipeBook") RecipeBook recipeBookToBeSaved,
                                          BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            recipeBookRepository.save(recipeBookToBeSaved);
        }
        return "redirect:/book";
    }

    @GetMapping("/book/detail/{name}")
    private String showRecipeBookList(@PathVariable("name") String name, Model model) {
        Optional<RecipeBook> recipeBook = recipeBookRepository.findBynameOfRecipeBook(name);

        if (recipeBook.isEmpty()) {
            return "redirect:/book";
        }

        model.addAttribute("recipeBookToBeShown", recipeBook.get());
        model.addAttribute("showAllRecipesInRecipeBook", recipeBook.get().getListOfRecipes());
        return "recipeBookDetail";
    }

    @GetMapping("/book/detail/{name}/remove/{recipe}")
    private String removeRecipeFromRecipeBook(@PathVariable("name") String name,
                                              @PathVariable("recipe") String recipe) {

        Optional<RecipeBook> recipeBook = recipeBookRepository.findBynameOfRecipeBook(name);
        Optional<Recipe> optionalRecipe = recipeRepository.findByNameOfRecipe(recipe);

        if (recipeBook.isEmpty() || optionalRecipe.isEmpty()) {
            return "redirect:/book/";
        }

        recipeBook.get().getListOfRecipes().remove(optionalRecipe.get());
        recipeBookRepository.save(recipeBook.get());

        return "redirect:/book/detail/{name}";
    }

    @GetMapping("/book/add")
    private String addRecipeToRecipeBook(@RequestParam(name = "nameRecipe") String name,
                                         @RequestParam(name = "recipebook") Long bookId) {
        Optional<Recipe> recipe = recipeRepository.findByNameOfRecipe(name);
        Optional<RecipeBook> recipeBook = recipeBookRepository.findById(bookId);
        if (recipe.isEmpty() || recipeBook.isEmpty()) {
            return String.format("redirect:/recipe/detail/%s", name);
        }
        if (recipeBook.get().getListOfRecipes().contains(recipe.get())) {
            return String.format("redirect:/book/detail/%s", recipeBook.get().getNameOfRecipeBook());
        }
        recipeBook.get().getListOfRecipes().add(recipe.get());
        recipeBookRepository.save(recipeBook.get());
        return String.format("redirect:/book/detail/%s", recipeBook.get().getNameOfRecipeBook());
    }
}