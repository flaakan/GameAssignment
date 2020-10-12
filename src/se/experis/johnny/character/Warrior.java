package se.experis.johnny.character;

import se.experis.johnny.stats.statsGenerator.character.WarriorStatsGenerator;

public class Warrior  extends Hero {

    public Warrior(String name) {
        super(name, new WarriorStatsGenerator());
        setCharacterClass("Warrior");


    }

}
