package com.rafalzajac.manager.repositories;

import com.rafalzajac.manager.domain.Player;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Long> {

    List<Player> findByPosition(String position);

    Player findByUsername(String username);

}

