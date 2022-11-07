package com.denamed.HutWMS.entities;

import javax.persistence.*;

@Entity(name = "Catalogue")
@Table(name = "catalogue",
    uniqueConstraints = {@UniqueConstraint(name = "catalogue_id_uniq", columnNames = "catalogue_id")})
public class Catalogue {
    @Id
    @Column(name = "catalogue_id",
            columnDefinition = "INTEGER",
            length = 2,
            nullable = false)
    private int catalogueId;

    @Column(name = "owner_id",
            columnDefinition = "INTEGER",
            length = 2,
            nullable = false)
    private int ownerId;

    @Column(name = "catalogue_article",
            columnDefinition = "TEXT",
            length = 16)
    private String catalogueArticle;

    public Catalogue(){
    }

    public Catalogue(int catalogueId, int ownerId, String catalogueArticle) {
        this.catalogueId = catalogueId;
        this.ownerId = ownerId;
        this.catalogueArticle = catalogueArticle;
    }

    public int getCatalogueId() {
        return catalogueId;
    }

    public void setCatalogueId(int catalogueId) {
        this.catalogueId = catalogueId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getCatalogueArticle() {
        return catalogueArticle;
    }

    public void setCatalogueArticle(String catalogueArticle) {
        this.catalogueArticle = catalogueArticle;
    }

    @Override
    public String toString() {
        return "Catalogue{" +
                "catalogue_id=" + catalogueId +
                ", owner_id=" + ownerId +
                ", catalogue_article='" + catalogueArticle + '\'' +
                '}';
    }
}
