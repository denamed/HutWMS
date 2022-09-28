package com.denamed.TestWMS.services;

import com.denamed.TestWMS.entities.Building;
import com.denamed.TestWMS.repositories.BuildingRepository;
import com.denamed.TestWMS.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BuildingService {

    private final BuildingRepository buildingRepository;
    private final ModuleRepository moduleRepository;

    @Autowired
    public BuildingService(BuildingRepository buildingRepository,
                           ModuleRepository moduleRepository)
    {
        this.buildingRepository = buildingRepository;
        this.moduleRepository = moduleRepository;
    }

    public List<Building> findAll(){ return buildingRepository.findByOrderByBuildIdAsc(); }

    public Optional<Building> findById(int buildId) throws Exception
    {
        Optional<Building> building = buildingRepository.findById(buildId);
        if(building.isEmpty()) {
            throw new Exception("<div class=\"alert\">Required building not exists!</div>");
        } else {
            return building;
        }
    }

    public void create(Building building) throws Exception
    {
        if (buildingRepository.existsById(building.getBuildId())) {
            throw new Exception("<div class=\"alert\">Building " + building.getBuildId() + " is already exist!</div>");
        } else {
            buildingRepository.save(building);
        }
    }

    public void edit(Building building) { buildingRepository.save(building); }

    public void delete(int buildId) throws Exception
    {
        if (moduleRepository.existsByBuildId(buildId)) {
            throw new Exception("<div class=\"alert\">Building " + buildId + " have the modules!</div>");
        } else {
            buildingRepository.deleteById(buildId);
        }
    }
}