package com.rafalzajac.manager.service;

import com.rafalzajac.manager.domain.Player;
import com.rafalzajac.manager.repositories.PlayerRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> findByPosition(String position){
        return playerRepository.findByPosition(position);
    }



}