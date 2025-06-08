package com.example.demo.controller;

import com.example.demo.sale.dto.SaleDTO;
import com.example.demo.sale.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final SaleService saleService;

    @Autowired
    public MenuController(SaleService saleService) {
        this.saleService = saleService;
    }

    // 전체 메뉴 보기
    @GetMapping
    public List<SaleDTO> getAllMenus() throws SQLException {
        return saleService.getAllMenuItems();
    }

    // 카테고리별 메뉴 보기
    @GetMapping("/category")
    public List<SaleDTO> getMenusByCategory(@RequestParam String category) throws SQLException {
        return saleService.getMenuItemsByCategory(category);
    }

    // 메뉴 추가 (JSON POST)
    @PostMapping("/add")
    public String addMenu(@RequestBody SaleDTO sale) {
        try {
            saleService.addMenuItem(sale);
            return "메뉴 추가 완료";
        } catch (SQLException e) {
            return "DB 오류: " + e.getMessage();
        }
    }
}
