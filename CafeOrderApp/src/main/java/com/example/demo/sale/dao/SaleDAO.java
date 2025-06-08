package com.example.demo.sale.dao;

import com.example.demo.sale.dto.SaleDTO;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SaleDAO {
    private final String url = "jdbc:mysql://localhost:3306/cafeapp";
    private final String user = "user";
    private final String password = "1234";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public List<SaleDTO> getAllMenus() throws SQLException {
        List<SaleDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM menu_items";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
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

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

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
