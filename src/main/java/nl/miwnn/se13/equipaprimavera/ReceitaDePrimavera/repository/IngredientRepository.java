package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository;

import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.Ingredient;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Mirjam Schmitz
 * <p>
 * Purpose for the class
 **/
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Optional<Ingredient> findByNameIngredient(String nameIngredient);
}
