package com.example.demo.sale.service;

import com.example.demo.sale.dto.SaleDTO;
import com.example.demo.sale.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public SaleDTO saveMenuItem(SaleDTO item) {
        return saleRepository.save(item);
    }

    public List<SaleDTO> getAllMenuItems() {
        return saleRepository.findAll();
    }

    public List<SaleDTO> getAvailableMenuItems() {
        return saleRepository.findByAvailableTrue();
    }

    public List<SaleDTO> getMenuItemsByCategory(String category) {
        return saleRepository.findByCategory(category);
    }
}