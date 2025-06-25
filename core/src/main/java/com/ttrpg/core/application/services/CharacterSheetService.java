package com.ttrpg.core.application.services;

import com.ttrpg.core.application.repositories.CharacterSheetRepository;
import com.ttrpg.helper.services.core.game.entities.CharacterSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterSheetService {
    @Autowired
    private CharacterSheetRepository characterSheetRepository;

    public CharacterSheet findCharacterSheet(Integer userId, Integer characterId) {
        return characterSheetRepository.findByUserIdAndCharacterId(userId, characterId);
    }

    public List<CharacterSheet> findAllForUser(Integer userId) {
        return characterSheetRepository.findAllByUserId(userId);
    }

    public List<CharacterSheet> findAll() {
        return characterSheetRepository.findAll();
    }

    public void save(CharacterSheet characterSheet) {
        characterSheetRepository.save(characterSheet);
    }
}