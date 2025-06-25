package com.ttrpg.helper.services.core.game.dto;

import com.ttrpg.helper.services.EntityDtoMapper;
import com.ttrpg.helper.services.core.game.entities.Game;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@NoArgsConstructor
@Getter
@Setter
public class GameDTO {
    private Integer gameId;
    private Integer ownerId;
    private List<Integer> playerIds;

    private static final EntityDtoMapper<Game,GameDTO> entityDtoMapper = new EntityDtoMapper<>();

    public static GameDTO convertEntityToDto(Game entity) {
        return (GameDTO) entityDtoMapper.convertToDto(entity, GameDTO.class);
    }

    public static Game convertDtoToEntity(GameDTO dto) {
        return (Game) entityDtoMapper.convertToEntity(dto, Game.class);
    }
}