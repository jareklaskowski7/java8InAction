//: chapter03/Lambdas.java

package chapter03;

import com.simple.classes.Apple;
import com.simple.interfaces.ApplePredicate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lambdas {
    private static List<Apple> filter(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory)
            if (p.test(apple))
                result.add(apple);
        return result;
    }

    public static void main(String... args) {
        // Simple example
        Runnable r = () -> System.out.println("Hello!");
        r.run();

        List<Apple> greenApples = filter(Apple.getApplesInventory(), (Apple apple) -> "green".equals(apple.getColor()));
        System.out.println("Filter green apples: " + greenApples);

        Comparator<Apple> c = (Apple apple1, Apple apple2) -> Integer.compare(apple1.getWeight(), apple2.getWeight());
        Apple.getApplesInventory().sort(c);
        System.out.println("Sort apples inventory: " + Apple.getApplesInventory());
    }
}
