package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[] {"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenReturnAllItems() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("test1", "testDesc1"));
        Item second = tracker.add(new Item("test2", "testDesc2"));
        Item third = tracker.add(new Item("test3", "testDesc3"));
        Input input = new StubInput(new String[] {"1", "6"});
        Item[] expected = {first, second, third};
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll(), is(expected));
    }

    @Test
    public void whenUserDeleteItemThenTrackerHasAllItemsExceptOne() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("test1", "testDesc1"));
        Item second = tracker.add(new Item("test2", "testDesc2"));
        Item third = tracker.add(new Item("test3", "testDesc3"));
        Item[] expected = {second, third};
        Input input = new StubInput(new String[] {"3", first.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll(), is(expected));
    }

    @Test
    public void whenUserFindItemByIdThenReturnItemWithThisId() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("test1", "testDesc1"));
        Item second = tracker.add(new Item("test2", "testDesc2"));
        Item third = tracker.add(new Item("test3", "testDesc3"));
        Input input = new StubInput(new String[] {"4", second.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(tracker.getAll()[1].getId()), is(second));
    }

    @Test
    public void whenUserFindItemsByNameThenReturnAllItemsWithSameName() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("test1", "testDesc1"));
        Item second = tracker.add(new Item("test2", "testDesc2"));
        Item third = tracker.add(new Item("test3", "testDesc3"));
        Item fourth = tracker.add(new Item("test3", "testDesc4"));
        Item[] expected = {third, fourth};
        Input input = new StubInput(new String[] {"5", "test3", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName("test3"), is(expected));
    }
}
