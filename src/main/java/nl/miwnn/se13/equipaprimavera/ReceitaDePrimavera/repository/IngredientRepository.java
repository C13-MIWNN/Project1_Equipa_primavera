package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository;

import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mirjam Schmitz
 * <p>
 * Purpose for the class
 **/
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
