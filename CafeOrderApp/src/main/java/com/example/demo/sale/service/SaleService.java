package com.example.demo.sale.service;

import com.example.demo.sale.dao.SaleDAO;
import com.example.demo.sale.dto.SaleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Service
public class SaleService {

    private final SaleDAO saleDAO;

    @Autowired
    public SaleService(SaleDAO saleDAO) {
        this.saleDAO = saleDAO;
    }

    public List<SaleDTO> getAllMenuItems() {
        try {
            return saleDAO.getAllMenus();
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<SaleDTO> getMenuItemsByCategory(String category) {
        try {
            return saleDAO.getMenusByCategory(category);
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
