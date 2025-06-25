package com.ttrpg.core.application.services;

import com.ttrpg.core.application.repositories.GameRepository;
import com.ttrpg.helper.services.auth.AuthClient;
import com.ttrpg.helper.services.auth.dto.UsersListDTO;
import com.ttrpg.helper.services.auth.entites.User;
import com.ttrpg.helper.services.core.game.entities.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final RestTemplate restTemplate;

    private final Map<String, GameSession> gameMap;

    @Autowired
    public GameService(GameRepository gameRepository, RestTemplate restTemplate) {
        this.gameRepository = gameRepository;
        this.restTemplate = restTemplate;
        gameMap = new HashMap<>();
    }

    public Game getGameById(Integer id) {
        return gameRepository.getGameByGameId(id);
    }

    public void save(Game g) {
        gameRepository.save(g);
    }

    public void createGameSession(Integer gameId) {
        Game game = getGameById(gameId);
        if(game == null) throw new RuntimeException("Game does not exist");

        List<User> users = UsersListDTO.convertDtoToEntity(AuthClient.loadAllUsers(restTemplate));
        if(users.isEmpty()) throw new RuntimeException("Users not found");

        GameSession newSession = new GameSession(gameId);
        String sessionId = GameSession.getNextSessionId();
        for (User user : users) {
            if (game.getPlayerIds().contains(user.getId())) {
                newSession.addPlayer(user);
            }
        }
        gameMap.put(sessionId, newSession);
        //record creation time
        //if too much time elapses without new request/update, remove the session
    }
}