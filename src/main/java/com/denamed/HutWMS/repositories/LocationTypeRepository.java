package com.denamed.HutWMS.repositories;

import com.denamed.HutWMS.entities.LocationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationTypeRepository extends JpaRepository<LocationType, Integer> {
    public List<LocationType> findByOrderByLocatTypeIdAsc();
}
