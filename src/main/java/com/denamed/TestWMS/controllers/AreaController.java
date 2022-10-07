package com.denamed.TestWMS.controllers;

import com.denamed.TestWMS.entities.Area;
import com.denamed.TestWMS.entities.AreaType;
import com.denamed.TestWMS.entities.Module;
import com.denamed.TestWMS.services.AreaService;
import com.denamed.TestWMS.services.AreaTypeService;
import com.denamed.TestWMS.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AreaController {
    private final AreaService areaService;
    private final AreaTypeService areaTypeService;
    private final ModuleService moduleService;

    @Autowired
    public AreaController(AreaService areaService,
                          AreaTypeService areaTypeService,
                          ModuleService moduleService)
    {
        this.areaService = areaService;
        this.areaTypeService = areaTypeService;
        this.moduleService = moduleService;
    }

    public ArrayList areasListDecor()
    {
        List<Area> areas = areaService.findAll();

        List<AreaType> areaTypes = areaTypeService.findAll();
        Map<Integer, String> areaTypesMap = new HashMap<>();
        for (AreaType areaType: areaTypes) { areaTypesMap.put(areaType.getAreaTypeId(), areaType.getAreaTypeDesc()); }

        List<Module> modules = moduleService.findAll();
        Map<Integer, String> modulesMap = new HashMap<>();
        for (Module module: modules) { modulesMap.put(module.getModulId(), module.getModulDesc()); }

        ArrayList<Map> areasDecoratedList = new ArrayList<>();
        for (Area area: areas) {
            Map<String, String> tempMap = new HashMap<>();
            tempMap.put("areaId", area.getAreaId()+"");
            tempMap.put("areaName", area.getAreaName());

            int areaTypeId = area.getAreaTypeId();
            tempMap.put("areaTypeId", areaTypeId+"");
            if (areaTypesMap.get(areaTypeId) == null){
                tempMap.put("areaTypeDesc", "...");
            }else {
                tempMap.put("areaTypeDesc", areaTypesMap.get(areaTypeId));
            }
            int modulId = area.getModulId();
            tempMap.put("modulId", modulId+"");
            if(modulesMap.get(modulId) == null){
                tempMap.put("modulDesc", "...");
            }else {
            tempMap.put("modulDesc", modulesMap.get(modulId));
            }

            areasDecoratedList.add(tempMap);
        }
        return areasDecoratedList;
    }

    // Get list Area
    @GetMapping("/area")
    public String getList(Model model)
    {
        model.addAttribute("areas", areasListDecor());
        return "area-list";
    }

    // Get create Area
    @GetMapping("/area-create")
    public String getCreate(Model model)
    {
        model.addAttribute("modules", moduleService.findAll());
        model.addAttribute("areaTypes", areaTypeService.findAll());
        return "area-create";
    }

    // Get edit Area
    @GetMapping("/area-edit")
    public String getEdit(@RequestParam Integer areaId,
                          Model model)
    {
        try {
            Area area = areaService.findById(areaId).get();
            model.addAttribute("area", area);
            model.addAttribute("modules", moduleService.findAll());
            model.addAttribute("areaTypes", areaTypeService.findAll());
            return "area-edit";
        } catch (Exception e) {
            model.addAttribute("areas", areasListDecor());
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
            model.addAttribute("areas", areasListDecor());
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
        model.addAttribute("areas", areasListDecor());
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
        model.addAttribute("areas", areasListDecor());
        return "area-list";
    }
}