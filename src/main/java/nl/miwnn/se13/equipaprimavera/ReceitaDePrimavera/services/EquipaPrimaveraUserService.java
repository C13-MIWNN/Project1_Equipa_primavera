package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.services;

import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.dtos.EquipaPrimaveraUserFormDTO;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.EquipaPrimaveraUser;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.repository.EquipaPrimaveraUserRepository;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.services.mappers.EquipaPrimaveraUserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Mirjam Schmitz
 * <p>
 * Purpose for the class
 **/
@Service
public class EquipaPrimaveraUserService implements UserDetailsService {
    private final EquipaPrimaveraUserRepository equipaPrimaveraUserRepository;
    private final PasswordEncoder passwordEncoder;

    public EquipaPrimaveraUserService(EquipaPrimaveraUserRepository equipaPrimaveraUserRepository, PasswordEncoder passwordEncoder) {
        this.equipaPrimaveraUserRepository = equipaPrimaveraUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return equipaPrimaveraUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public boolean userExists(String username) {
        return equipaPrimaveraUserRepository.findByUsername(username).isPresent();
    }

    public void saveUser(EquipaPrimaveraUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        equipaPrimaveraUserRepository.save(user);
    }

    public void saveUser(EquipaPrimaveraUserFormDTO dto) {
        saveUser(EquipaPrimaveraUserMapper.fromDTO(dto));

    }

    public boolean isNotInitialized() {
        return equipaPrimaveraUserRepository.count() == 0;
    }
}
