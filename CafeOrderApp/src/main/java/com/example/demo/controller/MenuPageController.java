package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu-page")
public class MenuPageController {

    @GetMapping
    public String menuPage() {
        return "menu"; // templates/menu.html 렌더링
    }
}
