package com.example.demo.sale.repository;

import com.example.demo.sale.dto.SaleDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<SaleDTO, Long> {
    
    // 카테고리로 메뉴 검색
    List<SaleDTO> findByCategory(String category);

    // 판매 가능한 메뉴만 조회
    List<SaleDTO> findByAvailableTrue();
}