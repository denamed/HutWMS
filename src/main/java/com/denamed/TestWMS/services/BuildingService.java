package com.denamed.TestWMS.services;

import com.denamed.TestWMS.entities.Building;
import com.denamed.TestWMS.repositories.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MissingServletRequestParameterException;

import java.util.List;

@Service
public class BuildingService {

    private final BuildingRepository buildingRepository;

    @Autowired
    public BuildingService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public List<Building> findAll(){
        return buildingRepository.findAll();
    }

    public Building saveBuilding(Building building){
        return buildingRepository.save(building);
    }

    public void deleteBuilding(int buildId){
        buildingRepository.deleteById(buildId);
    }

}
