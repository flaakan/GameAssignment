package se.experis.johnny.item.equipment.armor;

import se.experis.johnny.item.equipment.Equipment;
import se.experis.johnny.item.equipment.EquipmentSlot;
import se.experis.johnny.item.equipment.EquipmentType;
import se.experis.johnny.stats.Stats;
import se.experis.johnny.stats.statsGenerator.armor.ArmorStatsGenerator;

public abstract class Armor extends Equipment {

    private ArmorType armorType;
    private Stats baseStats;
    private Stats effectiveStats;
    private ArmorStatsGenerator armorStatsGenerator;

    /**
     * Constructor to create a new Armor.
     * Generates the base stats and effective stats at level one.
     * @param name name of the Armor
     * @param armorType type of the armor
     * @param armorStatsGenerator statsGenerator based on armor type.
     * @param equipmentSlot equipment slot of the armor
     */
    public Armor(String name, ArmorType armorType, ArmorStatsGenerator armorStatsGenerator, EquipmentSlot equipmentSlot) {
        super(name,EquipmentType.ARMOR, equipmentSlot);
        this.armorType = armorType;
        this.armorStatsGenerator = armorStatsGenerator;
        this.baseStats = armorStatsGenerator.generateLevelOneStats();
        this.effectiveStats = armorStatsGenerator.calculateBaseEffectiveStats(equipmentSlot);
    }

    /**
     * Levels up an armor to the specified level and increases the stats on the armor
     * based on level and equipment type.
     * @param newLevel level the armor becomes.
     */
    public void levelUp(int newLevel){
        int currentLevel = this.getLevel();
        while (currentLevel < newLevel){
            currentLevel++;
            Stats newLevelBaseStats =  armorStatsGenerator.updateBaseStats(baseStats);
            setBaseStats(newLevelBaseStats);
            Stats newLevelEffectiveStats = armorStatsGenerator.calculateEffectiveStats(baseStats,getEquipmentSlot());
            setEffectiveStats(newLevelEffectiveStats);
        }
        setLevel(currentLevel);
    }

    /**
     * Prints the stats of the Armor
     */
    public void show(){
        System.out.println("Armor Details:");
        System.out.println("Name: " + getName());
        System.out.println("Armor type: " + getArmorType().name());
        System.out.println("Armor slot: " + getEquipmentSlot().name());
        System.out.println("Level: " + getLevel());
        System.out.println("STR: " + getEffectiveStats().getStrength() );
        System.out.println("DEX: " + getEffectiveStats().getDexterity());
        System.out.println("INT: " + getEffectiveStats().getIntelligence());
        System.out.println("HP: " + getEffectiveStats().getHealthPoints()+"\n");
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }

    public Stats getBaseStats() {
        return baseStats;
    }

    public void setBaseStats(Stats baseStats) {
        this.baseStats = baseStats;
    }

    public Stats getEffectiveStats() {
        return effectiveStats;
    }

    public void setEffectiveStats(Stats effectiveStats) {
        this.effectiveStats = effectiveStats;
    }

    public ArmorStatsGenerator getArmorStatsGenerator() {
        return armorStatsGenerator;
    }

    public void setArmorStatsGenerator(ArmorStatsGenerator armorStatsGenerator) {
        this.armorStatsGenerator = armorStatsGenerator;
    }

}
