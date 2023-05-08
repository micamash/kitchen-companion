package com.micamash.kitchencompanion.model;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class Item {

    private int itemId;
    private String name;
    private String storageLocation;
    private LocalDate expirationDate;
    private String itemSize;
    private String imageName;

    public Item() {
    }

    public Item(int itemId, String name, String storageLocation, LocalDate expirationDate, String itemSize, String imageName) {
        this.itemId = itemId;
        this.name = name;
        this.storageLocation = storageLocation;
        this.expirationDate = expirationDate;
        this.itemSize = itemSize;
        this.imageName = imageName;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getItemSize() {
        return itemSize;
    }

    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

}
