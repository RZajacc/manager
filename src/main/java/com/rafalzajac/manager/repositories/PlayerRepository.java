package com.rafalzajac.manager.repositories;

import com.rafalzajac.manager.domain.Player;
import org.aspectj.apache.bcel.util.Play;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface PlayerRepository extends CrudRepository<Player, Long> {

    List<Player> findByPosition(String position);
}

