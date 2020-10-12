package se.experis.johnny.character;

import se.experis.johnny.damageCalculator.DamageCalculator;
import se.experis.johnny.item.equipment.Equipment;
import se.experis.johnny.item.equipment.EquipmentType;
import se.experis.johnny.item.equipment.armor.Armor;
import se.experis.johnny.item.equipment.weapon.Weapon;
import se.experis.johnny.stats.Stats;
import se.experis.johnny.stats.statsGenerator.character.HeroStatsGenerator;

import java.util.List;

/**
 * Controls the hero's actions. All the logic behind what a hero can do is here.
 */
public class HeroActions {
    Hero hero;
    private DamageCalculator damageCalculator;
    private HeroStatsGenerator heroStatsGenerator;

    public HeroActions(Hero hero){
        this.hero = hero;
        this.damageCalculator = new DamageCalculator();
        this.heroStatsGenerator = hero.getHeroStatsGenerator();
        hero.setBaseStats(heroStatsGenerator.generateLevelOneStats());
        hero.setCurrentHealthPoints(hero.getBaseStats().getHealthPoints());
    }

    /**
     * Attacks a different hero based on your weapon damage and stats.
     * @param heroToAttack the hero to attack.
     */
    public void attack(Hero heroToAttack) {
        if (!hero.isDead) {
            Weapon weapon = getWeapon();
            int damage = damageCalculator.calculateDamage(weapon, hero);
            System.out.println("You attack " + heroToAttack.getName() + " for " + damage + " damage.");
            heroToAttack.heroActions.takeDamage(damage, hero.getName());
        }

    }

    /**
     * Called upon in attack() to take damage from a hero.
     * @param damage the amount of damage this hero takes.
     * @param name the name of the attacker.
     */
    public void takeDamage(int damage ,String name){
        System.out.println("You have taken " + damage + " damage from " + name+"\n");
        if(hero.getCurrentHealthPoints() - damage <= 0){
            hero.setCurrentHealthPoints(0);
            hero.setDead(true);
            System.out.println("You are dead!"+"\n");
        }else{
            int currentHealthPoints = hero.getCurrentHealthPoints();
            currentHealthPoints -= damage;
            hero.setCurrentHealthPoints(currentHealthPoints);
            System.out.println("you have " + currentHealthPoints +"hp left"+"\n");
        }
    }

    /**
     * Increases the amount of experience the hero has and calls method levelUp()
     * upon leveling up.
     * @param experience the amount of experience to give the hero.
     */

    public void gainExperience(int experience){
        while(hero.getCurrentExperience() + experience >= hero.getExperienceToNextLevel()){
            experience -= hero.getExperienceToNextLevel();
            System.out.println("Experience left " + experience);
            hero.setExperienceToNextLevel((int) (hero.getExperienceToNextLevel()*1.1));
            System.out.println("Experience to next level: " + hero.getExperienceToNextLevel());
            levelUp();
        }
        int currentExperience = hero.getCurrentExperience() + experience;
        hero.setCurrentExperience(currentExperience);
        System.out.println("Current experience: " + currentExperience);
        System.out.println("Exp left to next level: " + (hero.getExperienceToNextLevel() - hero.getCurrentExperience())+"\n");
    }

    /**
     * Levels up the hero and sets new base stats based on the new level.
     */
    public void levelUp(){
        int newLevel = hero.getLevel()+1;
        hero.setLevel(newLevel);
        Stats currentStats = hero.getBaseStats();
        Stats newStats = hero.getHeroStatsGenerator().updateBaseStats(currentStats);
        setNewBaseStats(newStats);
        System.out.println("You have leveled up! You are now level " + hero.getLevel() +"!"+"\n");
    }

    /**
     * Called upon on levelUp() to change the base stats upon level up.
     * @param stats the current stats on this hero to change.
     */
    public void setNewBaseStats(Stats stats){
        hero.setBaseStats(stats);

        Stats effectiveStats = calculateEffectiveStats(hero.getBaseStats(),hero.getAdditionalStats());
        hero.setEffectiveStats(effectiveStats);
        hero.setCurrentHealthPoints(hero.getEffectiveStats().getHealthPoints());
    }

    /**
     * Shows the information of this hero.
     *
     */
    public void show(){
        String status ="alive";
        if(hero.isDead()){
            status = "dead";
        }
        System.out.println("Character Details");
        System.out.println("name: " + hero.getName());
        System.out.println("Class: " + hero.getCharacterClass());
        System.out.println("Level: " + hero.getLevel());
        System.out.println("STR: " + (hero.getEffectiveStats().getStrength() + "(+" + hero.getAdditionalStats().getStrength()+ ")"));
        System.out.println("DEX: " + hero.getEffectiveStats().getDexterity() + "(+" + hero.getAdditionalStats().getDexterity() + ")");
        System.out.println("INT: " + hero.getEffectiveStats().getIntelligence() + "(+" + hero.getAdditionalStats().getIntelligence() + ")");
        System.out.println("HP: " +hero.getCurrentHealthPoints() + "/" + hero.getEffectiveStats().getHealthPoints());
        System.out.println("Status: " + status);
        System.out.println("Exp: " + hero.getCurrentExperience() + "/" +hero.getExperienceToNextLevel()+"\n");
    }

    /**
     * Equips an Equipment and replaces an Equipment if there already is
     * already an equipment with the same type.
     * @param equipment
     */

    public void equipItem(Equipment equipment){
        boolean itemAlreadyEquipped = false;
        List<Equipment> wornItems =  hero.getWornItems();
        for (Equipment eq: wornItems ){
            if(eq.getEquipmentSlot().equals(equipment.getEquipmentSlot())){
                System.out.println("Replacing " + eq.getName() + " with " + equipment.getName()+"\n");
                wornItems.set(wornItems.indexOf(eq),equipment);
                itemAlreadyEquipped = true;
                break;
            }
            else{
                continue;
            }
        }
        if(!itemAlreadyEquipped){
            System.out.println("Equipping " + equipment.getName()+"\n");
            wornItems.add(equipment);
        }
        Stats additional = calculateAdditionalStats();
        hero.setAdditionalStats(additional);
        if(hero.getEffectiveStats().getHealthPoints() == hero.getCurrentHealthPoints()){
            hero.setEffectiveStats(calculateEffectiveStats(hero.getBaseStats(), hero.getAdditionalStats()));
            int newCurrentHealth = hero.getEffectiveStats().getHealthPoints();
            hero.setCurrentHealthPoints(newCurrentHealth);

        }else{
            hero.setEffectiveStats(calculateEffectiveStats(hero.getBaseStats(), hero.getAdditionalStats()));
        }


    }

    /**
     * Gets the currently equipped weapon if there is a weapon equipped
     * @return Weapon the weapon this hero has equipped
     */
    public Weapon getWeapon(){
        List<Equipment> wornItems = hero.getWornItems();
        for (Equipment equipment : wornItems){
            if (equipment.getEquipmentType().equals(EquipmentType.WEAPON)){
                return (Weapon) equipment;
            }
        }
        return null;
    }

    /**
     * Loops through all equipped items to calculate total bonus stats.
     * @return stats the total bonus stats from equipment.
     */
    public Stats calculateAdditionalStats(){
        Stats stats = new Stats();
        int strength = 0, dexterity = 0,intelligence = 0, healthPoints = 0;
        for (Equipment eq: hero.wornItems) {
            if(eq instanceof Armor) {
                Armor armor = (Armor) eq;
                strength += armor.getEffectiveStats().getStrength();
                dexterity += armor.getEffectiveStats().getDexterity();
                intelligence += armor.getEffectiveStats().getIntelligence();
                healthPoints += armor.getEffectiveStats().getHealthPoints();
            }
        }
        stats.setStrength(strength);
        stats.setDexterity(dexterity);
        stats.setIntelligence(intelligence);
        stats.setHealthPoints(healthPoints);
        return  stats;
    }


    /**
     * Calculates the effective stats from base stats and additional stats
     * @param baseStats
     * @param additionalStats
     * @return effectiveStats the effective stats this hero has.
     */
    public Stats calculateEffectiveStats(Stats baseStats, Stats additionalStats){
        Stats effectiveStats = new Stats();
        effectiveStats.setHealthPoints(baseStats.getHealthPoints() + additionalStats. getHealthPoints());
        effectiveStats.setStrength(baseStats.getStrength() + additionalStats.getStrength());
        effectiveStats.setDexterity(baseStats.getDexterity() + additionalStats. getDexterity());
        effectiveStats.setIntelligence(baseStats.getIntelligence() + additionalStats.getIntelligence());
        return effectiveStats;
    }
}
