package com.ttrpg.helper.services.core.game.entities;

import lombok.Data;

@Data
public class CharacterAttribute {
    private String name;
    private String description;
    private Object value;
    private Object data;
}