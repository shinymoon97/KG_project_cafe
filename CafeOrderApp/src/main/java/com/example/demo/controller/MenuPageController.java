package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuPageController {

    @GetMapping("/menuPage")
    public String showMenuPage() {
        return "menu"; // → templates/menu.html 로 이동
    }
}
