package com.micamash.kitchencompanion.model;

import java.time.LocalDate;

public class ShoppingList {

    private int shoppingListId;
    private int userId;
    private String name;
    private LocalDate dateCreated;

    public ShoppingList() {
    }

    public ShoppingList(int shoppingListId, int userId, String name, LocalDate dateCreated) {
        this.shoppingListId = shoppingListId;
        this.userId = userId;
        this.name = name;
        this.dateCreated = dateCreated;
    }

    public int getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(int shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}
