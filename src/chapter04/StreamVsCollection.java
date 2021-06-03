//: chapter04/StreamVsCollection.java

package chapter04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamVsCollection {
    public static void main(String... args) {
        List<String> names = Arrays.asList("Java8", "Lambdas", "In", "Action");
        Stream<String> str = names.stream();
        str.forEach(System.out::println);
        // uncommenting this line will result in an IllegalStateException
        // because streams can be consumed only once
        //s.forEach(System.out::println);
    }
}
