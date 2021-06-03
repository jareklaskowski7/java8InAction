//: com/simple/classes/Point.java

package com.simple.classes;

import java.util.Comparator;

import static java.util.Comparator.comparing;

public class Point {
    private final int x;
    private final int y;
    private static final Comparator<Point> COMPARE_BY_X_AND_THEN_Y = comparing(Point::getX).thenComparing(Point::getY);

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Comparator<Point> getCompareByXAndThenY() {
        return COMPARE_BY_X_AND_THEN_Y;
    }

    public Point moveRightBy(int z) {
        return new Point(x + z, y);
    }
}
