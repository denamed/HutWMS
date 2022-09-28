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
    public BuildingController(BuildingService buildingService) { this.buildingService = buildingService; }

    // Get list Building
    @GetMapping("/building")
    public String getList(Model model)
    {
        List<Building> buildings = buildingService.findAll();
        model.addAttribute("buildings", buildings);
        return "building-list";
    }

    // Get create Building
    @GetMapping("/building-create")
    public String getCreate() { return "building-create"; }

    // Get edit Building
    @GetMapping("/building-edit")
    public String getEdit(@RequestParam Integer buildId,
                          Model model)
    {
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

    // Post create Building
    @PostMapping("/building-create")
    public String postCreate(@RequestParam Integer buildId,
                             @RequestParam String buildName,
                             Model model)
    {
        Building building = new Building(buildId, buildName);
        try {
            buildingService.create(building);
            List<Building> buildings = buildingService.findAll();
            model.addAttribute("buildings", buildings);
            model.addAttribute("message", "Building created successfully.");
            return "building-list";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "building-create";
        }
    }

    // Post edit Building
    @PostMapping("/building-edit")
    public String postEdit(@RequestParam Integer buildId,
                           @RequestParam String buildName,
                           Model model)
    {
        Building building = new Building(buildId, buildName);
        buildingService.edit(building);
        List<Building> buildings = buildingService.findAll();
        model.addAttribute("buildings", buildings);
        model.addAttribute("message", "Building edited successfully.");
        return "building-list";
    }

    // Post delete Building
    @PostMapping("/building-delete")
    public String postDelete(@RequestParam Integer buildId,
                             Model model)
    {
        try {
            buildingService.delete(buildId);
            model.addAttribute("message", "Building deleted successfully.");
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        List<Building> buildings = buildingService.findAll();
        model.addAttribute("buildings", buildings);
        return "building-list";
    }
}