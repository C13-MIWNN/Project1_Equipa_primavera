package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository;

import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
