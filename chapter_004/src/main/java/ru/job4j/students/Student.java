package ru.job4j.students;

import java.util.Comparator;

public class Student implements Comparator<Student> {
    private String name;
    private int scope;

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public int compare(Student first, Student second) {
        return first.getName().compareTo(second.getName());
    }

    public String getName() {
        return this.name;
    }

    public int getScope() {
        return this.scope;
    }
}
