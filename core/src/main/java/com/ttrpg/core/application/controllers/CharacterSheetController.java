package com.ttrpg.core.application.controllers;

import com.ttrpg.core.application.services.CharacterSheetService;
import com.ttrpg.helper.services.core.game.dto.CharacterSheetDTO;
import com.ttrpg.helper.services.core.game.entities.CharacterSheet;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.ttrpg.helper.services.core.CoreConstants.*;


//for character creation
@RestController()
@RequestMapping(path=CHARACTER_URI)
public class CharacterSheetController {
    private final CharacterSheetService characterSheetService;

    @Autowired
    public CharacterSheetController(CharacterSheetService characterSheetService) {
        this.characterSheetService = characterSheetService;
    }

    @GetMapping(CHARACTER_BY_ID_URI)
    public ResponseEntity<CharacterSheetDTO> getCharacterSheet(@PathParam(USER_ID) String userId, @PathParam(CHARACTER_ID) String characterId) {
        CharacterSheet cs = characterSheetService.findCharacterSheet(Integer.valueOf(userId), Integer.valueOf(characterId));
        return new ResponseEntity<>(CharacterSheetDTO.convertEntityToDto(cs), HttpStatus.OK);
    }

    @PostMapping(CHARACTERS_FOR_USER_URI)
    public ResponseEntity<String> createCharacterSheet(@RequestBody CharacterSheetDTO characterSheet) {
        characterSheetService.save(CharacterSheetDTO.convertDtoToEntity(characterSheet));
        return new ResponseEntity<>("New Character Sheet Created", HttpStatus.OK);
    }

    @GetMapping(ALL_CHARACTERS_URI)
    public @ResponseBody Iterable<CharacterSheet> getAllCharacterSheets() {
        return characterSheetService.findAll();
    }
}