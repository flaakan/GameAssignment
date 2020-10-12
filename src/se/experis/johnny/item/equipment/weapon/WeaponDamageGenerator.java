package se.experis.johnny.item.equipment.weapon;


/**
 * Generator for weapon damage. Generates base damage of a weapon on level 1,
 * and generates new level weapon damage.
 *
 */
public class WeaponDamageGenerator {

    /**
     * Generates different base values of weapon damage based on WeaponType
     * @param weaponType the type of weapon
     * @return
     */
    public int generateBaseDamage(WeaponType weaponType){
        int damage = 0;
        switch (weaponType){
            case MELEE:
                damage = 15;
                break;
            case RANGED:
                damage = 5;
                break;
            default:
                break;
        }
        return damage;
    }

    /**
     * Generates different additional values of weapon damage based on WeaponType
     * @param weaponType the type of weapon
     * @return
     */
    public int generateNewLevelDamage(WeaponType weaponType){
        int damage = 0;
        switch (weaponType){
            case MELEE:
                damage = 2;
                break;
            case RANGED:
                damage = 3;
                break;
            default:
                break;
        }
        return damage;
    }

}
