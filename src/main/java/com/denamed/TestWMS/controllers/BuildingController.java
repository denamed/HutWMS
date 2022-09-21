package com.denamed.TestWMS.controllers;

import com.denamed.TestWMS.entities.Building;
import com.denamed.TestWMS.services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Map;

@Controller
public class BuildingController {
    private final BuildingService buildingService;

    @Autowired
    public BuildingController(BuildingService buildingService){
        this.buildingService = buildingService;
    }

    @GetMapping("/building")
    public String building(Model model) {
        List<Building> buildings = buildingService.findAll();
        model.addAttribute("buildings", buildings);
        return "building-list";
    }

    @PostMapping("/building")
    public String addBuilding(@RequestParam Integer buildId,
                              @RequestParam String buildName,
                              Map<String, Object> model)
    {
        Building building = new Building(buildId, buildName);
        try {
            buildingService.addBuilding(building);
        } catch(Exception e) {
            model.put("message", e.getMessage());
        }
        List<Building> buildings = buildingService.findAll();
        model.put("buildings", buildings);
        return "building-list";
    }
}
