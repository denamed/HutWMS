package com.denamed.TestWMS.entities;

import javax.persistence.*;

@Entity(name = "LocationType")
@Table(name = "locationType", uniqueConstraints = {@UniqueConstraint(name = "locat_type_id_uniq", columnNames = "locat_type_id")})
public class LocationType {
    @Id
    @Column(name = "locat_type_id",
            columnDefinition = "INTEGER",
            nullable = false)
    private int locatTypeId;

    @Column(name = "locat_type_desc",
            columnDefinition = "TEXT",
            length = 20)
    private String locatTypeDesc;

    public LocationType() {
    }

    public LocationType(int locatTypeId, String locatTypeDesc) {
        this.locatTypeId = locatTypeId;
        this.locatTypeDesc = locatTypeDesc;
    }

    public int getLocatTypeId() {
        return locatTypeId;
    }

    public void setLocatTypeId(int locatTypeId) {
        this.locatTypeId = locatTypeId;
    }

    public String getLocatTypeDesc() {
        return locatTypeDesc;
    }

    public void setLocatTypeDesc(String locatTypeDesc) {
        this.locatTypeDesc = locatTypeDesc;
    }

    @Override
    public String toString() {
        return "LocationType{" +
                "locatTypeId=" + locatTypeId +
                ", locatTypeDesc='" + locatTypeDesc + '\'' +
                '}';
    }
}
