package se.experis.johnny.item.equipment.armor;

import se.experis.johnny.item.equipment.EquipmentSlot;
import se.experis.johnny.stats.statsGenerator.armor.ClothArmorStatsGenerator;

public class ClothArmor  extends Armor{

    public ClothArmor(String name, EquipmentSlot equipmentSlot) {
        super(name, ArmorType.CLOTH, new ClothArmorStatsGenerator(), equipmentSlot);
    }
}
