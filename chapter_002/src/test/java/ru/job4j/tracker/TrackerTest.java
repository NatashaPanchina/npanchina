package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 2
 * @since 0.1
 */
public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll().get(0), is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteOneItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 10L);
        Item second = new Item("test2", "testDescription2", 100L);
        Item third = new Item("test3", "testDescription3", 1000L);
        Item fourth = new Item("test4", "testDescription4", 10000L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.add(fourth);
        tracker.delete(tracker.getAll().get(0).getId());
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(second);
        expected.add(third);
        expected.add(fourth);
        assertThat(tracker.getAll(), is(expected));
    }

    @Test
    public void whenGetAllThenReturnItems() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 10L);
        Item second = new Item("test2", "testDescription2", 100L);
        Item third = new Item("test3", "testDescription3", 1000L);
        Item fourth = new Item("test4", "testDescription4", 10000L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.add(fourth);
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(first);
        expected.add(second);
        expected.add(third);
        expected.add(fourth);
        assertThat(tracker.getAll(), is(expected));
    }

    @Test
    public void whenFindItemByIdThenReturnOneWithThisId() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 10L);
        Item second = new Item("test2", "testDescription2", 100L);
        tracker.add(first);
        tracker.add(second);
        assertThat(tracker.findById(tracker.getAll().get(0).getId()), is(first));
    }

    @Test
    public void whenFindByNameThenReturnTwoItemsWithThisName() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 10L);
        Item second = new Item("test2", "testDescription2", 100L);
        Item third = new Item("test2", "testDescription3", 1000L);
        Item fourth = new Item("test3", "testDescription4", 10000L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.add(fourth);
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(second);
        expected.add(third);
        assertThat(tracker.findByName("test2"), is(expected));
    }
}
