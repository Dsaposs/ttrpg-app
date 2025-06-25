package com.ttrpg.helper.services.core.game.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class GameItem {
    private String name;
    private String description;
    private Object data;
}