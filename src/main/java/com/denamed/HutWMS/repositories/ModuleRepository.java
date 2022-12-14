package com.denamed.HutWMS.repositories;

import com.denamed.HutWMS.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module, Integer> {
    boolean existsByBuildId(int buildId);
}
