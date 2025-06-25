package com.ttrpg.helper.services.core.game.entities;

import lombok.Data;

@Data
public class CharacterStatistic {
    private String name;
    private String description;
    private int value;
    private Object data;
}
