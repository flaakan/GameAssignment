package se.experis.johnny.stats.statsGenerator.character;

import se.experis.johnny.stats.Stats;
import se.experis.johnny.stats.statsGenerator.character.HeroStatsGenerator;


/**
 * Generates stats for a Mage
 */
public class MageStatsGenerator extends HeroStatsGenerator {

    @Override
    public Stats generateBaseStats() {
        Stats stats = new Stats();
        stats.setIntelligence(10);
        stats.setHealthPoints(100);
        stats.setDexterity(3);
        stats.setStrength(2);
        return stats;
    }

    @Override
    public Stats generateNewLevelStats() {
        Stats stats = new Stats();
        stats.setIntelligence(5);
        stats.setHealthPoints(15);
        stats.setDexterity(2);
        stats.setStrength(1);
        return stats;
    }


}
