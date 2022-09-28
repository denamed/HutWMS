package com.denamed.TestWMS.controllers;

import com.denamed.TestWMS.entities.Area;
import com.denamed.TestWMS.services.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class AreaController {
    private final AreaService areaService;

    @Autowired
    public AreaController(AreaService areaService) { this.areaService = areaService; }

    // Get list Area
    @GetMapping("/area")
    public String getList(Model model)
    {
        List<Area> areas = areaService.findAll();
        model.addAttribute("areas", areas);
        return "area-list";
    }

    // Get create Area
    @GetMapping("/area-create")
    public String getCreate() { return "area-create"; }

    // Get edit Area
    @GetMapping("/area-edit")
    public String getEdit(@RequestParam Integer areaId,
                          @RequestParam String areaName,
                          @RequestParam short areaTypeId,
                          @RequestParam int modulId,
                          Model model)
    {
        try {
            Area area = areaService.findById(areaId).get();
            model.addAttribute("area", area);
            return "area-edit";
        } catch (Exception e) {
            model.addAttribute("areas", areaService.findAll());
            model.addAttribute("message", e.getMessage());
            return "area-list";
        }
    }

    // Post create Area
    @PostMapping("/area-create")
    public String postCreate(@RequestParam Integer areaId,
                             @RequestParam String areaName,
                             @RequestParam short areaTypeId,
                             @RequestParam Integer modulId,
                             Model model)
    {
        Area area = new Area(areaId, areaName, areaTypeId, modulId);
        try {
            areaService.create(area);
            List<Area> areas = areaService.findAll();
            model.addAttribute("areas", areas);
            model.addAttribute("message", "Area created successfully.");
            return "area-list";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "area-create";
        }
    }

    // Post edit Area
    @PostMapping("/area-edit")
    public String postEdit(@RequestParam Integer areaId,
                           @RequestParam String areaName,
                           @RequestParam short areaTypeId,
                           @RequestParam Integer modulId,
                           Model model)
    {
        Area area = new Area(areaId, areaName, areaTypeId, modulId);
        areaService.edit(area);
        List<Area> areas = areaService.findAll();
        model.addAttribute("areas", areas);
        model.addAttribute("message", "Area edited successfully.");
        return "area-list";
    }

    // Post delete Area
    @PostMapping("/area-delete")
    public String postDelete(@RequestParam Integer areaId,
                             Model model)
    {
        try {
            areaService.delete(areaId);
            model.addAttribute("message", "Area deleted successfully.");
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        List<Area> areas = areaService.findAll();
        model.addAttribute("areas", areas);
        return "area-list";
    }
}