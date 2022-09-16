package com.denamed.TestWMS.entities;

import javax.persistence.*;

@Entity(name = "Module")
@Table(name = "module",
    uniqueConstraints = {@UniqueConstraint(name = "modul_id_uniq", columnNames = "modul_id")})
public class Module {
    @Id
    @Column(name = "modul_id",
            columnDefinition = "INTEGER",
            length = 2,
            nullable = false)
    private int modulId;

    @Column(name = "build_id",
            columnDefinition = "INTEGER",
            length = 2,
            nullable = false)
    private int buildId;

    @Column(name = "modul_desc",
            columnDefinition = "TEXT",
            length = 16)
    private String modulDesc;

    public Module(){
    }

    public Module(int modulId, int buildId, String modulDesc) {
        this.modulId = modulId;
        this.buildId = buildId;
        this.modulDesc = modulDesc;
    }

    public int getModulId() {
        return modulId;
    }

    public void setModulId(int modulId) {
        this.modulId = modulId;
    }

    public int getBuildId() {
        return buildId;
    }

    public void setBuildId(int buildId) {
        this.buildId = buildId;
    }

    public String getModulDesc() {
        return modulDesc;
    }

    public void setModulDesc(String modulDesc) {
        this.modulDesc = modulDesc;
    }

    @Override
    public String toString() {
        return "Module{" +
                "modul_id=" + modulId +
                ", build_id=" + buildId +
                ", modul_desc='" + modulDesc + '\'' +
                '}';
    }
}
