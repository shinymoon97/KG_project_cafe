package com.example.demo.sale.controller;

import com.example.demo.sale.dto.SaleDTO;
import com.example.demo.sale.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class SaleController {

    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping("/add")
    public SaleDTO addMenuItem(@RequestBody SaleDTO item) {
        return saleService.saveMenuItem(item);
    }

    @GetMapping
    public List<SaleDTO> getAllMenuItems() {
        return saleService.getAllMenuItems();
    }

    @GetMapping("/available")
    public List<SaleDTO> getAvailableMenuItems() {
        return saleService.getAvailableMenuItems();
    }

    @GetMapping("/category")
    public List<SaleDTO> getMenuItemsByCategory(@RequestParam String category) {
        return saleService.getMenuItemsByCategory(category);
    }
}