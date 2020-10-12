package se.experis.johnny.stats.statsGenerator.armor;

import se.experis.johnny.item.equipment.EquipmentSlot;
import se.experis.johnny.stats.Stats;
import se.experis.johnny.stats.statsGenerator.StatsGenerator;

public abstract class ArmorStatsGenerator implements StatsGenerator {

    /**
     * Calculates the effective stats of an equipment at level 1.
     * @param equipmentSlot
     * @return
     */
    public Stats calculateBaseEffectiveStats(EquipmentSlot equipmentSlot){
        Stats levelOneStats = generateLevelOneStats();
        Stats effectiveBaseStats = calculateEffectiveStats(levelOneStats, equipmentSlot);
        return effectiveBaseStats;
    }

    /**
     *Gets the multiplier for the equipment slot.
     * @param equipmentSlot the slot the armor is in.
     * @return the multiplier to use when calculating stats for an armor.
     */
    public double getMultiplier(EquipmentSlot equipmentSlot){
        switch (equipmentSlot){
            case BODY:
                return 1;
            case HELMET:
                return 0.8;
            case LEGS:
                return 0.6;
            default:
                return 0;
        }
    }

    /**
     * Generates Level 1 stats based on base stats and new level stats.
     * @return
     */
    public Stats generateLevelOneStats(){
        Stats baseStats = generateBaseStats();
        return updateBaseStats(baseStats);
    }

    /**
     * Updates base stats value with the new level stats.
     * @param baseStats the base stats.
     * @return
     */
    public Stats updateBaseStats(Stats baseStats) {
        Stats newLevelStats = generateNewLevelStats();
        baseStats.setStrength(baseStats.getStrength() + newLevelStats.getStrength());
        baseStats.setDexterity(baseStats.getDexterity() +newLevelStats.getDexterity());
        baseStats.setHealthPoints(baseStats.getHealthPoints() +newLevelStats.getHealthPoints());
        baseStats.setIntelligence(baseStats.getIntelligence() +newLevelStats.getIntelligence());
        return baseStats;
    }

    /**
     * Calculates the effective stats of the equipment based on the base stats.
     * @param baseStats the base stats.
     * @param equipmentSlot the slot this equipment is in.
     * @return the effective stats.
     */
   public Stats calculateEffectiveStats(Stats baseStats, EquipmentSlot equipmentSlot){
        Stats effectiveStats = new Stats();
        double multiplier = getMultiplier(equipmentSlot);
        effectiveStats.setStrength( (int) (baseStats.getStrength() * multiplier));
        effectiveStats.setDexterity( (int) (baseStats.getDexterity() * multiplier));
        effectiveStats.setIntelligence( (int) (baseStats.getIntelligence() * multiplier));
        effectiveStats.setHealthPoints( (int) (baseStats.getHealthPoints() * multiplier));
        return effectiveStats;
    }

}
