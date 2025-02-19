package org.example.javaHashMap.HoMM3;

public class Angel extends Creature {
    public Angel(int quantity) {
        super("Angel", 7, 20, 20, 12, quantity);
    }

    @Override
    public int getDamage() {

        return getAttack() * getQuantity();
    }
}
