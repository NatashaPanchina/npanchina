package ru.job4j.condition;

/**
 * Triangle.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод вычисления полупериметра по длинам сторон.
     *
     * Формула.
     *
     * (ab + ac + bc)/2
     *
     * @param ab расстояние между точками a b
     * @param ac расстояние между точками a c
     * @param bc расстояние между точками b c
     * @return Полупериметр.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    /**
     * Площадь треугольника.
     *
     * @return Вернуть площадь, если треугольник существует или -1, если
     * треугольника нет.
     */
    public double area() {
        double rsl = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(
                    p * (p - ab) * (p - ac) * (p - bc)
            );
        }
        return rsl;
    }

    /**
     * Треугольник существует только тогда, когда сумма
     * любых двух его сторон больше третьей.
     *
     * @param ab Длина от точки a до b.
     * @param ac Длина от точки a до c.
     * @param bc Длина от точки b до c.
     * @return
     */
    private boolean exist(double ab, double ac, double bc) {
        return (ab + ac) > bc;
    }
}
