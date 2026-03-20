package Weapons;

public class Staff extends Weapon{

    //we do not create any more vars because we already have what we need. Since dmg is fixed we just call the super inside the Staff
    //Constructor and pass in the set dmg value and Staff since its fixed
    public Staff(){
        super("Staff", 2, 5);
    }
}
