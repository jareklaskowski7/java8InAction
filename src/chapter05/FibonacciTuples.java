//: chapter05/FibonacciTuples.java

package chapter05;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FibonacciTuples {
    public static void main(String... args) {
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));
        System.out.println();

        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .map(t -> t[0])
                .forEach(System.out::println);
        System.out.println();

        IntSupplier fibonacciNumbers = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            public int getAsInt() {
                int fibNumber = previous;
                int nextFibNumber = previous + current;
                this.previous = current;
                this.current = nextFibNumber;
                return fibNumber;
            }
        };
        IntStream.generate(fibonacciNumbers)
                .limit(20)
                .forEach(System.out::println);
    }
}
