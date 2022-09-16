package com.denamed.TestWMS.repositories;

import com.denamed.TestWMS.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, Integer> {
}
