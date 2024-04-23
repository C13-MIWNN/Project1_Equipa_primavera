package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.services.mappers;

import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.dtos.EquipaPrimaveraUserFormDTO;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.EquipaPrimaveraUser;

/**
 * @author Mirjam Schmitz
 * <p>
 * Purpose for the class
 **/
public class EquipaPrimaveraUserMapper {
    public static EquipaPrimaveraUser fromDTO(EquipaPrimaveraUserFormDTO dto) {
        EquipaPrimaveraUser user = new EquipaPrimaveraUser();
        user.setUsername(dto.getName());
        user.setPassword(dto.getPassword());
        return user;
    }
}
