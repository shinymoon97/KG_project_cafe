package com.example.demo.sale.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "menu_items")
public class SaleDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int price;
    private String category;
    private boolean available;

    // 기본 생성자
    public SaleDTO() {}

    // 생성자
    public SaleDTO(String name, int price, String category, boolean available) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.available = available;
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
