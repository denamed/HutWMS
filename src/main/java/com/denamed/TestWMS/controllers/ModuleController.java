package com.denamed.TestWMS.controllers;

import com.denamed.TestWMS.entities.Module;
import com.denamed.TestWMS.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ModuleController {
    @Autowired
    private ModuleRepository moduleRepository;

    @GetMapping("/module")
    public String module(Map<String, Object> model) {
        Iterable<Module> modules = moduleRepository.findAll();
        model.put("modules", modules);
        return "module";
    }

    @PostMapping("/module")
    public String addModule(@RequestParam Integer modulId,
                              @RequestParam Integer buildId,
                              @RequestParam String modulDesc,
                              Map<String, Object> model) {
        Module module = new Module(modulId, buildId, modulDesc);
        moduleRepository.save(module);
        Iterable<Module> modules = moduleRepository.findAll();
        model.put("modules", modules);
        return "module";
    }
}