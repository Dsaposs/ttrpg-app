package com.ttrpg.core.application.controllers;

import com.ttrpg.helper.services.core.game.dto.GameDTO;
import com.ttrpg.helper.services.core.game.entities.Game;
import com.ttrpg.core.application.services.GameService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.ttrpg.helper.services.core.CoreConstants.*;

@RestController
@RequestMapping(path=GAME_URI)
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(GAMES_BY_USER_URI)
    public ResponseEntity<GameDTO> getGameByUser(@PathParam(USER_ID) Integer userId) {
        GameDTO gameDTO = GameDTO.convertEntityToDto(gameService.getGameById(userId));
        return new ResponseEntity<>(gameDTO, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> createGame(@RequestBody GameDTO gameInfo) {
        Game g = GameDTO.convertDtoToEntity(gameInfo);
        gameService.save(g);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(GAME_BY_GAME_ID_URI)
    public ResponseEntity<String> createGameSession(@PathParam(GAME_ID) Integer gameId) {
        gameService.createGameSession(gameId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}