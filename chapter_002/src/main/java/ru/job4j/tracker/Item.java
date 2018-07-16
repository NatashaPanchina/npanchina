package ru.job4j.tracker;

/**
 * Item.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Item {
    private String name;
    private String id;
    private String description;
    private long created;
    private String[] comments;

    public Item(String name, String description, long created) {
        this.name = name;
        this.description = description;
        this.created = created;
    }

    public void setId(String id) {
       this.id = id;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public long getCreated() {
        return this.created;
    }
}
