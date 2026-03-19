package models;

import Weapons.Weapon;

public class PlayerCharacter extends Character{
    private Weapon weapon;

    public PlayerCharacter(String name, int hitPoints, int defense, int agility, int baseAttack, Weapon weapon) {
        super(name, hitPoints, defense, agility, baseAttack);
        this.weapon = weapon;
    }

    //getter and setters for weapon
    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    //now we override our abstract method calculatePower which adds up the characters agility base attack and weapon dmg
    @Override
    public int calculatePower(){
        return getAgility() + getBaseAttack()+ weapon.getDamage();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nWeapon: " + weapon.getName() +
                " (DMG: " + weapon.getDamage() + ")";
    }
}
