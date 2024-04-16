package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository;

import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.Recipe;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Bram van Ham
 * Purpose for the class
 **/
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {
}
