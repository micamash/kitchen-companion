package com.micamash.kitchencompanion.dao;

import com.micamash.kitchencompanion.model.InventoryItem;
import com.micamash.kitchencompanion.model.Item;

import java.util.List;

public interface InventoryItemDao {

    List<InventoryItem> listAllInventory(int userId);

    List<InventoryItem> listInventoryByLocation(int userId, String storageLocation);

    List<InventoryItem> searchInventoryItemByName(int userId, String name);

    InventoryItem getInventoryItemById(int inventoryItemId, int userId);

    InventoryItem insertItemIntoInventory(InventoryItem item);

    void updateInventoryItemQuantity(InventoryItem updatedItem);

    void updateInventoryItemDateAdded(InventoryItem updatedItem);

    void deleteItemFromInventory(int inventoryItemId, int userId);
}
