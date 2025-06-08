package com.example.demo.sale.controller;

import com.example.demo.sale.dto.SaleDTO;
import com.example.demo.sale.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
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
    public String addMenuItem(@RequestBody SaleDTO sale) {
        try {
            saleService.addMenuItem(sale);
            return "메뉴가 추가되었습니다.";
        } catch (SQLException e) {
            return "오류: " + e.getMessage();
        }
    }

    @GetMapping
    public List<SaleDTO> getAllMenus() throws SQLException {
        return saleService.getAllMenuItems();
    }

    @GetMapping("/category")
    public List<SaleDTO> getMenusByCategory(@RequestParam String category) throws SQLException {
        return saleService.getMenuItemsByCategory(category);
    }
}
