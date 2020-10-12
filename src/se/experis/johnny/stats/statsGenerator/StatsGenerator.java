package se.experis.johnny.stats.statsGenerator;

import se.experis.johnny.character.Hero;
import se.experis.johnny.stats.Stats;

public interface  StatsGenerator {

    public Stats generateBaseStats();

    public Stats generateNewLevelStats();

    public Stats generateLevelOneStats();

    public Stats updateBaseStats(Stats stats);
}
