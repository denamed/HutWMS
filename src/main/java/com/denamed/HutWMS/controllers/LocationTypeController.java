package com.denamed.HutWMS.controllers;

import com.denamed.HutWMS.entities.LocationType;
import com.denamed.HutWMS.services.LocationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LocationTypeController {
    private final LocationTypeService locationTypeService;

    @Autowired
    public LocationTypeController(LocationTypeService locationTypeService) {
        this.locationTypeService = locationTypeService;
    }

    //Get list
    @GetMapping("/locationType")
    public String getList(Model model)
    {
        List<LocationType> locationTypes = locationTypeService.findAll();
        model.addAttribute( "locationTypes", locationTypes);
        return "LocationType\\list";
    }

    //Get create
    @GetMapping("/locationType-create")
    public String getCreate() { return "LocationType\\create";}

    //get edit
    @GetMapping("/locationType-edit")
    public String getEdit(@RequestParam Short locatTypeId,
                          Model model)
    {
        try {
            LocationType locationType = locationTypeService.findById(locatTypeId).get();
            model.addAttribute("locationType", locationType);
            return "LocationType\\edit";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            model.addAttribute("locationType", locationTypeService.findAll());
            return "LocationType\\list";
        }
    }

    // Post create
    @PostMapping("/locationType-create")
    public String postCreate(@RequestParam Short locatTypeId,
                             @RequestParam String locatTypeDesc,
                             Model model)
    {
        LocationType locationType = new LocationType(locatTypeId, locatTypeDesc);
        try {
            locationTypeService.create(locationType);
            List <LocationType> locationTypes = locationTypeService.findAll();
            model.addAttribute("locationTypes", locationTypes);
            model.addAttribute("message", "Location Type successfully created.");
            return "LocationType\\list";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "LocationType\\create";
        }
    }

    // Post edit
    @PostMapping("/locationType-edit")
    public String postEdit(@RequestParam Short locatTypeId,
                           @RequestParam String locatTypeDesc,
                           Model model)
    {
        LocationType locationType = new LocationType(locatTypeId, locatTypeDesc);
        locationTypeService.edit(locationType);
        List<LocationType> locationTypes = locationTypeService.findAll();
        model.addAttribute("locationTypes", locationTypes);
        model.addAttribute("message", "Location Type successfully edited.");
        return "LocationType\\list";
    }

    // Post delete
    @PostMapping("/locationType-delete")
    public String postDelete(@RequestParam Short locatTypeId,
                             Model model)
    {
        try {
            locationTypeService.delete(locatTypeId);
            model.addAttribute("message", "Location Type successfully deleted.");
        } catch (Exception e) {
            model.addAttribute("message", "Unable to delete!");
        }
        List<LocationType> locationTypes = locationTypeService.findAll();
        model.addAttribute("locationTypes", locationTypes);
        return "LocationType\\list";
    }
}
