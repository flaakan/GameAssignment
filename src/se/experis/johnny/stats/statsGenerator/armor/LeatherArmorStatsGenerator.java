package se.experis.johnny.stats.statsGenerator.armor;

import se.experis.johnny.stats.Stats;


/**
 * Generates stats for Leather armor
 */
public class LeatherArmorStatsGenerator extends ArmorStatsGenerator {

    @Override
    public Stats generateBaseStats() {
        Stats baseStats = new Stats();
        baseStats.setHealthPoints(20);
        baseStats.setStrength(1);
        baseStats.setDexterity(3);
        baseStats.setIntelligence(0);
        return  baseStats;
    }

    @Override
    public Stats generateNewLevelStats() {
        Stats newStats = new Stats();
        newStats.setHealthPoints(8);
        newStats.setStrength(1);
        newStats.setDexterity(2);
        newStats.setIntelligence(0);
        return newStats;
    }
}



