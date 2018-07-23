package ru.job4j.pseudo;

/**
 * Triangle.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Triangle implements Shape  {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   +   ");
        pic.append(System.lineSeparator());
        pic.append("  +++  ");
        pic.append(System.lineSeparator());
        pic.append(" +++++ ");
        pic.append(System.lineSeparator());
        pic.append("+++++++");
        return pic.toString();
    }
}
