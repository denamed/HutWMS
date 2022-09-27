package com.denamed.TestWMS.entities;

import java.io.Serializable;

public class LocationId implements Serializable {
    private int areaId;
    private short locatRow;
    private short locatPlace;
    private short locatLevel;

    public LocationId(int areaId, short locatRow, short locatPlace, short locatLevel) {
        this.areaId = areaId;
        this.locatRow = locatRow;
        this.locatPlace = locatPlace;
        this.locatLevel = locatLevel;
    }
}
