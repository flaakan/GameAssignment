package se.experis.johnny.item.equipment.armor;

import se.experis.johnny.item.equipment.EquipmentSlot;
import se.experis.johnny.stats.statsGenerator.armor.LeatherArmorStatsGenerator;

public class LeatherArmor extends Armor{


    public LeatherArmor(String name, EquipmentSlot equipmentSlot) {
        super(name, ArmorType.LEATHER, new LeatherArmorStatsGenerator(),equipmentSlot);
    }
}
