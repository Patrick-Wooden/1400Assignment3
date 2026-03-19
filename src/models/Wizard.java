package models;

import Weapons.Weapon;

public class Wizard extends PlayerCharacter{

    public Wizard(String name, int hitPoints, int defense, int agility, int baseAttack, Weapon weapon) {
        super(name, hitPoints, defense, agility, baseAttack, weapon);
    }

    //For the wizard class we change the calculate power to be agility *2 + baseattack + weapondmg. Makes it so the class you pick
    // and certian attributes you give your character drastically affect their power
    @Override
    public int calculatePower(){
        return getBaseAttack() + (getAgility() * 2) + getWeapon().getDamage();
    }

    @Override
    public String toString(){
        return "Wizard\n" + super.toString();
    }
}
