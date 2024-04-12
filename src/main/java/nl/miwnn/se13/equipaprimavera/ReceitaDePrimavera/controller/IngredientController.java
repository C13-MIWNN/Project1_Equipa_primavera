package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.controller;

import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.Ingredients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mirjam Schmitz
 * <p>
 * Handels everthing with ingredients
 **/
@Controller
public class IngredientController {

    @GetMapping("/ingredients")
    private String showIngredientOverview(Model model){
        List<Ingredients> ingredients = new ArrayList<>();

        model.addAttribute("allIngredients", ingredients);

        return "ingredientOverview";
    }
}
