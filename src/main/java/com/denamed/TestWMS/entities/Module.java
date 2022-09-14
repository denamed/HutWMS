package com.denamed.TestWMS.entities;

import javax.persistence.*;

@Entity(name = "Module")
@Table(name = "module",
    uniqueConstraints = {@UniqueConstraint(name = "module_id_uniq", columnNames = "id")})
public class Module {
    @Id
    @Column(name = "id",
            columnDefinition = "INTEGER",
            length = 2,
            nullable = false)
    private int id;

    @Column(name = "building_id",
            columnDefinition = "INTEGER",
            length = 2,
            nullable = false)
    private int buildingId;

    @Column(name = "description",
            columnDefinition = "TEXT",
            length = 16)
    private String description;

    public Module(){
    }

    public Module(int id, int buildingId, String description) {
        this.id = id;
        this.buildingId = buildingId;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", buildingId=" + buildingId +
                ", description='" + description + '\'' +
                '}';
    }
}
