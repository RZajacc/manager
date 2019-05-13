package com.rafalzajac.manager.controller;

import com.rafalzajac.manager.domain.Player;
import com.rafalzajac.manager.repositories.PlayerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;


/**
 * Controller responsible only for registering new users
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    private PlayerRepository playerRepo;
    private PasswordEncoder passwordEncoder;

    /**
     * Constructor including player repository and password encoder which is used during posting registration form
     * to hash the password
     * @param playerRepo
     * @param passwordEncoder
     */
    public RegisterController(PlayerRepository playerRepo, PasswordEncoder passwordEncoder) {
        this.playerRepo = playerRepo;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Method returning a view for registration form and player object
     * @param player
     * @return
     */
    @GetMapping
    public String registerFrom(@ModelAttribute("registeredPlayer") Player player) {
        return "auth/register";
    }

    /**
     * Method handling registration form post method. If there are errors during registration caused by for example
     * by invalid data or fields left blank it returns the same view. If everything goes well it saves player to data
     * base using toUser method. It creates new player with provided data and performs hashing of the password
     * @param player
     * @param errors
     * @return
     */
    @PostMapping
    public String processRegistration(@Valid @ModelAttribute("registeredPlayer") Player player, Errors errors) {
        if(errors.hasErrors()){
            return "auth/register";
        }
        playerRepo.save(player.toUser(passwordEncoder));
        return "redirect:/login";
    }

}
