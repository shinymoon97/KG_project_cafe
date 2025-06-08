package com.example.demo.controller;

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

    @GetMapping
    public List<SaleDTO> getAllMenuItems() {
        return saleService.getAllMenuItems();
    }

    @GetMapping("/category")
    public List<SaleDTO> getMenuItemsByCategory(@RequestParam String category) {
        return saleService.getMenuItemsByCategory(category);
    }
}
