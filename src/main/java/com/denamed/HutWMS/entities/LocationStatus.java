package com.denamed.HutWMS.entities;

import javax.persistence.*;

@Entity(name = "Status")
@Table(name = "status", uniqueConstraints = {@UniqueConstraint(name = "locat_status_id_uniq", columnNames = "locat_status_id")})

public class LocationStatus {
    @Id
    @Column(name = "locat_status_id",
            columnDefinition = "INTEGER",
            length = 2,
            nullable = false)
    private short locatStatusId;

    @Column(name="locat_status_desc",
    columnDefinition = "TEXT",
    length = 16,
    nullable = false)
    private String locatStatusDesc;

    public LocationStatus(short locatStatusId, String locatStatusDesc) {
        this.locatStatusId = locatStatusId;
        this.locatStatusDesc = locatStatusDesc;
    }

    public LocationStatus() {
    }

    public short getLocatStatusId() {
        return locatStatusId;
    }

    public void setLocatStatusId(short locatStatusId) {
        this.locatStatusId = locatStatusId;
    }

    public String getLocatStatusDesc() {
        return locatStatusDesc;
    }

    public void setLocatStatusDesc(String locatStatusDesc) {
        this.locatStatusDesc = locatStatusDesc;
    }

    @Override
    public String toString() {
        return "LocationStatus{" +
                "locatStatusId=" + locatStatusId +
                ", locatStatusDesc='" + locatStatusDesc + '\'' +
                '}';
    }
}
