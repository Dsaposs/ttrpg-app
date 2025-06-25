package com.ttrpg.helper.services.core.game.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Collection;

@Data
public class CharacterAttribute {
    private String name;
    private String description;
    private Object value;
    private Object data;
}