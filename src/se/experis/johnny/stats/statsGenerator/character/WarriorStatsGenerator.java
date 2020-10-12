package se.experis.johnny.stats.statsGenerator.character;

import se.experis.johnny.stats.Stats;
import se.experis.johnny.stats.statsGenerator.character.HeroStatsGenerator;

/**
 * Generates stats for a Warrior
 */
public class WarriorStatsGenerator extends HeroStatsGenerator {


    @Override
    public Stats generateBaseStats() {
        Stats stats = new Stats();
        stats.setDexterity(3);
        stats.setHealthPoints(150);
        stats.setIntelligence(1);
        stats.setStrength(10);
        return stats;
    }

    @Override
    public Stats generateNewLevelStats() {
        Stats stats = new Stats();
        stats.setIntelligence(1);
        stats.setHealthPoints(30);
        stats.setDexterity(2);
        stats.setStrength(5);
        return stats;
    }

}
