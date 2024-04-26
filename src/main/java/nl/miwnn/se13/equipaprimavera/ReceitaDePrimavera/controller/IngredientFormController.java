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

import java.util.Optional;

/**
 * @author Mirjam Schmitz
 * <p>
 * Purpose for the class
 **/
@Controller
public class IngredientFormController {
    private final IngredientRepository ingredientRepository;
    private final MeasurementUnitRepository measurementUnitRepository;

    public IngredientFormController(IngredientRepository ingredientRepository,
                                MeasurementUnitRepository measurementUnitRepository) {
        this.ingredientRepository = ingredientRepository;
        this.measurementUnitRepository = measurementUnitRepository;
    }
    //voor het extra gemaakte form
    @GetMapping("/ingredient/new")
    private String showIngredientForm(Model model) {
        model.addAttribute("newIngredient", new Ingredient());
        model.addAttribute("allIngredients", ingredientRepository.findAll());
        model.addAttribute("allMeasurementTypes", measurementUnitRepository.findAll());
        return "ingredientForm";
    }
    // voor form opslaan
    @PostMapping("/ingredient/new")
    private String saveIngredient(@ModelAttribute("ingredient") Ingredient ingredient,
                                    BindingResult bindingResult){
        if (ingredientRepository.findByNameIngredient(ingredient.getNameIngredient()).isPresent()) {
            return "redirect:/ingredient/new";
        }
        if (!bindingResult.hasErrors()) {
            ingredientRepository.save(ingredient);
        }
        return "redirect:/ingredient/new";
    }
//
//    //voor edit form
//    @GetMapping("/ingredient/new/{nameIngredient}")
//    private String showIngredientDetails(@PathVariable("nameIngredient") String nameIngredient, Model model) {
//        Optional<Ingredient> ingredient = ingredientRepository.findByNameIngredient(nameIngredient);
//        if (ingredient.isEmpty()) {
//            return "redirect:/ingredient";
//        }
//        model.addAttribute("ingredientToBeShown", ingredient.get());
//        return "ingredientForm";
//    }

    @GetMapping("/ingredient/edit/{nameIngredient}")
    private String showIngredientEditForm(@PathVariable("nameIngredient") String nameIngredient, Model model) {
        Optional<Ingredient> ingredient = ingredientRepository.findByNameIngredient(nameIngredient);
        if (ingredient.isEmpty()) {
            return "redirect:/ingredient";
        }
        model.addAttribute("newIngredient", ingredient.get());
        model.addAttribute("allIngredients", ingredientRepository.findAll());
        model.addAttribute("allMeasurementTypes", measurementUnitRepository.findAll());
        return "ingredientForm";
    }
}
