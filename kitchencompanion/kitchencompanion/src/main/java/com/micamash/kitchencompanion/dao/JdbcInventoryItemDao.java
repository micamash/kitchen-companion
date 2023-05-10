package com.micamash.kitchencompanion.dao;

import com.micamash.kitchencompanion.model.InventoryItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcInventoryItemDao implements InventoryItemDao {

    private final JdbcTemplate jdbcTemplate;
    private final JdbcItemDao jdbcItemDao;

    public JdbcInventoryItemDao(JdbcTemplate jdbcTemplate, JdbcItemDao jdbcItemDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcItemDao = jdbcItemDao;
    }

    @Override
    public List<InventoryItem> listAllInventory(int userId) {
        List<InventoryItem> list = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM inventory_item " +
                "WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        while (results.next()) {
            InventoryItem item = mapRowToInventoryItem(results);
            list.add(item);
        }
        return list;
    }

    @Override
    public List<InventoryItem> listInventoryByLocation(int userId, String storageLocation) {
        List<InventoryItem> list = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM inventory_item " +
                "JOIN item ON item.item_id = inventory_item.item_id " +
                "WHERE user_id = ? AND storage_location = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, storageLocation);

        while (results.next()) {
            InventoryItem item = mapRowToInventoryItem(results);
            list.add(item);
        }
        return list;
    }

    @Override
    public List<InventoryItem> searchInventoryItemByName(int userId, String name) {
        List<InventoryItem> list = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM inventory_item " +
                "WHERE user_id = ? AND name = ? " +
                "ORDER BY name";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, name);
        while (results.next()) {
            InventoryItem item = mapRowToInventoryItem(results);
            list.add(item);
        }
        return list;
    }

    @Override
    public InventoryItem getInventoryItemById(int inventoryItemId, int userId) {
        String sql = "SELECT * " +
                "FROM inventory_item " +
                "WHERE inventory_item_id = ? AND user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, inventoryItemId, userId);

        if (results.next()) {
            InventoryItem item = mapRowToInventoryItem(results);
            return item;
        }
        return null;
    }

    @Override
    public InventoryItem insertItemIntoInventory(InventoryItem item) {
        String sql = "INSERT INTO inventory_item(user_id, item_id, quantity) " +
                "VALUES (?, ?, ?) " +
                "RETURNING inventory_item_id";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, item.getUserId(), item.getItemId(), item.getQuantity());

        if (newId != null) {
            item.setInventoryItemId(newId);
            return item;
        } else {
            return null;
        }
    }

    @Override
    public void updateInventoryItemQuantity(InventoryItem updatedItem) {
        String sql = "UPDATE inventory_item " +
                "SET quantity = ? " +
                "WHERE inventory_item_id = ?";
        jdbcTemplate.update(sql, updatedItem.getQuantity(), updatedItem.getInventoryItemId());
    }

    @Override
    public void updateInventoryItemDateAdded(InventoryItem updatedItem) {
        String sql = "UPDATE inventory_item " +
                "SET date_added = ? " +
                "WHERE inventory_item_id = ?";
        jdbcTemplate.update(sql, updatedItem.getDateAdded(), updatedItem.getInventoryItemId());
    }

    @Override
    public void deleteItemFromInventory(int inventoryItemId, int userId) {
        String sql = "DELETE FROM inventory_item " +
                "WHERE inventory_item_id = ? AND user_id = ?";
        jdbcTemplate.update(sql, inventoryItemId, userId);
    }

    private InventoryItem mapRowToInventoryItem(SqlRowSet rowSet) {
        InventoryItem item = new InventoryItem();
        item.setInventoryItemId(rowSet.getInt("inventory_item_id"));
        item.setUserId(rowSet.getInt("user_id"));
        item.setItemId((rowSet.getInt("item_id")));
        item.setQuantity((rowSet.getInt("quantity")));
        item.setItem(jdbcItemDao.getById(rowSet.getInt("item_id)")));
        return item;
    }
}
