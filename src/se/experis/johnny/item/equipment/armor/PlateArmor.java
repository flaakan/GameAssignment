package se.experis.johnny.item.equipment.armor;

import se.experis.johnny.item.equipment.EquipmentSlot;
import se.experis.johnny.stats.statsGenerator.armor.PlateArmorStatsGenerator;

public class PlateArmor extends Armor {


    public PlateArmor(String name, EquipmentSlot equipmentSlot) {
        super(name, ArmorType.PLATE, new PlateArmorStatsGenerator(), equipmentSlot);

    }
}
