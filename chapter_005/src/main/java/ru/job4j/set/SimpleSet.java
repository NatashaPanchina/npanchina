package ru.job4j.set;

import ru.job4j.list.DynamicList;

import java.util.Iterator;

/**
 * SimpleSet.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 6.03.2019
 */
public class SimpleSet<E> implements Iterable<E> {
    private DynamicList<E> container;

    public SimpleSet() {
        this.container = new DynamicList<>();
    }

    public boolean add(E e) {
        boolean result = !this.hasDuplicate(e);
        if (result) {
            this.container.add(e);
        }
        return result;
    }

    private boolean hasDuplicate(E e) {
        boolean result = false;
        for (E element : this.container) {
            if (element.equals(e)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public Iterator<E> iterator() {
        return this.container.iterator();
    }
}
