package com.denamed.HutWMS.repositories;

import com.denamed.HutWMS.entities.Area;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<Area, Integer> {
    boolean existsByModulId(int modulId);
}
