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

