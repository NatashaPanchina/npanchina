package ru.job4j.generic;

/**
 * AbstractStore.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 20.02.2019
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> array;

    protected AbstractStore(int size) {
        array = new SimpleArray<>(size);
    }

    public void add(T model) {
        array.add(model);
    }

    public boolean replace(String id, T model) {
        boolean result = false;
        int index = this.getIndex(id);
        if (index != -1) {
            array.set(index, model);
            result = true;
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        int index = this.getIndex(id);
        if (index != -1) {
            array.remove(index);
            result = true;
        }
        return result;
    }

    public T findById(String id) {
        int index = this.getIndex(id);
        return index != -1 ? array.get(index) : null;
    }

    private int getIndex(String id) {
        int result = -1;
        int position = 0;
        for (T object : array) {
            if (object.getId().equals(id)) {
                result = position;
            }
            position++;
        }
        return result;
    }
}
