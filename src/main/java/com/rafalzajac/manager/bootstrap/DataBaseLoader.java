package com.rafalzajac.manager.bootstrap;

import com.rafalzajac.manager.domain.Player;
import com.rafalzajac.manager.repositories.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseLoader implements CommandLineRunner {

    private PlayerRepository playerRepository;

    public DataBaseLoader(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Player Rafal = new Player((long) 3, "Rafal", "Zajac", "Wing Spiker", 31, 187, 88, 330, 310, "Niebiescy Brzeszcze", "2022");
        Player Marek = new Player((long) 1, "Marek", "Drobisz", "Setter", 34, 189, 103, 315, 305, "Niebiescy Brzeszcze", "2022");
        Player Tomek = new Player((long) 2, "Tomek", "Kulaga", "Wing Spiker", 35, 192, 93, 335, 315, "Unia Bierun", "2022");

        playerRepository.save(Rafal);
        playerRepository.save(Marek);
        playerRepository.save(Tomek);
    }
}
