package se.experis.johnny.character;

import se.experis.johnny.stats.statsGenerator.character.MageStatsGenerator;

public class Mage extends Hero {
    public Mage(String name) {
        super(name, new MageStatsGenerator());
        setCharacterClass("Mage");
    }


}
