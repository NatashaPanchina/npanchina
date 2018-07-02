package ru.job4j.array;

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
public class MergeTest {
    @Test
    public void whenTwoSortedArraysThenSortedArraysMerge() {
        Merge merge = new Merge();
        int[] first = {1, 2, 3, 4};
        int[] second = {3, 4, 5, 6, 7, 8};
        int[] result = merge.arraysMerge(first, second);
        int[] expected = {1, 2, 3, 3, 4, 4, 5, 6, 7, 8};
        assertThat(result, is(expected));
    }
}
