package com.micamash.kitchencompanion.controller;

import com.micamash.kitchencompanion.dao.ItemDao;
import com.micamash.kitchencompanion.dao.JdbcItemDao;
import com.micamash.kitchencompanion.model.Item;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/item")

public class ItemController {

    private ItemDao dao;

    public ItemController(JdbcItemDao dao) {
        this.dao = dao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Item> list(@RequestParam(defaultValue = "", required = false) String name, @RequestParam(defaultValue = "", required = false) String storageLocation) {

        if( !name.equals("") ) {
            return dao.searchByName(name);
        }
        if( !storageLocation.equals("")) {
            return dao.listItemsByLocation(storageLocation);
        }

        return dao.listAllItems();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Item getItemDetail(@PathVariable("id") int itemId) {
        return dao.getById(itemId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping( path = "", method = RequestMethod.POST)
    public Item createItem(@Valid @RequestBody Item item) {
        return dao.createItem(item);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void updateItem(@Valid @RequestBody Item updatedItem) {
        Item item = dao.updateItem(updatedItem);
        if (item == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable int itemId, @PathVariable int userId) {
        dao.deleteItem(itemId, userId);
    }

}
