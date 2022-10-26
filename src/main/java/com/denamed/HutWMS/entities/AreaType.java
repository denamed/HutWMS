package com.denamed.HutWMS.entities;

import javax.persistence.*;

@Entity(name = "AreaType")
@Table(name = "areaType", uniqueConstraints = {@UniqueConstraint(name = "area_type_id_uniq", columnNames = "area_type_id")})
public class AreaType {
    @Id
    @Column(name = "area_type_id",
            columnDefinition = "INTEGER",
            nullable = false)
    private int areaTypeId;

    @Column(name = "area_type_desc",
            columnDefinition = "TEXT",
            length = 20)
    private String areaTypeDesc;

    public AreaType(){
    }

    public AreaType(int areaTypeId, String areaTypeDesc) {
        this.areaTypeId = areaTypeId;
        this.areaTypeDesc = areaTypeDesc;
    }

    public int getAreaTypeId() {
        return areaTypeId;
    }

    public void setAreaTypeId(int areaTypeId) {
        this.areaTypeId = areaTypeId;
    }

    public String getAreaTypeDesc() {
        return areaTypeDesc;
    }

    public void setAreaTypeDesc(String areaTypeDesc) {
        this.areaTypeDesc = areaTypeDesc;
    }

    @Override
    public String toString() {
        return "AreaType{" +
                "areaTypeId=" + areaTypeId +
                ", areaTypeDesc='" + areaTypeDesc + '\'' +
                '}';
    }
}