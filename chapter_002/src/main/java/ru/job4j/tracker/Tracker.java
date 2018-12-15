package ru.job4j.tracker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Tracker.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 2
 * @since 0.1
 */
public class Tracker {
    private List<Item> items = new ArrayList<>();

    private static final Random RN = new Random();

    /**
     * Method add items.
     * @param item
     * @return item.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Method replace items.
     * @param id of item
     * @param item to replace.
     * @return true if operation was done successfully.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        item.setId(id);
        for (int index = 0; index < this.items.size(); index++) {
            if (this.items.get(index).getId().equals(id)) {
                this.items.set(index, item);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Method delete items.
     * @param id of the item.
     * @return true if operation was done successfully.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index < this.items.size(); index++) {
            if (this.items.get(index).getId().equals(id)) {
                this.items.remove(index);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Method get all items.
     * @return array of the items.
     */
    public List<Item> getAll() {
        return this.items;
    }

    /**
     * Method find item by it's name.
     * @param key - input item's name
     * @return array of items with the same name.
     */
    public List<Item> findByName(String key) {
        return this.items.stream()
                .filter(item -> item.getName().equals(key))
                .collect(Collectors.toList());

    }

    /**
     * Method find item by it's id.
     * @param id of item
     * @return the item with this id.
     */
    public Item findById(String id) {
        return this.items.stream()
                .filter(item -> item.getId().contains(id))
                .findFirst().orElse(null);
    }

    /**
     * Method generate id for the items
     * @return generated id.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + this.RN.nextInt());
    }
}
