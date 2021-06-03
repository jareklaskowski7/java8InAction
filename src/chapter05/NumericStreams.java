//: chapter05/NumericStreams.java

package chapter05;

import com.simple.classes.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreams {
    public static boolean isPerfectSquare(int n) {
        return Math.sqrt(n) % 1 == 0;
    }

    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        Arrays.stream(numbers.toArray()).forEach(System.out::println);

        int calories = Dish.getMENU().stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println("Number of calories: " + calories);

        // max and OptionalInt
        OptionalInt max = Dish.getMENU().stream()
                .mapToInt(Dish::getCalories)
                .max();

        int maxCalories;
        if (max.isPresent()) {
            maxCalories = max.getAsInt();
        } else {
            // We can choose a default value
            maxCalories = 1;
        }
        System.out.println("Highest calories: " + maxCalories);

        // Numeric ranges
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println("Number of even numbers: " + evenNumbers.count());

        System.out.println("Pythagorean triples (int):");
        Stream<int[]> pythagoreanTriples1 =
                IntStream.rangeClosed(1, 100)
                        .boxed()
                        .flatMap(a -> IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .boxed()
                                .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
        pythagoreanTriples1.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

        System.out.println("Pythagorean triples (double):");
        Stream<double[]> pythagoreanTriples2 =
                IntStream.rangeClosed(1, 100)
                        .boxed()
                        .flatMap(a -> IntStream.rangeClosed(a, 100)
                                .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                                .filter(t -> t[2] % 1 == 0));
        pythagoreanTriples2.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }
}
