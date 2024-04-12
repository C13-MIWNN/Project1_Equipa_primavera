package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.controller;

import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.Ingredient;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository.IngredientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mirjam Schmitz
 * <p>
 * Handels everthing with ingredients
 **/
@Controller
public class IngredientController {
    private final IngredientRepository ingredientRepository;

    public IngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    @GetMapping("/ingredient")
    private String showIngredientOverview(Model model) {
        model.addAttribute("allIngredients", ingredientRepository.findAll());
        return "ingredientOverview";
    }

    @GetMapping("/ingredient/new")
    private String showIngredientForm(Model model) {
        model.addAttribute("ingredient", new Ingredient());
        return "ingredientForm";
    }

    @PostMapping("/ingredient/new")
    private String saveIngredient(@ModelAttribute("ingredient") Ingredient ingredientToBeSaved,
                                  BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            ingredientRepository.save(ingredientToBeSaved);
        }
        return "redirect:/ingredient";
    }
}
