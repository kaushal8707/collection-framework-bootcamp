package com.zero.to.hero.java8_additional.streams;

public class InventoryProducts {
    int id;
    String name;
    String productType;
    int quantity;
    double price;
    String supplierName;

    public InventoryProducts(int id, String name, String productType, int quantity, double price, String supplierName) {
        this.id = id;
        this.name = name;
        this.productType = productType;
        this.quantity = quantity;
        this.price = price;
        this.supplierName = supplierName;
    }

    public InventoryProducts() {
    }
}