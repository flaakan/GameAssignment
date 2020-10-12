package se.experis.johnny.item.equipment.weapon;

import se.experis.johnny.item.equipment.Equipment;
import se.experis.johnny.item.equipment.EquipmentSlot;
import se.experis.johnny.item.equipment.EquipmentType;



public class Weapon extends Equipment {

    private int damage;
    private WeaponType weaponType;
    private WeaponDamageGenerator weaponDamageGenerator;

    public Weapon(String name, WeaponType weaponType){
        super(name, EquipmentType.WEAPON, EquipmentSlot.WEAPON);
        setWeaponDamageGenerator(new WeaponDamageGenerator());
        this.damage =  weaponDamageGenerator.generateBaseDamage(weaponType);
        this.weaponType = weaponType;
    }

    /**
     * Levels up the item to a specific level and adds more
     * weapon damage to this weapon per level.
     * @param newLevel this is the level the weapon will become.
     */
    public void levelUp(int newLevel){
        int currentLevel = this.getLevel();
        while (currentLevel < newLevel){
            addWeaponDamage();
            this.setLevel(currentLevel++);
        }
    }

    /**
     * Prints the stats for this weapon
     */
    public void show(){
        System.out.println("Weapon Details:");
        System.out.println("Name: " + getName());
        System.out.println("Level: " + getLevel());
        System.out.println("Damage: " + getDamage());
        System.out.println("Weapon type: " + getWeaponType()+"\n");
    }


    /**
     * used to add new level weapon damage to this weapon.
     */
    public void addWeaponDamage(){
        this.damage += weaponDamageGenerator.generateNewLevelDamage(weaponType);
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public WeaponDamageGenerator getWeaponDamageGenerator() {
        return weaponDamageGenerator;
    }

    public void setWeaponDamageGenerator(WeaponDamageGenerator weaponDamageGenerator) {
        this.weaponDamageGenerator = weaponDamageGenerator;
    }
}
