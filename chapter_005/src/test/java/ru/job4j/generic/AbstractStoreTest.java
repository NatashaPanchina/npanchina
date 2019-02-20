package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 20.02.2019
 */
public class AbstractStoreTest {
    @Test
    public void whenAddUser() {
        UserStore userStore = new UserStore(3);
        User second = new User("22");
        userStore.add(new User("11"));
        userStore.add(second);
        userStore.add(new User("333"));
        assertThat(userStore.findById("22"), is(second));
    }

    @Test
    public void whenDeleteUser() {
        UserStore userStore = new UserStore(3);
        User second = new User("22");
        userStore.add(new User("11"));
        userStore.add(second);
        userStore.add(new User("333"));
        assertThat(userStore.delete("22"), is(true));
    }

    @Test
    public void whenReplaceRole() {
        RoleStore roleStore = new RoleStore(3);
        Role role = new Role("000");
        roleStore.add(new Role("111"));
        roleStore.add(new Role("222"));
        roleStore.add(new Role("333"));
        roleStore.replace("111", role);
        assertThat(roleStore.findById("000"), is(role));
    }
}
