package com.rafalzajac.manager.controller;


import com.rafalzajac.manager.domain.Player;
import com.rafalzajac.manager.domain.Position;
import com.rafalzajac.manager.repositories.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@Controller
@Slf4j
@RequestMapping("/info")
public class ManagerController {

    private final PlayerRepository playerRepository;

    public ManagerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    @GetMapping("/players")
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

    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal UserDetails userDetails, Model model, @ModelAttribute("toUpdate")Player player) {
        Player loggedUser = playerRepository.findByUsername(userDetails.getUsername());
        model.addAttribute("loggedUser", loggedUser);
        return "views/profile";
    }

    @PostMapping("/profile")
    public String updateProfile(@AuthenticationPrincipal UserDetails userDetails, Model model, @ModelAttribute("toUpdate")Player player) {
        Player toUpdate = playerRepository.findByUsername(userDetails.getUsername());
        //model.addAttribute("toUpdate", toUpdate);
        //player.setUsername(toUpdate.getUsername());
        playerRepository.save(player);
        return "redirect:/info/profile";
    }


}

