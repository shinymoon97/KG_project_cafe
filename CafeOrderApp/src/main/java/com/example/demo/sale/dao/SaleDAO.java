package com.example.demo.sale.dao;

import com.example.demo.sale.dto.SaleDTO;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SaleDAO {

    private final Connection conn;

    public SaleDAO() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/cafe_db?serverTimezone=Asia/Seoul";
        String user = "your_username";
        String pass = "your_password";
        this.conn = DriverManager.getConnection(url, user, pass);
    }

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

    public List<SaleDTO> getAllMenus() throws SQLException {
        List<SaleDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM menu_items";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                SaleDTO sale = new SaleDTO();
                sale.setId(rs.getInt("id"));
                sale.setName(rs.getString("name"));
                sale.setPrice(rs.getInt("price"));
                sale.setCategory(rs.getString("category"));
                sale.setAvailable(rs.getBoolean("available"));
                list.add(sale);
            }
        }
        return list;
    }

    public List<SaleDTO> getMenusByCategory(String category) throws SQLException {
        List<SaleDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM menu_items WHERE category = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, category);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    SaleDTO sale = new SaleDTO();
                    sale.setId(rs.getInt("id"));
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
