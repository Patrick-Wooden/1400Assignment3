package models;

import Weapons.Weapon;

public class Warrior extends PlayerCharacter{
    public Warrior(String name, int hitPoints, int defense, int agility, int baseAttack, Weapon weapon) {
        super(name, hitPoints, defense, agility, baseAttack, weapon);
    }

    //For the warrior class we change the calculate power to be baseattack *2 + defense + weapondmg. Makes it so the class you pick
    // and certian attributes you give your character drastically affect their power
    @Override
    public int calculatePower(){
        return (getBaseAttack() * 2) + getDefense() + getWeapon().getDamage();
    }

    //override the tostring to add the class the character is
    @Override
    public String toString(){
        return "Warrior\n" + super.toString();
    }
}
