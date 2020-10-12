package se.experis.johnny.stats.statsGenerator.character;

import se.experis.johnny.character.Hero;
import se.experis.johnny.stats.Stats;
import se.experis.johnny.stats.statsGenerator.StatsGenerator;

/**
 * Generates and handles stats for different Heroes.
 */
public abstract class HeroStatsGenerator  implements StatsGenerator {


    public Stats generateLevelOneStats(){
       Stats baseStats = generateBaseStats();
        return updateBaseStats(baseStats);
    }

    @Override
    public Stats updateBaseStats(Stats baseStats) {
        Stats newLevelStats = generateNewLevelStats();
        baseStats.setStrength(baseStats.getStrength() + newLevelStats.getStrength());
        baseStats.setDexterity(baseStats.getDexterity() +newLevelStats.getDexterity());
        baseStats.setHealthPoints(baseStats.getHealthPoints() +newLevelStats.getHealthPoints());
        baseStats.setIntelligence(baseStats.getIntelligence() +newLevelStats.getIntelligence());
        return baseStats;
    }
}
