package com.denamed.TestWMS.repositories;

import com.denamed.TestWMS.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingRepository extends JpaRepository<Building, Integer> {
    List<Building> findByOrderByBuildIdAsc();
}
