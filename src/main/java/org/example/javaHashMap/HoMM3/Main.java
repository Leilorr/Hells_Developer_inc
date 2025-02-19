package org.example.javaHashMap.HoMM3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Hero heroOne = new Hero("Orrin", "Castle", 100, 5,new ArrayList<>());
        Hero heroTwo = new Hero("Crag Hack", "Stronghold", 120, 6, new ArrayList<>());

        // Создаем существ
        Creature pikeman = new Pikeman(50);
        Creature griffin = new Griffin(20);
        Creature swordsman = new Swordman(30);
        Creature angel = new Angel(5);

        // Добавляем существ в армии героев
        heroOne.addCreatures(pikeman, 50);
        heroOne.addCreatures(swordsman, 30);
        heroTwo.addCreatures(griffin, 20);
        heroTwo.addCreatures(angel, 5);

        // Проводим сражение
        Battlefield battlefield = new Battlefield(heroOne, heroTwo);
        battlefield.battle();
    }
}
