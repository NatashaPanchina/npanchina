package ru.job4j.students;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Filter
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 20.12.2018
 */
public class Filter {
    /**
     * Method levelOf
     * @param students
     * @param bound - grade point
     * @return students who have a grade point more bound
     */
    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted(Comparator.comparingInt(Student::getScope).reversed())
                .takeWhile(v -> v.getScope() > bound)
                .collect(Collectors.toList());
    }
}
