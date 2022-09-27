package com.denamed.TestWMS.repositories;

import com.denamed.TestWMS.entities.Area;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AreaRepository extends JpaRepository<Area, Integer> {
    List<Area> findByOrderByAreaIdAsc();
}
