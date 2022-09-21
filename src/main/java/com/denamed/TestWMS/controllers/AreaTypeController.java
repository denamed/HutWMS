package com.denamed.TestWMS.controllers;

import com.denamed.TestWMS.entities.AreaType;
import com.denamed.TestWMS.services.AreaTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Map;

@Controller
public class AreaTypeController {
    private final AreaTypeService areaTypeService;

    @Autowired
    public AreaTypeController(AreaTypeService areaTypeService) {this.areaTypeService = areaTypeService;}

    @GetMapping("/areaType")
    public String areaType(Model model) {
        List<AreaType> areaTypes = areaTypeService.findAll();
        model.addAttribute( "areaTypes", areaTypes);
        return "areaType-list";
    }

    @PostMapping("/areaType")
    public String addAreaType(@RequestParam Integer areaTypeId,
                              @RequestParam String areaTypeDesc,
                              Map<String, Object> model){
        AreaType areaType = new AreaType(areaTypeId, areaTypeDesc);
        areaTypeService.saveAreaType(areaType);
        List<AreaType> areaTypes = areaTypeService.findAll();
        model.put("areaTypes", areaTypes);
        return "areaType-list";
    }

}
