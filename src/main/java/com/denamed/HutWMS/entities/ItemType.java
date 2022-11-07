package com.denamed.HutWMS.entities;

import javax.persistence.*;

@Entity(name = "ItemType")
@Table(name = "itemType", uniqueConstraints = {@UniqueConstraint(name = "item_type_id_uniq", columnNames = "item_type_id")})
public class ItemType {
    @Id
    @Column(name = "item_type_id",
            columnDefinition = "INTEGER",
            nullable = false)
    private int itemTypeId;

    @Column(name = "item_type_desc",
            columnDefinition = "TEXT",
            length = 16)
    private String itemTypeDesc;

    public ItemType() {
    }

    public ItemType(int itemTypeId, String itemTypeDesc) {
        this.itemTypeId = itemTypeId;
        this.itemTypeDesc = itemTypeDesc;
    }

    public int getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(int itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public String getItemTypeDesc() {
        return itemTypeDesc;
    }

    public void setItemTypeDesc(String itemTypeDesc) {
        this.itemTypeDesc = itemTypeDesc;
    }

    @Override
    public String toString() {
        return "ItemType{" +
                "itemTypeId=" + itemTypeId +
                ", itemTypeDesc='" + itemTypeDesc + '\'' +
                '}';
    }
}
