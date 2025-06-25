package com.ttrpg.helper.services.core.game.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
public class CharacterSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer characterId;
    private int id;
    private String name;
    //i.e health, mana, stamina, class?
    private List<CharacterAttribute> attributes;
    //i.e strength, dexterity, intelligence
    private List<CharacterStatistic> statistics;
    private List<GameItem> items;
    private Object data;

    private CharacterAttribute getAttribute(String name) {
        return attributes.stream().filter(attribute -> attribute.getName().equals(name)).findFirst().orElse(null);
    }

    private CharacterStatistic getStatistic(String name) {
        return statistics.stream().filter(statistic -> statistic.getName().equals(name)).findFirst().orElse(null);
    }

    private GameItem getItem(String name) {
        return items.stream().filter(item -> item.getName().equals(name)).findFirst().orElse(null);
    }
}