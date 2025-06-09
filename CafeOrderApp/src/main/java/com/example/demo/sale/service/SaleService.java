package com.example.demo.sale.service;

import com.example.demo.sale.dao.SaleDAO;
import com.example.demo.sale.dto.SaleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleDAO saleDAO;

    public void saveMenuItem(SaleDTO saleDTO) {
        saleDAO.insertSale(saleDTO);
    }

    public List<SaleDTO> getAllMenuItems() {
        return saleDAO.findAll();
    }

    public List<SaleDTO> getMenuItemsByCategory(String category) {
        return saleDAO.findByCategory(category);
    }
}
