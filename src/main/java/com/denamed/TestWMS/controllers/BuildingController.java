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

@Controller
public class BuildingController {
    private final BuildingService buildingService;

    @Autowired
    public BuildingController(BuildingService buildingService){
        this.buildingService = buildingService;
    }

    @GetMapping("/building")
    public String buildingList(Model model) {
        List<Building> buildings = buildingService.findAll();
        model.addAttribute("buildings", buildings);
        return "building-list";
    }

    @PostMapping("/building-delete")
    public String buildingDelete(@RequestParam Integer buildId, Model model) {
        try {
            buildingService.deleteBuilding(buildId);
            List<Building> buildings = buildingService.findAll();
            model.addAttribute("buildings", buildings);
            model.addAttribute("message", "Building successfully deleted.");
            return "building-list";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            List<Building> buildings = buildingService.findAll();
            model.addAttribute("buildings", buildings);
            return "building-list";
        }
    }

    @GetMapping("/building-edit")
    public String buildingEdit(@RequestParam Integer buildId, Model model) {
        try {
            Building building = buildingService.findById(buildId).get();
            model.addAttribute("building", building);
            return "building-edit";
        } catch (Exception e) {
            model.addAttribute("buildings", buildingService.findAll());
            model.addAttribute("message", e.getMessage());
            return "building-list";
        }
    }

    @PostMapping("/building-edit")
    public String editBuilding(@RequestParam Integer buildId,
                               @RequestParam String buildName,
                               Model model) {
        Building building = new Building(buildId, buildName);
        buildingService.editBuilding(building);
        List<Building> buildings = buildingService.findAll();
        model.addAttribute("buildings", buildings);
        model.addAttribute("message", "Building successfully edited.");
        return "building-list";
    }

    @GetMapping("/building-create")
    public String buildingCreate() {
        return "building-create";
    }

    @PostMapping("/building-create")
    public String addBuilding(@RequestParam Integer buildId,
                              @RequestParam String buildName,
                              Model model)
    {
        Building building = new Building(buildId, buildName);
        try {
            buildingService.createBuilding(building);
            List<Building> buildings = buildingService.findAll();
            model.addAttribute("buildings", buildings);
            model.addAttribute("message", "Building successfully created.");
            return "building-list";
        } catch(Exception e) {
            model.addAttribute("message", e.getMessage());
            return "building-create";
        }
    }
}
