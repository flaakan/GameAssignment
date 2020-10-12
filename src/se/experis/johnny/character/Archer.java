package se.experis.johnny.character;

import se.experis.johnny.stats.statsGenerator.character.ArcherStatsGenerator;

public class Archer extends Hero {

    public Archer(String name) {
        super(name, new ArcherStatsGenerator());
        setCharacterClass("Archer");
    }




}
