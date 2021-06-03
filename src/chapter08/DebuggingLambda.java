//: chapter08/DebuggingLambda.java

package chapter08;

import com.simple.classes.Point;

import java.util.Arrays;
import java.util.List;

public class DebuggingLambda {
    public static void main(String... args) {
        List<Point> points = Arrays.asList(new Point(12, 2), null);
        points.stream()
                .map(Point::getX)
                .forEach(System.out::println);
    }
}
