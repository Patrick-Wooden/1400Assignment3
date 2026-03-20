package Models;

import java.util.Random;

public class StatGenerator {
    private static final Random rand = new Random();

    //I first made a reusable method that generates a random number between a min and max value. This will be reused for genereating each stat
    public static int randomStat(int min, int max){
        return rand.nextInt(max - min + 1) + min;

    }

    //below are the methods for generating each random stat, hp defense agility and base attack
    public static int generateHP(){
        return randomStat(60, 120);
    }

    public static int generateDefense(){
        return randomStat(10, 30);
    }

    public static int generateAgility(){
        return randomStat(10, 30);
    }

    public static int generateBaseAttack(){
        return randomStat(10,30);
    }

}
