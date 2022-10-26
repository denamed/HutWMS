package com.denamed.HutWMS.controllers;

import com.denamed.HutWMS.entities.AreaType;
import com.denamed.HutWMS.services.AreaTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class AreaTypeController {
    private final AreaTypeService areaTypeService;

    @Autowired
    public AreaTypeController(AreaTypeService areaTypeService) { this.areaTypeService = areaTypeService; }

    // Get list AreaType
    @GetMapping("/areaType")
    public String getList(Model model)
    {
        List<AreaType> areaTypes = areaTypeService.findAll();
        model.addAttribute( "areaTypes", areaTypes);
        return "AreaType\\list";
    }

    // Get create AreaType
    @GetMapping("/areaType-create")
    public String getCreate() { return "AreaType\\create"; }

    // Get edit AreaType
    @GetMapping("/areaType-edit")
    public String getEdit(@RequestParam Integer areaTypeId,
                          Model model)
    {
       try {
           AreaType areaType = areaTypeService.findById(areaTypeId).get();
           model.addAttribute("areaType", areaType);
           return "AreaType\\edit";
       } catch (Exception e) {
           model.addAttribute("message", e.getMessage());
           model.addAttribute("areaType", areaTypeService.findAll());
           return "AreaType\\list";
       }
    }

    // Post create AreaType
    @PostMapping("/areaType-create")
    public String postCreate(@RequestParam Integer areaTypeId,
                             @RequestParam String areaTypeDesc,
                             Model model)
    {
        AreaType areaType = new AreaType(areaTypeId, areaTypeDesc);
        try {
            areaTypeService.create(areaType);
            List <AreaType> areaTypes = areaTypeService.findAll();
            model.addAttribute("areaTypes", areaTypes);
            model.addAttribute("message", "Area type successfully created.");
            return "AreaType\\list";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "AreaType\\create";
        }
    }

    // Post edit AreaType
    @PostMapping("/areaType-edit")
    public String postEdit(@RequestParam Integer areaTypeId,
                           @RequestParam String areaTypeDesc,
                           Model model)
    {
        AreaType areaType = new AreaType(areaTypeId, areaTypeDesc);
        areaTypeService.edit(areaType);
        List<AreaType> areaTypes = areaTypeService.findAll();
        model.addAttribute("areaTypes",areaTypes);
        model.addAttribute("message", "Area type successfully edited.");
        return "AreaType\\list";
    }

    // Post delete AreaType
    @PostMapping("/areaType-delete")
    public String postDelete(@RequestParam Integer areaTypeId,
                             Model model)
    {
        try {
            areaTypeService.delete(areaTypeId);
            model.addAttribute("message", "Area type successfully deleted.");
        } catch (Exception e) {
            model.addAttribute("message", "Unable to delete!");
        }
        List<AreaType> areaTypes = areaTypeService.findAll();
        model.addAttribute("areaTypes", areaTypes);
        return "AreaType\\list";
    }
}