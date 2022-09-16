package com.denamed.TestWMS.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class IndexController {
    @GetMapping
    public String main(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Map<String, Object> model) {
                model.put("something", "Greetings, " + name);
                model.put("name", name);
                return "main";
                }
}
