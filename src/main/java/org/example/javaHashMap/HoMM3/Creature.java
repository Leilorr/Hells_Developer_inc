package org.example.javaHashMap.HoMM3;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Creature {
    private String name;
    private int lvl;
    private int attack;
    private int defense;
    private int speed;
    private int quantity;

    public abstract int getDamage();
}
