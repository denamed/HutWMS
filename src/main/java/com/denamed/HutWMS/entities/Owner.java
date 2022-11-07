package com.denamed.HutWMS.entities;

import javax.persistence.*;

@Entity(name = "Owner")
@Table(name = "owner",
    uniqueConstraints = {@UniqueConstraint(name = "owner_id_uniq", columnNames = "owner_id")})
public class Owner {
    @Id
    @Column(name = "owner_id",
            columnDefinition = "INTEGER",
            length = 2,
            nullable = false)
    private int ownerId;

    @Column(name = "owner_name",
            columnDefinition = "TEXT",
            length = 16)
    private String ownerName;

    public Owner() {
    }

    public Owner(int ownerId,
                 String ownerName) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "owner_id=" + ownerId +
                ", owner_name='" + ownerName + '\'' +
                '}';
    }
}
