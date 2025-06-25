package com.ttrpg.core.application.repositories;

import com.ttrpg.helper.services.core.game.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    Game getGameByGameId(Integer id);
    List<Game> getGamesByOwnerId(Integer id);
}