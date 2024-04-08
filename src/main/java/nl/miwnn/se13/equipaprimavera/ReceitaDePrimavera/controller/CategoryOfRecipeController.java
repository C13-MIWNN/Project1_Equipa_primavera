package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.controller;

import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.CategoryOfRecipe;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository.CategoryOfRecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Bram van Ham
 * Purpose for the class
 **/
@Controller
public class CategoryOfRecipeController {
    private final CategoryOfRecipeRepository categoryOfRecipeRepository;

    public CategoryOfRecipeController(CategoryOfRecipeRepository categoryOfRecipeRepository) {
        this.categoryOfRecipeRepository = categoryOfRecipeRepository;
    }

    @GetMapping("/category")
    private String showAllCategories(Model model) {
        model.addAttribute("allCategories", categoryOfRecipeRepository.findAll());
        model.addAttribute("newCategory", new CategoryOfRecipe());
        return "categoryOfRecipeOverview";
    }

    @PostMapping("/category")
    private String saveOrUpdateCategory(@ModelAttribute("newCategory") CategoryOfRecipe categoryOfRecipeToBeSaved,
                                 BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            categoryOfRecipeRepository.save(categoryOfRecipeToBeSaved);
        }
        return "redirect:/category";
    }
}
