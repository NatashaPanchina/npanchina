package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

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
    private Tracker tracker = new Tracker();
    private Input input;
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final StringBuilder menu = new StringBuilder()
            .append("0. Добавить новую заявку.")
            .append(System.lineSeparator())
            .append("1. Отобразить список всех заявок.")
            .append(System.lineSeparator())
            .append("2. Редактировать заявку.")
            .append(System.lineSeparator())
            .append("3. Удалить заявку.")
            .append(System.lineSeparator())
            .append("4. Найти заявку по ID.")
            .append(System.lineSeparator())
            .append("5. Найти заявки совпадающие по имени.")
            .append(System.lineSeparator())
            .append("6. Выйти из программы.")
            .append(System.lineSeparator());

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    public void buildInput(final String[] value) {
        input = new StubInput(value);
    }

    public void start() {
        new StartUI(this.input, this.tracker).init();
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        this.buildInput(new String[] {"0", "test name", "desc", "6"});
        this.start();
        assertThat(this.tracker.getAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Item item = this.tracker.add(new Item("test name", "desc"));
        this.buildInput(new String[] {"2", item.getId(), "test replace", "заменили заявку", "6"});
        this.start();
        assertThat(this.tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenReturnAllItems() {
        Item first = this.tracker.add(new Item("test1", "testDesc1"));
        Item second = this.tracker.add(new Item("test2", "testDesc2"));
        Item third = this.tracker.add(new Item("test3", "testDesc3"));
        this.buildInput(new String[] {"1", "6"});
        this.start();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                        .append(menu)
                        .append("------------ Все заявки ------------")
                        .append(System.lineSeparator())
                        .append(first)
                        .append(System.lineSeparator())
                        .append(second)
                        .append(System.lineSeparator())
                        .append(third)
                        .append(System.lineSeparator())
                        .append(menu)
                        .toString()
                ));
    }

    @Test
    public void whenUserDeleteItemThenTrackerHasAllItemsExceptOne() {
        Item first = this.tracker.add(new Item("test1", "testDesc1"));
        this.buildInput(new String[] {"3", first.getId(), "6"});
        this.start();
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                        .append(menu)
                        .append("------------ Удаление заявки ------------")
                        .append(System.lineSeparator())
                        .append("Удаление прошло успешно!")
                        .append(System.lineSeparator())
                        .toString()
                ));
    }

    @Test
    public void whenUserFindItemByIdThenReturnItemWithThisId() {
        Item first = this.tracker.add(new Item("test1", "testDesc1"));
        Item second = this.tracker.add(new Item("test2", "testDesc2"));
        this.buildInput(new String[] {"4", second.getId(), "6"});
        this.start();
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                        .append(menu)
                        .append("------------ Поиск заявки по ID ------------")
                        .append(System.lineSeparator())
                        .append("Искомая заявка: " + second)
                        .append(System.lineSeparator())
                        .toString()
                ));
    }

    @Test
    public void whenUserFindItemsByNameThenReturnAllItemsWithSameName() {
        Item first = this.tracker.add(new Item("test1", "testDesc1"));
        Item second = this.tracker.add(new Item("test2", "testDesc2"));
        Item third = this.tracker.add(new Item("test3", "testDesc3"));
        Item fourth = this.tracker.add(new Item("test3", "testDesc4"));
        this.buildInput(new String[] {"5", "test3", "6"});
        this.start();
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("------------ Поиск заявок ------------")
                                .append(System.lineSeparator())
                                .append("------------ Заявки с указанным именем ------------")
                                .append(System.lineSeparator())
                                .append("Заявка: " + third)
                                .append(System.lineSeparator())
                                .append("Заявка: " + fourth)
                                .append(System.lineSeparator())
                                .toString()
                ));
    }
}
