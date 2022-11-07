package com.denamed.HutWMS.repositories;

import com.denamed.HutWMS.entities.Catalogue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogueRepository extends JpaRepository<Catalogue, Integer> {
    boolean existsByOwnerId(int ownerId);
}
