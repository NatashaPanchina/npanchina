package ru.job4j.tracker;

import java.util.*;

/**
 * Tracker.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Method add items.
     * @param item
     * @return item.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
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
        for (int index = 0; index < this.position; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(id)) {
                item.setId(id);
                this.items[index] = item;
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
        for (int index = 0; index < this.position; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(id)) {
                System.arraycopy(this.items, index + 1, this.items, index, this.items.length - 1 - index);
                items[this.position--] = null;
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
    public Item[] getAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Method find item by it's name.
     * @param key - input item's name
     * @return array of items with the same name.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int count = 0;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getName().equals(key)) {
                result[count++] = this.items[index];
            }
        }
        return Arrays.copyOf(result, count);
    }

    /**
     * Method find item by it's id.
     * @param id of item
     * @return the item with this id.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Method generate id for the items
     * @return generated id.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + this.RN.nextInt());
    }
}
