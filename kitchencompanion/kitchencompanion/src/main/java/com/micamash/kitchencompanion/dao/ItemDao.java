package com.micamash.kitchencompanion.dao;

import com.micamash.kitchencompanion.model.Item;

import java.util.List;

public interface ItemDao {

    List<Item> listAllItems();

    List<Item> listItemsByLocation(String storageLocation);

    List<Item> searchByName(String name);

    Item getById(int itemId);


    public Item createItem(Item item);

    public Item updateItem(Item updatedItem);

    public void deleteItem(int ItemId, int userId);
}

