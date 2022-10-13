package com.denamed.TestWMS.entities;

import javax.persistence.*;

@Entity(name = "Location")
@Table(name = "location")
@IdClass(LocationId.class)
public class Location {
    @Id
    @Column(name = "area_id",
            columnDefinition = "INTEGER",
            length = 3,
            nullable = false)
    private int areaId;

    @Id
    @Column(name = "locat_row",
            columnDefinition = "INTEGER",
            length = 4,
            nullable = false)
    private short locatRow;

    @Id
    @Column(name = "locat_place",
            columnDefinition = "INTEGER",
            length = 4,
            nullable = false)
    private short locatPlace;

    @Id
    @Column(name = "locat_level",
            columnDefinition = "INTEGER",
            length = 4,
            nullable = false)
    private short locatLevel;

    @Column(name = "locat_capacity",
            columnDefinition = "INTEGER",
            length = 2,
            nullable = false)
    private short locatCapacity;

    @Column(name = "locat_status",
            columnDefinition = "INTEGER",
            length = 2,
            nullable = false)
    private short locatStatus;

    @Column(name = "locat_type_id",
            columnDefinition = "INTEGER",
            length = 3,
            nullable = false)
    private short locatTypeId;

    public Location() {
    }

    public Location( int areaId, short locatRow, short locatPlace, short locatLevel, short locatCapacity, short locatStatus, short locatTypeId) {
        this.areaId = areaId;
        this.locatRow = locatRow;
        this.locatPlace = locatPlace;
        this.locatLevel = locatLevel;
        this.locatCapacity = locatCapacity;
        this.locatStatus = locatStatus;
        this.locatTypeId = locatTypeId;
    }

    public short getLocatRow() {
        return locatRow;
    }

    public void setLocatRow(short locatRow) {
        this.locatRow = locatRow;
    }

    public short getLocatPlace() {
        return locatPlace;
    }

    public void setLocatPlace(short locatPlace) {
        this.locatPlace = locatPlace;
    }

    public short getLocatLevel() {
        return locatLevel;
    }

    public void setLocatLevel(short locatLevel) {
        this.locatLevel = locatLevel;
    }

    public short getLocatCapacity() {
        return locatCapacity;
    }

    public void setLocatCapacity(short locatCapacity) {
        this.locatCapacity = locatCapacity;
    }

    public short getLocatStatus() {
        return locatStatus;
    }

    public void setLocatStatus(short locatStatus) {
        this.locatStatus = locatStatus;
    }

    public short getLocatTypeId() {
        return locatTypeId;
    }

    public void setLocatTypeId(short locatTypeId) {
        this.locatTypeId = locatTypeId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locatRow=" + locatRow +
                ", locatPlace=" + locatPlace +
                ", locatLevel=" + locatLevel +
                ", locatCapacity=" + locatCapacity +
                ", locatStatus=" + locatStatus +
                ", locatTypeId=" + locatTypeId +
                ", areaId=" + areaId +
                '}';
    }
}
