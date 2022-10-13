package com.denamed.TestWMS.controllers;

import com.denamed.TestWMS.entities.Area;
import com.denamed.TestWMS.entities.Location;
import com.denamed.TestWMS.services.AreaService;
import com.denamed.TestWMS.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LocationController {
    private final LocationService locationService;
    private final AreaService areaService;

    @Autowired
    public LocationController(LocationService locationService, AreaService areaService) {
        this.locationService = locationService;
        this.areaService = areaService;
    }

    //Get list location
    @GetMapping("/location")
    public String getList(Model model)
    {
        model.addAttribute("locations", locationService.findAll());
        return "location-list";
    }

    //Get create
    @GetMapping("/location-create")
    public String getCreate(Model model)
    {
        model.addAttribute("areas", areaService.findAll());
        return "location-create";
    }

    //Get edit

    // Post create Area
    @PostMapping("/location-create")
    public String postCreate(@RequestParam Integer areaId,
                             @RequestParam short locatRow,
                             @RequestParam short locatPlace,
                             @RequestParam short locatLevel,
                             @RequestParam short locatCapacity,
                             @RequestParam short locatStatus,
                             @RequestParam short locatTypeId,
                             Model model)
    {
        Location location = new Location(areaId, locatRow, locatPlace, locatLevel, locatCapacity, locatStatus, locatTypeId);
        try {
            locationService.create(location);
            model.addAttribute("locations", locationService.findAll());
            model.addAttribute("message", "Location created successfully.");
            return "location-list";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "location-create";
        }
    }
}
