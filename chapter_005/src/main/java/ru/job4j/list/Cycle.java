package ru.job4j.list;

/**
 * Cycle.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 5.03.2019
 */
public class Cycle {
    /**
     * Method hasCycle
     * @param first - node
     * @return true if the list of nodes has cycle
     *         else false
     */
    public boolean hasCycle(Node first) {
        boolean result = false;
        Node node = first;
        Node checked = first;
        if (first.next != null) {
            while (checked != null && checked.next != null) {
                node = node.next;
                checked = checked.next.next;
                if (node == checked) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
