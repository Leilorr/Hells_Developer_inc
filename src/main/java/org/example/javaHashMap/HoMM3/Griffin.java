package org.example.javaHashMap.HoMM3;

public class Griffin extends Creature {
    public Griffin(int quantity) {
        super("Griffin", 2, 8, 8, 6, quantity);
    }

    @Override
    public int getDamage() {

        return getAttack() * getQuantity();
    }
}