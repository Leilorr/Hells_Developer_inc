package org.example.javaHashMap.HoMM3;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Battlefield {
    private Hero heroOne;
    private Hero heroTwo;

    public Hero battle(){
        int damageOne = heroOne.getTotalDamage();
        int damageTwo = heroTwo.getTotalDamage();

        System.out.println(heroOne.getName() + " deals " + damageOne + " damage.");
        System.out.println(heroTwo.getName() + " deals " + damageTwo + " damage.");

        if (damageOne > damageTwo){
            System.out.println(heroOne.getName() + " wins!");
            return heroOne;
        } else if (damageTwo > damageOne){
            System.out.println(heroTwo.getName() + " wins!");
            return heroTwo;
        } else {
            System.out.println("It's a draw!");
            return null;
        }
    }
}
