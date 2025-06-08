package com.example.demo.sale.dto;

public class SaleDTO {
    private int id;
    private String name;
    private int price;
    private String category;
    private boolean available;

    // Getter/Setter 필수
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}
