package com.rafalzajac.manager.controller;


import com.rafalzajac.manager.domain.Player;
import com.rafalzajac.manager.repositories.PlayerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

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
    public String processRegistration(@ModelAttribute("registeredPlayer") Player player) {

        playerRepo.save(player.toUser(passwordEncoder));
        return "redirect:/login";
    }

}
