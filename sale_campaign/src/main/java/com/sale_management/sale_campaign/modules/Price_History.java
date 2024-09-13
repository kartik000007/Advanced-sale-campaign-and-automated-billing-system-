package com.sale_management.sale_campaign.modules;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Price_History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int history_id;

    private double discount_price;
    private LocalDate date;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;

    public Price_History(double discount_price, LocalDate date, Double price, Products product) {
        this.discount_price = discount_price;
        this.date = date;
        this.price = price;
        this.product = product;
    }

    public Price_History(){}

    public int getHistory_id() {
        return history_id;
    }

    public void setHistory_id(int history_id) {
        this.history_id = history_id;
    }

    public double getDiscount_price() {
        return discount_price;
    }

    public void setDiscount_price(double discount_price) {
        this.discount_price = discount_price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }
}
