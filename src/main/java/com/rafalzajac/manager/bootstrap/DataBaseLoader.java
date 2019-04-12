package com.rafalzajac.manager.bootstrap;

import com.rafalzajac.manager.domain.Player;
import com.rafalzajac.manager.repositories.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@Profile("dev")
public class DataBaseLoader implements CommandLineRunner {

    private PlayerRepository playerRepository;
    private PasswordEncoder passwordEncoder;

    public DataBaseLoader(PlayerRepository playerRepository, PasswordEncoder passwordEncoder) {
        this.playerRepository = playerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        Player Marek = new Player("Marek", "Marek", "Marecki", "marek@gmail.com",passwordEncoder.encode("13690"), "Setter", 32,189, 103, 315, 305, "Niebiescy Brzeszcze", "2022");
        Player Tomek = new Player("Tomek", "Tomek", "Tomczak", "tomek@interia.pl", passwordEncoder.encode("56789"),"Wing Spiker", 35, 192, 93, 335, 315, "Unia Bierun", "2022");
        Player Rafal = new Player("Rafal", "Rafal", "Zajac", "rf.zajac@gmail.com", passwordEncoder.encode("12345"),"Wing Spiker", 31, 187, 88, 330, 310, "Niebiescy Brzeszcze", "2022");
        Player Piotrek = new Player("Piotrek", "Piotrek", "Piotrkowski", "piotrek@onet.pl", passwordEncoder.encode("46821"),"Libero", 24, 175, 73, 300, 285, "MKS Imielin", "2021");
        Player Krzysiek = new Player("Krzysiek", "Krzysiek", "Krzysztofik", "krzysziek@yahoo.com", passwordEncoder.encode("Krzysio"),"Opposite", 27, 200, 85, 350, 330, "Tarnowskie Gory", "2021");
        Player Henryk = new Player("Henryk","Henryk", "Ochucki", "heniek@gmail.com",passwordEncoder.encode("superheniek"),"Middle Blocker", 26, 203, 88, 355, 333, "MKS Bedzin", "2023");
        playerRepository.save(Marek);
        playerRepository.save(Tomek);
        playerRepository.save(Rafal);
        playerRepository.save(Piotrek);
        playerRepository.save(Krzysiek);
        playerRepository.save(Henryk);
    }
}
