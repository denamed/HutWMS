package com.denamed.HutWMS.controllers;

import com.denamed.HutWMS.entities.LocationStatus;
import com.denamed.HutWMS.services.LocationStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LocationStatusController {
    private final LocationStatusService locationStatusService;

    @Autowired
    public LocationStatusController(LocationStatusService locationStatusService) {
        this.locationStatusService = locationStatusService;
    }

    //Get list
    @GetMapping("/locationStatus")
    public String getList(Model model)
    {
        List<LocationStatus> locationStatuses = locationStatusService.findAll();
        model.addAttribute( "locationStatuses", locationStatuses);
        return "LocationStatus\\list";
    }

    //Get create
    @GetMapping("/locationStatus-create")
    public String getCreate() { return "LocationStatus\\create";}

    //get edit
    @GetMapping("/locationStatus-edit")
    public String getEdit(@RequestParam Short locatStatusId,
                          Model model)
    {
        try {
            LocationStatus locationStatus = locationStatusService.findById(locatStatusId).get();
            model.addAttribute("locationStatus", locationStatus);
            return "LocationStatus\\edit";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            model.addAttribute("locationStatus", locationStatusService.findAll());
            return "LocationStatus\\list";
        }
    }

    // Post create
    @PostMapping("/locationStatus-create")
    public String postCreate(@RequestParam Short locatStatusId,
                             @RequestParam String locatStatusDesc,
                             Model model)
    {
        LocationStatus locationStatus = new LocationStatus(locatStatusId, locatStatusDesc);
        try {
            locationStatusService.create(locationStatus);
            List <LocationStatus> locationStatuses = locationStatusService.findAll();
            model.addAttribute("locationStatuses", locationStatuses);
            model.addAttribute("message", "Location Status successfully created.");
            return "LocationStatus\\list";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "LocationStatus\\create";
        }
    }

    // Post edit
    @PostMapping("/locationStatus-edit")
    public String postEdit(@RequestParam Short locatStatusId,
                           @RequestParam String locatStatusDesc,
                           Model model)
    {
        LocationStatus locationStatus = new LocationStatus(locatStatusId, locatStatusDesc);
        locationStatusService.edit(locationStatus);
        List<LocationStatus> locationStatuses = locationStatusService.findAll();
        model.addAttribute("locationStatuses", locationStatuses);
        model.addAttribute("message", "Location status successfully edited.");
        return "LocationStatus\\list";
    }

    // Post delete
    @PostMapping("/locationStatus-delete")
    public String postDelete(@RequestParam Short locatStatusId,
                             Model model)
    {
        try {
            locationStatusService.delete(locatStatusId);
            model.addAttribute("message", "Location status successfully deleted.");
        } catch (Exception e) {
            model.addAttribute("message", "Unable to delete!");
        }
        List<LocationStatus> locationStatuses = locationStatusService.findAll();
        model.addAttribute("locationStatuses", locationStatuses);
        return "LocationStatus\\list";
    }
}
