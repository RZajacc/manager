package com.rafalzajac.manager.repositories;

import com.rafalzajac.manager.domain.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {

    Player findByPosition(String position);
}

