package com.ttrpg.helper.services.core.game.entities;

import lombok.Data;

@Data
public class GameItem {
    private String name;
    private String description;
    private Object data;
}