package com.denamed.TestWMS.repositories;

import com.denamed.TestWMS.entities.Area;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<Area, Integer> {
    boolean existsByModulId(int modulId);
}
