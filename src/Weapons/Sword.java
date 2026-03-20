package Weapons;

public class Sword extends Weapon {

    //we do not create any more vars because we already have what we need. Since dmg is fixed we just call the super inside the Sword
    //Constructor and pass in the set dmg value and Sword since its fixed
    public Sword() {
        super("Sword", 5, 10);
    }
}
