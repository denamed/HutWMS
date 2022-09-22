package com.denamed.TestWMS.services;

import com.denamed.TestWMS.entities.Building;
import com.denamed.TestWMS.repositories.BuildingRepository;
import com.denamed.TestWMS.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {

    private final BuildingRepository buildingRepository;
    private final ModuleRepository moduleRepository;

    @Autowired
    public BuildingService(BuildingRepository buildingRepository, ModuleRepository moduleRepository) {
        this.buildingRepository = buildingRepository;
        this.moduleRepository = moduleRepository;
    }

    public List<Building> findAll(){
        return buildingRepository.findByOrderByBuildIdAsc();
    }

    public Building createBuilding(Building building) throws Exception{
        if(buildingRepository.existsById(building.getBuildId())) {
            throw new Exception("<div class=\"alert\">Building " + building.getBuildId() + " already exists!</div>");
        } else {
            return buildingRepository.save(building);
        }
    }

    public void deleteBuilding(int buildId) throws Exception{
        if (moduleRepository.existsByBuildId(buildId)) {
            throw new Exception("<div class=\"alert\">Building " + buildId + " have the modules!</h2>");
        } else {
            buildingRepository.deleteById(buildId);
        }
    }

}
