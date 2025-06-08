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

    @GetMapping("/all") // 전체 메뉴 데이터 (JSON)
    public List<SaleDTO> viewAllMenus() {
        return saleService.getAllMenuItems();
    }

    @GetMapping("/category/{category}") // 카테고리별 메뉴 (JSON)
    public List<SaleDTO> viewMenuByCategory(@PathVariable String category) {
        return saleService.getMenuItemsByCategory(category);
    }
}
