package com.denamed.TestWMS.controllers;

import com.denamed.TestWMS.entities.Building;
import com.denamed.TestWMS.repositories.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class BuildingController {
    @Autowired
    private BuildingRepository buildingRepository;

    @GetMapping("/building")
    public String building(Map<String, Object> model) {
        Iterable<Building> buildings = buildingRepository.findAll();
        model.put("buildings", buildings);
        return "building";
    }

    @PostMapping("/building")
    public String addBuilding(@RequestParam Integer id,
        @RequestParam String desc,
        Map<String, Object> model) {
        Building building = new Building(id, desc);
        buildingRepository.save(building);
        Iterable<Building> buildings = buildingRepository.findAll();
        model.put("buildings", buildings);
        return "building";
    }
}
