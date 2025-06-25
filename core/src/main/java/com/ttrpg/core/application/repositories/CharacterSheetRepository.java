package com.ttrpg.core.application.repositories;

import com.ttrpg.helper.services.core.game.entities.CharacterSheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterSheetRepository  extends JpaRepository<CharacterSheet,Integer> {
    List<CharacterSheet> findAllByUserId(Integer userId);

    CharacterSheet findByUserIdAndCharacterId(Integer userId, Integer characterId);
}