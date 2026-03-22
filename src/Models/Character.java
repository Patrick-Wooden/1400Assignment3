package Models;

public abstract class Character {
    //below are the vars I decided on. All of these are in Character as from looking at the example monster has these values also
    private String name;
    private int hitPoints;
    private int defense;
    private int agility;
    private int baseAttack;

    //next I create the constructor
    public Character(String name, int hitPoints, int defense, int agility, int baseAttack) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.defense = defense;
        this.agility = agility;
        this.baseAttack = baseAttack;
    }

    //Below are the get and set methods for each value
    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getDefense() {
        return defense;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public int getAgility() {
        return agility;
    }

    //Below is the abstract method for calculating power. Each character class and monster class will overwrite it
    public abstract int calculatePower();

    @Override
    public String toString() {
        return "Name: " + name +
                "\nHP: " + hitPoints +
                "\nDEF: " + defense +
                "\nAGI: " + agility +
                "\nATK: " + baseAttack;
    }


}
