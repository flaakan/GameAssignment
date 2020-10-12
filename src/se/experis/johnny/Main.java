package se.experis.johnny;

import se.experis.johnny.character.Archer;
import se.experis.johnny.character.Hero;
import se.experis.johnny.character.Warrior;
import se.experis.johnny.item.equipment.Equipment;
import se.experis.johnny.item.equipment.EquipmentSlot;
import se.experis.johnny.item.equipment.armor.*;
import se.experis.johnny.item.equipment.weapon.Weapon;
import se.experis.johnny.item.equipment.weapon.WeaponType;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Hero> allHeroes = new ArrayList<>();
        Archer archer = new Archer("Robin hood");
        Warrior warrior = new Warrior("Axe Boy");

        allHeroes.add(archer);
        allHeroes.add(warrior);

        //Test the level up function for heroes.
        warrior.getHeroActions().gainExperience(500);

        //Creates different weapons
        Weapon longSword = new Weapon("Long Sword", WeaponType.MELEE);
        Weapon shortSword = new Weapon("Short Sword", WeaponType.MELEE);
        Weapon longBow = new Weapon("Long Bow" , WeaponType.RANGED);

        //Creates different armor
        Armor plateBody = new PlateArmor("Steel platebody", EquipmentSlot.BODY);
        Armor plateLegs = new PlateArmor("Steel platelegs", EquipmentSlot.LEGS);
        Armor clothLegs = new ClothArmor("Priest Gown", EquipmentSlot.LEGS);
        Armor clothBody = new ClothArmor("Cloth Body",EquipmentSlot.BODY);

        //Test the level up function on weapons.
        shortSword.levelUp(5);

        //Test the level up function on armors.
        plateBody.levelUp(15);
        clothLegs.levelUp(10);

        //Tests the equip functions for heroes. This will replace long sword with short sword.
        warrior.getHeroActions().equipItem(longSword);
        warrior.getHeroActions().equipItem(shortSword);
        warrior.getHeroActions().equipItem(plateBody);
        warrior.getHeroActions().equipItem(plateLegs);


        archer.getHeroActions().equipItem(clothBody);
        archer.getHeroActions().equipItem(clothLegs);
        archer.getHeroActions().equipItem(longBow);

        //Tests the attack function of heroes.
        archer.getHeroActions().attack(warrior);
        warrior.getHeroActions().attack(archer);


        //Shows the heroes and the eqiupped item stats.
        for(Hero hero: allHeroes){
            hero.getHeroActions().show();
            for (Equipment eq: hero.getWornItems()) {
                if(eq instanceof Armor){
                    Armor armor  = (Armor) eq;
                    armor.show();
                }
                else{
                    Weapon weapon = (Weapon) eq;
                    weapon.show();
                }
            }
        }
    }
}
