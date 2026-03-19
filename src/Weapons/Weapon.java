package Weapons;

/**
 * This is the main weapon class that children will be based off
 * Each weapon has a name and a fixed dmg value
 *
 */

public class Weapon {
    //create private vars
    private String name;
    private int damage;

    //constructor
    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }


    //get and set methods
    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    //to string method that children will override
    @Override
    public String toString(){
        return name + " (DMG: " + damage + ")";
    }
}
