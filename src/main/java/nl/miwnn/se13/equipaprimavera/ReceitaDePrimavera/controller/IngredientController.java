package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.controller;

import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.Ingredient;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository.IngredientRepository;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository.MeasurementUnitRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Mirjam Schmitz
 * <p>
 * Handels everthing with ingredients
 **/
@Controller
public class IngredientController {
    private final IngredientRepository ingredientRepository;
    private final MeasurementUnitRepository measurementUnitRepository;

    public IngredientController(IngredientRepository ingredientRepository,
                                MeasurementUnitRepository measurementUnitRepository) {
        this.ingredientRepository = ingredientRepository;
        this.measurementUnitRepository = measurementUnitRepository;
    }

//voor je overzicht
    @GetMapping("/ingredient")
    private String showIngredientOverview(Model model) {
        model.addAttribute("allIngredients", ingredientRepository.findAll());
        model.addAttribute("newIngredient", new Ingredient());
        model.addAttribute("allMeasurementTypes", measurementUnitRepository.findAll());
        return "ingredientOverview";
    }

    @PostMapping( "/ingredient")
    private String saveIngredient(@ModelAttribute("ingredient") Ingredient ingredientToBeSaved,
                                  BindingResult bindingResult) {
        if (ingredientToBeSaved.getIngredientId()==null &&
                ingredientRepository.findByNameIngredient(ingredientToBeSaved.getNameIngredient()).isPresent()) {
            return "redirect:/ingredient";
        }
        if (!bindingResult.hasErrors()) {
            ingredientRepository.save(ingredientToBeSaved);
        }
        return "redirect:/ingredient";
    }
    //voor je form
    @GetMapping("/ingredient/new")
    private String showIngredientForm(Model model) {
        model.addAttribute("ingredient", new Ingredient());
        return "ingredientForm";
    }
// voor je form opslaan
    @PostMapping("/ingredient/new")
    private String AddNewIngredient(@ModelAttribute("ingredient")
                                    Ingredient ingredient, BindingResult ingredientresult) {
        if (ingredientRepository.findByNameIngredient(ingredient.getNameIngredient()).isPresent()) {
            return "redirect:/ingredient/new";
        }
        if (!ingredientresult.hasErrors()) {
            ingredientRepository.save(ingredient);
        }
        return "redirect:/ingredient";
    }

    // voor detail
    @GetMapping("/ingredient/detail/{ingredientName}")
    private String showIngredientDetails(@PathVariable("ingredientName") String ingredientName, Model model) {
        Optional<Ingredient> ingredient = ingredientRepository.findByNameIngredient(ingredientName);
        if (ingredient.isEmpty()) {
            return "redirect:/";
        }
        model.addAttribute("ingredientToBeShown", ingredient.get());
        return "ingredient";
    }

    @GetMapping("/ingredient/edit/{nameIngredient}")
    private String showIngredientEditForm(@PathVariable("nameIngredient") String nameIngredient, Model model) {
        Optional<Ingredient> ingredient = ingredientRepository.findByNameIngredient(nameIngredient);
        if (ingredient.isEmpty()) {
            return "redirect:/";
        }
        model.addAttribute("ingredientToBeEdited", ingredient.get());
        return "ingredientForm";
    }

}
