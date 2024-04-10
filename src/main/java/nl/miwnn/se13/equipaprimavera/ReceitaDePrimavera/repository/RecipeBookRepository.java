package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository;

import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.RecipeBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecipeBookRepository extends JpaRepository<RecipeBook, Long> {
    Optional<RecipeBook> findBynameOfRecipeBook(String nameOfRecipeBook);
}
