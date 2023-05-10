package com.micamash.kitchencompanion.model;

import java.time.LocalDate;

public class InventoryItem {

    private int inventoryItemId;
    private int userId;
    private int itemId;
    private int quantity;
    private LocalDate dateAdded;
    private Item item;

    public InventoryItem() {
    }

    public InventoryItem(int inventoryItemId, int userId, int itemId, int quantity, LocalDate dateAdded) {
        this.inventoryItemId = inventoryItemId;
        this.userId = userId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.dateAdded = dateAdded;
    }

    public int getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(int inventoryId) {
        this.inventoryItemId = inventoryId;
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

    public void setItem(Item item){this.item = item;}
}
