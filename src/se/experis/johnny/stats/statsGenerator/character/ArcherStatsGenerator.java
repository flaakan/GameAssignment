package se.experis.johnny.stats.statsGenerator.character;

import se.experis.johnny.stats.Stats;

/**
 * Generates stats for an Archer
 */
public class ArcherStatsGenerator extends HeroStatsGenerator {

    @Override
    public Stats generateBaseStats() {
        Stats stats = new Stats();
        stats.setDexterity(10);
        stats.setHealthPoints(120);
        stats.setIntelligence(2);
        stats.setStrength(5);
        return stats;

    }

    @Override
    public Stats generateNewLevelStats() {
        Stats stats = new Stats();
        stats.setIntelligence(1);
        stats.setHealthPoints(20);
        stats.setDexterity(5);
        stats.setStrength(2);
        return stats;
    }


}
