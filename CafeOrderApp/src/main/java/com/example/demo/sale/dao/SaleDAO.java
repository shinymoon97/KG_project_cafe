package com.example.demo.sale.dao;

import com.example.demo.sale.dto.SaleDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SaleDAO {

    private Connection conn;

    public SaleDAO(Connection conn) {
        this.conn = conn;
    }

    // 메뉴 등록
    public void insertMenu(SaleDTO sale) throws SQLException {
        String sql = "INSERT INTO menu_items (name, price, category, available) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sale.getName());
            pstmt.setInt(2, sale.getPrice());
            pstmt.setString(3, sale.getCategory());
            pstmt.setBoolean(4, sale.isAvailable());
            pstmt.executeUpdate();
        }
    }

    // 전체 메뉴 조회
    public List<SaleDTO> getAllMenus() throws SQLException {
        List<SaleDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM menu_items";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                SaleDTO sale = new SaleDTO();
                sale.setName(rs.getString("name"));
                sale.setPrice(rs.getInt("price"));
                sale.setCategory(rs.getString("category"));
                sale.setAvailable(rs.getBoolean("available"));
                list.add(sale);
            }
        }

        return list;
    }

    // 카테고리별 조회
    public List<SaleDTO> getMenusByCategory(String category) throws SQLException {
        List<SaleDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM menu_items WHERE category = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, category);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    SaleDTO sale = new SaleDTO();
                    sale.setName(rs.getString("name"));
                    sale.setPrice(rs.getInt("price"));
                    sale.setCategory(rs.getString("category"));
                    sale.setAvailable(rs.getBoolean("available"));
                    list.add(sale);
                }
            }
        }

        return list;
    }
}