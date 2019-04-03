package com.rafalzajac.manager.bootstrap;

import com.rafalzajac.manager.domain.Player;
import com.rafalzajac.manager.repositories.PlayerRepository;
import org.aspectj.apache.bcel.util.Play;
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

        Player Marek = new Player("Marek", "Drobisz", "Setter", 34, 189, 103, 315, 305, "Niebiescy Brzeszcze", "2022");
        Player Tomek = new Player("Tomek", "Kulaga", "Wing Spiker", 35, 192, 93, 335, 315, "Unia Bierun", "2022");
        Player Rafal = new Player("Rafal", "Zajac", "Wing Spiker", 31, 187, 88, 330, 310, "Niebiescy Brzeszcze", "2022");
        Player Piotrek = new Player("Piotrek", "Piotrkowski", "Libero", 24, 175, 73, 300, 285, "MKS Imielin", "2021");
        Player Krzysiek = new Player("Krzysiek", "Krzysztofik", "Opposite", 27, 200, 85, 350, 330, "Tarnowskie Gory", "2021");
        Player Henryk = new Player("Henryk", "Ochucki", "Middle Blocker", 26, 203, 88, 355, 333, "MKS Bedzin", "2023");
        playerRepository.save(Marek);
        playerRepository.save(Tomek);
        playerRepository.save(Rafal);
        playerRepository.save(Piotrek);
        playerRepository.save(Krzysiek);
        playerRepository.save(Henryk);
    }
}
