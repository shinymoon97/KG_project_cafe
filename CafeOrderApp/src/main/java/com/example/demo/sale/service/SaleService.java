package com.example.demo.sale.service;

import com.example.demo.sale.dao.SaleDAO;
import com.example.demo.sale.dto.SaleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class SaleService {

    private final SaleDAO saleDAO;

    @Autowired
    public SaleService(SaleDAO saleDAO) {
        this.saleDAO = saleDAO;
    }

    public void addMenuItem(SaleDTO sale) throws SQLException {
        saleDAO.insertMenu(sale);
    }

    public List<SaleDTO> getAllMenuItems() throws SQLException {
        return saleDAO.getAllMenus();
    }

    public List<SaleDTO> getMenuItemsByCategory(String category) throws SQLException {
        return saleDAO.getMenusByCategory(category);
    }
}
