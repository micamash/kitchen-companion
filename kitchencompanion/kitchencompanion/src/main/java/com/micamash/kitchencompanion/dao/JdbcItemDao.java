package com.micamash.kitchencompanion.dao;

import com.micamash.kitchencompanion.model.Item;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcItemDao implements ItemDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcItemDao(DataSource datasource) {
        jdbcTemplate = new JdbcTemplate(datasource);
    }

    @Override
    public List<Item> listAllItems() {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM item";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Item item = mapRowToItem(results);
            items.add(item);
        }
        return items;
    }

    @Override
    public List<Item> listItemsByLocation(String storageLocation) {
        List<Item> list = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM item " +
                "WHERE storage_location = ? " +
                "ORDER BY name";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, storageLocation);
        while (results.next()) {
            Item item = mapRowToItem(results);
            list.add(item);
        }
        return list;
    }

    @Override
    public List<Item> searchByName(String name) {
        List<Item> list = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM item " +
                "WHERE name = ? " +
                "ORDER BY name";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        while (results.next()) {
            Item item = mapRowToItem(results);
            list.add(item);
        }
        return list;
    }

    @Override
    public Item getById(int itemId) {
        Item item = null;
        String sql = "SELECT * " +
                "FROM item " +
                "WHERE item_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, itemId);
        if (results.next()) {
            item = mapRowToItem(results);
        }
        return item;
    }

    @Override
    public Item createItem(Item item) {
        String sql = "INSERT INTO item(name, storage_location, expiration_date, item_size, image_name) " +
                "VALUES (?, ?, ?, ?, ?) " +
                "RETURNING item_id";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, item.getName(), item.getStorageLocation(), item.getExpirationDate(), item.getItemSize(), item.getImageName());

        if(newId != null) {
            item.setItemId(newId);
            return item;
        } else {
            return null;
        }
    }

    @Override
    public Item updateItem(Item updatedItem) {
        Item updateResults = updatedItem;
        String sql = "UPDATE item " +
                "SET name = ?, storage_location = ?, expiration_date = ?, item_size = ?, image_name = ? " +
                "WHERE item_id = ?;";
        jdbcTemplate.update(sql, updatedItem.getName(), updatedItem.getStorageLocation(), updatedItem.getExpirationDate(), updatedItem.getItemSize(), updatedItem.getImageName(), updatedItem.getItemId());
        return updateResults;
    }

    @Override
    public void deleteItem(int ItemId, int userId) {
        String sql = "DELETE FROM item " +
                "WHERE item_id = ? AND user_id = ?";
        jdbcTemplate.update(sql, ItemId, userId);
    }

    private Item mapRowToItem(SqlRowSet rowSet) {
        Item item = new Item();
        item.setItemId(rowSet.getInt("item_id"));
        item.setName(rowSet.getString("name"));
        item.setStorageLocation(rowSet.getString("storage_location"));
        item.setExpirationDate(rowSet.getDate("expiration_date").toLocalDate());
        item.setItemSize(rowSet.getString("item_size"));
        item.setImageName(rowSet.getString("image_name"));
        return item;
    }
}
