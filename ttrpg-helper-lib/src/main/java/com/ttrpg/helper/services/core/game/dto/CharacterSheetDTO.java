package com.ttrpg.helper.services.core.game.dto;


import com.ttrpg.helper.services.EntityDtoMapper;
import com.ttrpg.helper.services.core.game.entities.CharacterSheet;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Data
@Getter
@Setter
@NoArgsConstructor
public class CharacterSheetDTO {
    private Integer characterId;
    private Integer userId;
    private String characterName;
    private Map<String, Integer> stats;

    private static final EntityDtoMapper<CharacterSheet,CharacterSheetDTO> entityDtoMapper = new EntityDtoMapper<>();

    public static CharacterSheetDTO convertEntityToDto(CharacterSheet entity) {
        return (CharacterSheetDTO) entityDtoMapper.convertToDto(entity, CharacterSheetDTO.class);
    }

    public static CharacterSheet convertDtoToEntity(CharacterSheetDTO dto) {
        return (CharacterSheet) entityDtoMapper.convertToEntity(dto, CharacterSheet.class);
    }
}