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
import java.util.Optional;

@Controller
public class ModuleController {
    private final ModuleService moduleService;
    private final BuildingService buildingService;

    @Autowired
    public ModuleController(ModuleService moduleService, BuildingService buildingService)
    {
        this.moduleService = moduleService;
        this.buildingService = buildingService;
    }

    //Get list module
    @GetMapping("/module")
    public String getList(Model model)
    {
        List<Module> modules = moduleService.findAll();
        List<Building> buildings = buildingService.findAll();
        model.addAttribute("modules", modules);
        model.addAttribute("buildings", buildings);
        return "module-list";
    }

    //Get create
    @GetMapping("/module-create")
    public String getCreate(Model model)
    {
        return "module-create";
    }

    //Get edit
    @GetMapping("/module-edit")
    public String getEdit (@RequestParam Integer modulId,
                           Model model)
    {
        try {
            Module module = moduleService.findById(modulId).get();
            model.addAttribute("module", module);
            return "module-edit";
        }catch(Exception e){
            model.addAttribute("message", e.getMessage());
            List<Module> modules = moduleService.findAll();
            model.addAttribute("modules", modules);
            return "module-list";
        }
    }

    @PostMapping("/module-create")
    public String postCreate(@RequestParam Integer modulId,
                             @RequestParam Integer buildId,
                             @RequestParam String modulDesc,
                             Model model)
    {
        Module module = new Module(modulId, buildId, modulDesc);
        try {
            moduleService.create(module);
            List<Module> modules = moduleService.findAll();
            model.addAttribute("modules", modules);
            model.addAttribute("message", "Module created successfully.");
            return "module-list";
        } catch (Exception e){
            model.addAttribute("message", e.getMessage());
            return "module-create";
        }
    }

    //Post edit
    @PostMapping("/module-edit")
    public String postEdit(@RequestParam int modulId,
                           @RequestParam String modulDesc,
                           @RequestParam int buildId,
                           Model model)
    {
       Module module = new Module(modulId, buildId, modulDesc);
       moduleService.edit(module);
       List<Module> modules = moduleService.findAll();
       model.addAttribute("modules", modules);
       model.addAttribute("message", "Module edited successfully.");
       return "module-list";
    }

    //Post delete
    @PostMapping("/module-delete")
    public String postDelete (@RequestParam int modulId,
                              Model model)
    {
        try{
            moduleService.delete(modulId);
            model.addAttribute("message", "Module deleted successfully.");
        }catch(Exception e){
            model.addAttribute("message", e.getMessage());
        }

        List<Module> modules = moduleService.findAll();
        model.addAttribute("modules", modules);
        return "module-list";
    }

}
