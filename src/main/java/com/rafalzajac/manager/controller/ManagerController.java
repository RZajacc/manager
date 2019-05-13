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
import java.util.Arrays;
import java.util.List;

/**
 * Controller responsible for views describing in some way data on web pate like players list, and personal
 * players profile
 */
@Controller
@Slf4j
@RequestMapping("/info")
public class ManagerController {

    private final PlayerRepository playerRepository;

    /**
     * Constructor for player repository
     * @param playerRepository
     */
    public ManagerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    /**
     * Method first declares a list of players positions, and populates it, then adds it to model for use in players
     * view. Then it simply compare data from the form, if position is not selected or "All" is chosen it shows all
     * players stored in data base. If anything else is selected it gets selection and shows players by only chosen
     * position on court
     * @param model
     * @param position
     * @return
     */
    @GetMapping("/players")
    public String viewPlayers(Model model, @ModelAttribute("SelectedPosition")Position position) {

        List<Position> positions = Arrays.asList(new Position("All"), new Position("Setter"), new Position("Wing Spiker"),
                                                 new Position("Opposite"), new Position("Middle Blocker"), new Position("Libero"));


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

    /**
     * Method gets information about logged user from UserDetails, then player repository search for players in the data
     * base based on user name obained form current user and assings data to loggedUser. Next it adds loggedUser to the
     * model and all relevant inforation from it is viewed in profile view.
     * @param userDetails
     * @param model
     * @return
     */
    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        Player loggedUser = playerRepository.findByUsername(userDetails.getUsername());
        model.addAttribute("loggedUser", loggedUser);
        return "views/profile";
    }

}

