package com.denamed.HutWMS.entities;

import javax.persistence.*;

@Entity(name = "Area")
@Table(name = "area",
    uniqueConstraints = {@UniqueConstraint(name = "area_id_uniq", columnNames = "area_id")})
public class Area {
    @Id
    @Column(name = "area_id",
            columnDefinition = "INTEGER",
            length = 3,
            nullable = false)
    private int areaId;

    @Column(name = "area_name",
            columnDefinition = "TEXT",
            length = 16)
    private String areaName;

    @Column(name = "area_type_id",
            columnDefinition = "INTEGER",
            length = 3,
            nullable = false)
    private short areaTypeId;

    @Column(name = "modul_id",
            columnDefinition = "INTEGER",
            length = 2,
            nullable = false)
    private int modulId;

    public Area() {
    }

    public Area(int areaId, String areaName, short areaTypeId, int modulId) {
        this.areaId = areaId;
        this.areaName = areaName;
        this.areaTypeId = areaTypeId;
        this.modulId = modulId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public short getAreaTypeId() {
        return areaTypeId;
    }

    public void setAreaTypeId(short areaTypeId) {
        this.areaTypeId = areaTypeId;
    }

    public int getModulId() {
        return modulId;
    }

    public void setModulId(int modulId) {
        this.modulId = modulId;
    }

    @Override
    public String toString() {
        return "Area{" +
                "areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                ", areaTypeId=" + areaTypeId +
                ", modulId=" + modulId +
                '}';
    }
}
