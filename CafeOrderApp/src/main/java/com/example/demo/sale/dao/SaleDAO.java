package com.example.demo.sale.dao;

import com.example.demo.sale.dto.SaleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SaleDAO {

    private final DataSource dataSource;

    @Autowired
    public SaleDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // 메뉴 추가
    public void insertMenu(SaleDTO sale) throws SQLException {
        String sql = "INSERT INTO menu_items (name, price, category, available) VALUES (?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

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

        try (Connection conn = dataSource.getConnection();
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

    // 카테고리별 메뉴 조회
    public List<SaleDTO> getMenusByCategory(String category) throws SQLException {
        List<SaleDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM menu_items WHERE category = ?";

        try (Connection conn = dataSource.getConnection();
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

    // 사용 가능한 메뉴 조회
    public List<SaleDTO> getAvailableMenus() throws SQLException {
        List<SaleDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM menu_items WHERE available = true";

        try (Connection conn = dataSource.getConnection();
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
}
