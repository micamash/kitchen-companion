package com.micamash.kitchencompanion.model;

import java.time.LocalDate;

public class Inventory {

    private int inventoryId;
    private int userId;
    private int itemId;
    private int quantity;
    private LocalDate dateAdded;

    public Inventory() {
    }

    public Inventory(int inventoryId, int userId, int itemId, int quantity, LocalDate dateAdded) {
        this.inventoryId = inventoryId;
        this.userId = userId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.dateAdded = dateAdded;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }
}
