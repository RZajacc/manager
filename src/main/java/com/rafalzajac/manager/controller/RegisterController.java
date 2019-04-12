package com.rafalzajac.manager.controller;

import com.rafalzajac.manager.domain.Player;
import com.rafalzajac.manager.domain.Position;
import com.rafalzajac.manager.repositories.PlayerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/register")
public class RegisterController {

    private PlayerRepository playerRepo;
    private PasswordEncoder passwordEncoder;

    public RegisterController(PlayerRepository playerRepo, PasswordEncoder passwordEncoder) {
        this.playerRepo = playerRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerFrom(@ModelAttribute("registeredPlayer") Player player) {
        return "auth/register";
    }

    @PostMapping
    public String processRegistration(@Valid @ModelAttribute("registeredPlayer") Player player, Errors errors, Model model) {
        if(errors.hasErrors()){
            return "auth/register";
        }
        playerRepo.save(player.toUser(passwordEncoder));
        return "redirect:/login";
    }

}
