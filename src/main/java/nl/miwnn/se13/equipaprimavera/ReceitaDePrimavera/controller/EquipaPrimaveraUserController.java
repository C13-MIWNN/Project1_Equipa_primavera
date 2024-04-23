package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.controller;

import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.dtos.EquipaPrimaveraUserFormDTO;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model.EquipaPrimaveraUser;
import nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.services.EquipaPrimaveraUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Mirjam Schmitz
 * <p>
 * Purpose for the class
 **/
@Controller
public class EquipaPrimaveraUserController {
    private final EquipaPrimaveraUserService equipaPrimaveraUserService;

    public EquipaPrimaveraUserController(EquipaPrimaveraUserService equipaPrimaveraUserService) {
        this.equipaPrimaveraUserService = equipaPrimaveraUserService;
    }

    @GetMapping("/user/new")
    public String showUserForm(Model model) {
        model.addAttribute("user", new EquipaPrimaveraUserFormDTO());
        return "userForm";
    }

    @PostMapping("/user/new")
    public String processUserForm(@ModelAttribute("user") EquipaPrimaveraUserFormDTO equipaPrimaveraUserFormDTO,
                                  BindingResult bindingResult) {
        if (equipaPrimaveraUserService.userExists(equipaPrimaveraUserFormDTO.getName())) {
            bindingResult.rejectValue("name", "duplicate", "Username already exists");
        }

        if (!equipaPrimaveraUserFormDTO.getPassword().equals(equipaPrimaveraUserFormDTO.getConfirmPassword())){
            bindingResult.rejectValue("password", "nomatch", "Passwords do not match");
        }

        if (bindingResult.hasErrors()) {
            return "userForm";
        }
        equipaPrimaveraUserService.saveUser(equipaPrimaveraUserFormDTO);
        return "redirect:/";
    }
}