package se.experis.johnny.item.equipment;

import se.experis.johnny.item.Item;

public abstract class Equipment extends Item {

    private EquipmentType equipmentType;
    private EquipmentSlot  equipmentSlot;
    private int level;

    public Equipment(String name, EquipmentType equipmentType, EquipmentSlot equipmentSlot) {
        super(name);
        this.equipmentType = equipmentType;
        this.level = 1;
        this.equipmentSlot = equipmentSlot;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    public EquipmentSlot getEquipmentSlot() {
        return equipmentSlot;
    }

    public void setEquipmentSlot(EquipmentSlot equipmentSlot) {
        this.equipmentSlot = equipmentSlot;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
