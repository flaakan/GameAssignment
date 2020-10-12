package se.experis.johnny.character;


import se.experis.johnny.item.equipment.Equipment;
import se.experis.johnny.stats.statsGenerator.character.HeroStatsGenerator;
import se.experis.johnny.stats.Stats;
import java.util.ArrayList;
import java.util.List;

public abstract class Hero {

    private String name;
    private Stats baseStats;
    private Stats additionalStats;
    private Stats effectiveStats;
    private int currentHealthPoints;
    private String characterClass;
    private int currentExperience;
    private int experienceToNextLevel;
    private int level;
    private HeroStatsGenerator heroStatsGenerator;
    boolean isDead;
    List<Equipment> wornItems;

    HeroActions heroActions;

    public Hero(String name, HeroStatsGenerator heroStatsGenerator){
        this.name = name;
        this.heroStatsGenerator = heroStatsGenerator;
        this.level = 1;
        this.currentExperience = 0;
        this.experienceToNextLevel = 100;
        this.isDead = false;
        this.wornItems = new ArrayList<>();
        this.heroActions = new HeroActions(this);
        this.additionalStats = heroActions.calculateAdditionalStats();
        this.effectiveStats = heroActions.calculateEffectiveStats(baseStats,additionalStats);
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentHealthPoints() {
        return currentHealthPoints;
    }

    public void setCurrentHealthPoints(int currentHealthPoints) {
        this.currentHealthPoints = currentHealthPoints;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public HeroStatsGenerator getHeroStatsGenerator() {
        return heroStatsGenerator;
    }

    public void setHeroStatsGenerator(HeroStatsGenerator heroStatsGenerator) {
        this.heroStatsGenerator = heroStatsGenerator;
    }

    public int getCurrentExperience() {
        return currentExperience;
    }

    public void setCurrentExperience(int currentExperience) {
        this.currentExperience = currentExperience;
    }

    public int getExperienceToNextLevel() {
        return experienceToNextLevel;
    }

    public void setExperienceToNextLevel(int experienceToNextLevel) {
        this.experienceToNextLevel = experienceToNextLevel;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public List<Equipment> getWornItems() {
        return wornItems;
    }

    public void setWornItems(List<Equipment> wornItems) {
        this.wornItems = wornItems;
    }

    public Stats getBaseStats() {
        return baseStats;
    }

    public void setBaseStats(Stats baseStats) {
        this.baseStats = baseStats;
    }

    public Stats getAdditionalStats() {
        return additionalStats;
    }

    public void setAdditionalStats(Stats stats) {

        this.additionalStats = stats;
    }

    public Stats getEffectiveStats() {
        return effectiveStats;
    }

    public void setEffectiveStats(Stats effectiveStats) {
        this.effectiveStats = effectiveStats;
    }



    public HeroActions getHeroActions() {
        return heroActions;
    }

    public void setHeroActions(HeroActions heroActions) {
        this.heroActions = heroActions;
    }
}
