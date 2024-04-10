package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.controller;

import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.Recipe;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.RecipeBook;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository.RecipeBookRepository;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
}