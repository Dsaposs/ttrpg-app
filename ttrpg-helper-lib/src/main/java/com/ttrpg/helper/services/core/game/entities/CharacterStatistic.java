package com.ttrpg.helper.services.core.game.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class CharacterStatistic {
    private String name;
    private String description;
    private int value;
    private Object data;
}
