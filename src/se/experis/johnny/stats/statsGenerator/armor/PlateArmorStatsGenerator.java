package se.experis.johnny.stats.statsGenerator.armor;

import se.experis.johnny.stats.Stats;


/**
 * Generates stats for Plate armor
 */
public class PlateArmorStatsGenerator extends  ArmorStatsGenerator{

    @Override
    public Stats generateBaseStats() {
        Stats baseStats = new Stats();
        baseStats.setHealthPoints(30);
        baseStats.setStrength(3);
        baseStats.setDexterity(1);
        baseStats.setIntelligence(0);
        return  baseStats;
    }

    @Override
    public Stats generateNewLevelStats() {
        Stats newStats = new Stats();
        newStats.setHealthPoints(12);
        newStats.setStrength(2);
        newStats.setDexterity(1);
        newStats.setIntelligence(0);
        return newStats;
    }

}
