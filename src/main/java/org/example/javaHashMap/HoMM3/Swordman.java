package org.example.javaHashMap.HoMM3;

public class Swordman extends Creature {
    public Swordman(int quantity) {
        super("Swordman", 3, 10, 12, 5, quantity);
    }

    @Override
    public int getDamage() {

        return getAttack() * getQuantity();
    }
}
