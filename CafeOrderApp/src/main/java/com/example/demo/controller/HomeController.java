package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        // src/main/resources/templates/index.html 또는 static/index.html이 있어야 함
        return "index";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
