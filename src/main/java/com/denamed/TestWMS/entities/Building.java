package com.denamed.TestWMS.entities;

import javax.persistence.*;

@Entity(name = "Building")
@Table(name = "building",
        uniqueConstraints = {
        @UniqueConstraint(name = "building_id_uniq", columnNames = "id")
        })

public class Building {
    @Id
    @Column(name = "id",
            nullable = false,
            length = 2,
            columnDefinition = "INTEGER")
    private int id;

    @Column(name = "description",
            length = 16,
            columnDefinition = "TEXT")
    private String description;

    public Building(){
    }

    public Building(int id,
                    String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
