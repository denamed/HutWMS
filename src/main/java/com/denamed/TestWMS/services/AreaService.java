package com.denamed.TestWMS.services;

import com.denamed.TestWMS.entities.Area;
import com.denamed.TestWMS.repositories.AreaRepository;
import com.denamed.TestWMS.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService {

    private final AreaRepository areaRepository;
    private final ModuleRepository moduleRepository;

    @Autowired
    public AreaService(AreaRepository areaRepository, ModuleRepository moduleRepository) {
        this.areaRepository = areaRepository;
        this.moduleRepository = moduleRepository;
    }

    public List<Area> findAll() {
        return areaRepository.findByOrderByAreaIdAsc();
    }


}
