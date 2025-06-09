package com.example.demo.sale.dao;

import com.example.demo.sale.dto.SaleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SaleDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 메뉴 추가
    public void insertSale(SaleDTO sale) {
        String sql = "INSERT INTO sale (name, category, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, sale.getName(), sale.getCategory(), sale.getPrice());
    }

    // 전체 메뉴 조회
    public List<SaleDTO> findAll() {
        String sql = "SELECT * FROM sale";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            SaleDTO dto = new SaleDTO();
            dto.setName(rs.getString("name"));
            dto.setCategory(rs.getString("category"));
            dto.setPrice(rs.getInt("price"));
            return dto;
        });
    }

    // 카테고리별 조회
    public List<SaleDTO> findByCategory(String category) {
        String sql = "SELECT * FROM sale WHERE category = ?";
        return jdbcTemplate.query(sql, new Object[]{category}, (rs, rowNum) -> {
            SaleDTO dto = new SaleDTO();
            dto.setName(rs.getString("name"));
            dto.setCategory(rs.getString("category"));
            dto.setPrice(rs.getInt("price"));
            return dto;
        });
    }
}
