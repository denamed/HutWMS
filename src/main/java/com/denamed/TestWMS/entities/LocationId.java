package com.denamed.TestWMS.entities;

import java.io.Serializable;
import java.util.Objects;

public class LocationId implements Serializable {
    private int areaId;
    private short locatRow;
    private short locatPlace;
    private short locatLevel;

    public LocationId() {
    }

    public LocationId(int areaId, short locatRow, short locatPlace, short locatLevel) {
        this.areaId = areaId;
        this.locatRow = locatRow;
        this.locatPlace = locatPlace;
        this.locatLevel = locatLevel;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
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

    @Override
    public String toString() {
        return "LocationId{" +
                "areaId=" + areaId +
                ", locatRow=" + locatRow +
                ", locatPlace=" + locatPlace +
                ", locatLevel=" + locatLevel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationId that = (LocationId) o;
        return areaId == that.areaId && locatRow == that.locatRow && locatPlace == that.locatPlace && locatLevel == that.locatLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaId, locatRow, locatPlace, locatLevel);
    }
}
