package com.sale_management.sale_campaign.modules;

import jakarta.persistence.*;

import java.util.*;
@Entity

@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "mrp")
    private double mrp;
    @Column(name = "current_price")
    private double currentPrice;
    @Column(name = "discount")
    private float discount;
    @Column(name = "inventory_count")
    double inventoryCount;


//    @Override
//    public String toString() {
//        return "Products{" +
//                "id=" + id +
//                ", productId=" + productId +
//                ", title='" + title + '\'' +
//                ", description='" + description + '\'' +
//                ", mrp=" + mrp +
//                ", currentPrice=" + currentPrice +
//                ", discount='" + discount + '\'' +
//                ", inventoryCount=" + inventoryCount +
//                ", priceHistory=" + priceHistory +
//                '}';
//    }

// Getter and setter


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMrp() {
        return mrp;
    }

    public void setMrp(double mrp) {
        this.mrp = mrp;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public double getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(double inventoryCount) {
        this.inventoryCount = inventoryCount;
    }


}

