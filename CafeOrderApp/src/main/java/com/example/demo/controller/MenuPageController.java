package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuPageController {

    @GetMapping("/menu-page")
    public String menuPage() {
        return "menu"; // templates/menu.html
    }
}
