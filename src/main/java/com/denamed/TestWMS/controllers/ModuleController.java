package com.denamed.TestWMS.controllers;

import com.denamed.TestWMS.entities.Building;
import com.denamed.TestWMS.entities.Module;
import com.denamed.TestWMS.services.BuildingService;
import com.denamed.TestWMS.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class ModuleController {
    private final ModuleService moduleService;
    private final BuildingService buildingService;

    @Autowired
    public ModuleController(ModuleService moduleService, BuildingService buildingService) {
        this.moduleService = moduleService;
        this.buildingService = buildingService;
    }

    @GetMapping("/module")
    public String module(Model model) {
        List<Module> modules = moduleService.findAll();
        List<Building> buildings = buildingService.findAll();
        model.addAttribute("modules", modules);
        model.addAttribute("buildings", buildings);
        return "module-list";
    }

    @PostMapping("/module")
    public String addModule(@RequestParam Integer modulId,
                            @RequestParam Integer buildId,
                            @RequestParam String modulDesc,
                            Model model) {
        Module module = new Module(modulId, buildId, modulDesc);
        moduleService.saveModule(module);
        Iterable<Module> modules = moduleService.findAll();
        List<Building> buildings = buildingService.findAll();
        model.addAttribute("modules", modules);
        model.addAttribute("buildings", buildings);
        return "module-list";
    }
}
