package se.experis.johnny.damageCalculator;

import se.experis.johnny.character.Hero;
import se.experis.johnny.item.equipment.weapon.Weapon;
import se.experis.johnny.stats.Stats;

public class DamageCalculator {

    public int calculateDamage(Weapon weapon, Hero hero){

        int damage = weapon.getDamage();
        Stats effectiveStats = hero.getEffectiveStats();

        switch (weapon.getWeaponType()){
            case MELEE:
                damage += (effectiveStats.getStrength()*2);
                return damage;

            case RANGED:
                damage += (int) (effectiveStats.getDexterity()*1.5);
                return damage;

            default:
                return 0;
        }
    }
}
