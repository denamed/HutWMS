package com.denamed.TestWMS.Controllers;

import com.denamed.TestWMS.Entities.Building;
import com.denamed.TestWMS.Repositories.BuildingRepository;
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
    public String addBuilding(@RequestParam Integer buildId,
        @RequestParam String buildName,
        Map<String, Object> model) {
        Building building = new Building(buildId, buildName);
        buildingRepository.save(building);
        Iterable<Building> buildings = buildingRepository.findAll();
        model.put("buildings", buildings);
        return "building";
    }
}
