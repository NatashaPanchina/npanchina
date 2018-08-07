package ru.job4j.tracker;

/**
 * Abstract class Base Action.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public abstract class BaseAction implements UserAction {
    private final int key;
    private final String info;

    protected BaseAction(final int key, final String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return this.key + ". " + this.info;
    }
}
