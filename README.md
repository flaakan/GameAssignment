# GameAssignment

This program is written by [Johnny Hoang](https://github.com/flaakan).

##
This is a simple game I created for an assignment. This game is an RPG where you can create a Hero  
and equip armor/weapon to boost your stats. The stats of the items are generated based on what type  
of aromor and what slot it fits in. All items stats increases for each level the item is. 


## Information
### Hero Classes
 There are three different hero classes you can choose from:
 * Archer
 * Warrior
 * Mage
 
### Hero Actions
I created a class for all the hero's actions and this class controlls the hero.

Here is some of the things a hero can do:
* **attack():** Attacks another hero. The damage is determined by the type of weapon the hero is using.
* **takeDamage():** Take damage from an attack.
* **gainExperience()** gain experience to level up. 
* **levelUp():** Level up.
* **equipItem():** Equip an item. 
* **show():** Show information of the Hero.

### Equipment
There is two types of eqiupment in this game:
* Weapon
* Armor

#### Weapon
There is two types of weapons in this game:
* Melee type weapons
* Range type weapons

#### Armor
There are three types of armors in this game:
* Plate aromor
* Leather armor
* Cloth armor

All of these come with different stats and it is based on the level, equipment slot and armor type of the item.
