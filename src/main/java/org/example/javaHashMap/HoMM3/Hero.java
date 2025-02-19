package org.example.javaHashMap.HoMM3;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Hero {
    private String name;
    private String fraction;
    private int exp;
    private int lvl;
    private List<Creature> army;


    public void addCreatures(Creature creature, int quantity) {
        for (Creature c : army) {
            if (c.getName().equals(creature.getName())) {
                c.setQuantity(c.getQuantity() + quantity);
                return;
            }
        }
        creature.setQuantity(quantity);
        army.add(creature);
    }

    public void removeCreatures(Creature creature, int quantity) {
        for (Creature c : army) {
            if (c.getName().equals(creature.getName())) {
                int newQuantity = c.getQuantity() - quantity;
                if (newQuantity > 0) {
                    c.setQuantity(newQuantity);
                } else {
                    army.remove(c);
                }
                return;
            }
        }
    }

    public List<Creature> getArmy() {
        System.out.println(army);
        return army;
    }

    public int getTotalDamage(){
        int totalDamage = 0;
        for(Creature c : army){
            totalDamage += c.getDamage();
        }
        return totalDamage;
    }
}
