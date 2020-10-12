package se.experis.johnny.stats.statsGenerator.armor;

import se.experis.johnny.stats.Stats;

/**
 * Generates stats for Cloth armor
 */
public class ClothArmorStatsGenerator extends ArmorStatsGenerator {

    @Override
    public Stats generateBaseStats() {
        Stats baseStats = new Stats();
        baseStats.setHealthPoints(10);
        baseStats.setStrength(0);
        baseStats.setDexterity(1);
        baseStats.setIntelligence(3);
        return  baseStats;
    }

    @Override
    public Stats generateNewLevelStats() {
        Stats newStats = new Stats();
        newStats.setHealthPoints(5);
        newStats.setStrength(0);
        newStats.setDexterity(1);
        newStats.setIntelligence(2);
        return newStats;
    }

}