package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository;

import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.EquipaPrimaveraUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Mirjam Schmitz
 * <p>
 * Purpose for the class
 **/
public interface EquipaPrimaveraUserRepository extends JpaRepository<EquipaPrimaveraUser, Long> {
    Optional<EquipaPrimaveraUser> findByUsername(String username);
}
