package ru.job4j.loop;

import org.junit.Test;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PaintTest {
    @Test
    public void whenPyramidWithHeightFour() {
        Paint paint = new Paint();
        String result = paint.pyramid(4);
        assertThat(result,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                        .add("   ^   ")
                        .add("  ^^^  ")
                        .add(" ^^^^^ ")
                        .add("^^^^^^^")
                        .toString()
                )
        );
    }

    @Test
    public void whenPyramidWithHeightEight() {
        Paint paint = new Paint();
        String result = paint.pyramid(8);
        assertThat(result,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                        .add("       ^       ")
                        .add("      ^^^      ")
                        .add("     ^^^^^     ")
                        .add("    ^^^^^^^    ")
                        .add("   ^^^^^^^^^   ")
                        .add("  ^^^^^^^^^^^  ")
                        .add(" ^^^^^^^^^^^^^ ")
                        .add("^^^^^^^^^^^^^^^")
                        .toString()
                )
        );
    }
}
