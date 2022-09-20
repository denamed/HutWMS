package com.denamed.TestWMS.controllers;

import com.denamed.TestWMS.entities.Module;
import com.denamed.TestWMS.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Map;

@Controller
public class ModuleController {
    private final ModuleService moduleService;

    @Autowired
    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @GetMapping("/module")
    public String module(Model model) {
        List<Module> modules = moduleService.findAll();
        model.addAttribute("modules", modules);
        return "module-list";
    }

    @PostMapping("/module")
    public String addModule(@RequestParam Integer modulId,
                            @RequestParam Integer buildId,
                            @RequestParam String modulDesc,
                            Map<String, Object> model) {
        Module module = new Module(modulId, buildId, modulDesc);
        moduleService.saveModule(module);
        Iterable<Module> modules = moduleService.findAll();
        model.put("modules", modules);
        return "module-list";
    }
}
