//: chapter09/Intro.java

package chapter09;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.naturalOrder;

public class Intro {
    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(3, 5, 1, 2, 6);
        // sort is a default method
        // naturalOrder is a static method
        numbers.sort(naturalOrder());
        System.out.println(numbers);
    }
}
