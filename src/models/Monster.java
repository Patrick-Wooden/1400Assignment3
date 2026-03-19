package models;

public class Monster extends Character{
    private String monsterType;

    public Monster(String name, int hitPoints, int defense, int agility, int baseAttack, String monsterType) {
        super(name, hitPoints, defense, agility, baseAttack);
        this.monsterType = monsterType;
    }

    //get and set methods
    public String getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    //I decided to make the power for the monster be calculated by baseattack, defence and agility
    @Override
    public int calculatePower(){
        return getBaseAttack() + getDefense() + getAgility();
    }

    //override
    @Override
    public String toString(){
        return monsterType + "\n" + super.toString();
    }
}
