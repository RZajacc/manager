package com.rafalzajac.manager.controller;

import com.rafalzajac.manager.domain.Player;
import com.rafalzajac.manager.repositories.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class ManagerController {

    private final PlayerRepository playerRepository;

    public ManagerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }



    @GetMapping("players")
    public String viewPlayers(Model model) {

        String position = "All";
        List<Player> list = (List<Player>) playerRepository.findAll();
        model.addAttribute("players", list);

        return "views/players";
    }

    @PostMapping("players")
    public String showSelected(Model model, @RequestParam String position) {

        if (position.equals("All")) {
            List<Player> list = (List<Player>) playerRepository.findAll();
            model.addAttribute("players", list);
        } else {
            List<Player> newlist = (List<Player>) playerRepository.findByPosition(position);
            model.addAttribute("players", newlist);
        }

        return "views/players";
    }

    @GetMapping("contact")
    public String contact(){
        return "views/contact";
    }



//    @GetMapping("addplayer")
//    public String addNewPlayer(Model model) {
//        Player player = new Player();
//        model.addAttribute("player", player);
//        return "addplayer";
//    }

    // To jakoś trzeba będzie przerobić na rejestrację

    @PostMapping("addplayer")
    public String process(@ModelAttribute Player player, Model model) {

        String msg = "";

        if (playerRepository.save(player) != null) {
            msg = "You have successfully added a new player!";
            model.addAttribute("Message", msg);
        }

        return "addplayer";
    }

    // Profil też dopiero do utworzenia
//    @GetMapping("profile")
//    public String viewProfile(Model model) {
//
//        List<Player> list = (List<Player>) playerRepository.findAll();
//        model.addAttribute("lastObject", list.get(list.size() - 1));
//
//        return "profile";
//    }



}

