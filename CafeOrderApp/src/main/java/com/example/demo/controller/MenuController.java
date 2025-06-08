package com.example.demo.controller;

import com.example.demo.sale.dto.SaleDTO;
import com.example.demo.sale.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final SaleService saleService;

    @Autowired
    public MenuController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("/all")
    public List<SaleDTO> getAllMenus() {
        return saleService.getAllMenuItems();
    }

    @GetMapping("/category")
    public List<SaleDTO> getMenusByCategory(@RequestParam String category) {
        return saleService.getMenuItemsByCategory(category);
    }

    @PostMapping("/add")
    public void addMenu(@RequestBody SaleDTO saleDTO) {
        saleService.saveMenuItem(saleDTO);
    }
}
