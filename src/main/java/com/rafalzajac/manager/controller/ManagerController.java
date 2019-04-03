package com.rafalzajac.manager.controller;

import com.rafalzajac.manager.domain.Player;
import com.rafalzajac.manager.domain.Position;
import com.rafalzajac.manager.repositories.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class ManagerController {

    private final PlayerRepository playerRepository;

    public ManagerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    @GetMapping("players")
    public String viewPlayers(Model model, @ModelAttribute("SelectedPosition")Position position) {

        List<Position> positions = new ArrayList<>();
        positions.add(new Position("All"));
        positions.add(new Position("Setter"));
        positions.add(new Position("Wing Spiker"));
        positions.add(new Position("Opposite"));
        positions.add(new Position("Middle Blocker"));
        positions.add(new Position("Libero"));

        model.addAttribute("positions", positions);

       if(position.getPosition() == null || position.getPosition().equals("All")){
           List<Player> list = (List<Player>) playerRepository.findAll();
           model.addAttribute("players", list);
       }  else {
           List<Player> list = playerRepository.findByPosition(position.getPosition());
           model.addAttribute("players", list);
       }

        return "views/players";
    }

    @GetMapping("register")
    public String registerPage(@ModelAttribute("registeredPlayer") Player player) {
        return "views/register";
    }

    @PostMapping("register")
    public String processRegistration(@ModelAttribute("registeredPlayer") Player player) {

        //Dodaj komunikat który wyświetli się na stronie jeżeli się powiodło
        //Być może przekierowanie na strone profilu ale to do przemyslenia
        //Być może na poczatek bez profilu a w rejestracji komplet danych
        //Tylko wtedy po co logowanie...
        String msg = "";

        playerRepository.save(player);

        return "views/register";
    }


}

