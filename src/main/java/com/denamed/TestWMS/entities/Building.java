package com.denamed.TestWMS.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Building")
@Table(name = "building",
    uniqueConstraints = {@UniqueConstraint(name = "build_id_uniq", columnNames = "build_id")})
public class Building {
    @Id
    @Column(name = "build_id",
            columnDefinition = "INTEGER",
            length = 2,
            nullable = false)
    private int buildId;

    @Column(name = "build_name",
            columnDefinition = "TEXT",
            length = 16)
    private String buildName;

    public Building(){
    }

    public Building(int buildId,
                    String buildName) {
        this.buildId = buildId;
        this.buildName = buildName;
    }

    public int getBuildId() {
        return buildId;
    }

    public void setBuildId(int buildId) {
        this.buildId = buildId;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    @Override
    public String toString() {
        return "Building{" +
                "build_id=" + buildId +
                ", build_name='" + buildName + '\'' +
                '}';
    }
}
