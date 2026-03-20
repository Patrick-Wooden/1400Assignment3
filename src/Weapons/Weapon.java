package Weapons;

/**
 * This is the main weapon class that children will be based off
 * Each weapon has a name, a fixed dmg value and weight
 *
 */

public class Weapon {
    //create private vars
    private String name;
    private int attackModifier;
    private int weight;

    //constructor
    public Weapon(String name, int attackModifier, int weight) {
        this.name = name;
        this.attackModifier = attackModifier;
        this.weight = weight;
    }


    //get and set methods
    public String getName() {
        return name;
    }
    public int getAttackModifier() {
        return attackModifier;
    }

    public int getWeight() {
        return weight;
    }

    //to string meth
    @Override
    public String toString() {
        return name + " (ATK Mod: " + attackModifier + ", Weight: " + weight + ")";
    }

}
