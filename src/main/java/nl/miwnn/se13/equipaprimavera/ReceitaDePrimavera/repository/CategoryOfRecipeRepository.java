package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository;

import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.CategoryOfRecipe;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bram van Ham
 * Purpose for the class
 **/
public interface CategoryOfRecipeRepository extends JpaRepository<CategoryOfRecipe, Long> {
}
