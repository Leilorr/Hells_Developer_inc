package javaCore;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private String name;
    protected int strength;
    protected int agility;
    protected int intellect;
    protected int health = 100;

    public Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }
    public Character(String name){
        this.name = name;
    }
    public abstract void attack(Character target);
}
