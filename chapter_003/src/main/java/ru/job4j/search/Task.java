package ru.job4j.search;

/**
 * Task.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 19.09.2018
 */
public class Task {
    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }
}
