package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] input = {"Hello", "World", "Hello", "Super", "World"};
        String[] expect = {"Hello", "World", "Super"};
        ArrayDuplicate array = new ArrayDuplicate();
        String[] result = array.remove(input);
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
}
