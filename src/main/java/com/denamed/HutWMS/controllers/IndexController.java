package com.denamed.HutWMS.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping(value = {"/", "/index"})
    public String main(Model model) {
        return "index";
    }
}