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
        return "redirect:/";
    }
}
