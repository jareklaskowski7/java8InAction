//: chapter03/Sorting.java

package chapter03;

import com.simple.classes.Apple;
import com.simple.classes.AppleComparator;

import java.util.Comparator;

import static java.util.Comparator.comparing;

public class Sorting {
    public static void main(String... args) {
        // 1
        Apple.getApplesInventory().sort(new AppleComparator());
        System.out.println("Apples inventory: " + Apple.getApplesInventory());

        // Reshuffling things a little
        Apple.getApplesInventory().set(1, new Apple("green", 30));

        // 2
        Apple.getApplesInventory().sort(new Comparator<Apple>() {
            public int compare(Apple apple1, Apple apple2) {
                return Integer.compare(apple1.getWeight(), apple2.getWeight());
            }
        });
        System.out.println("Apples inventory: " + Apple.getApplesInventory());

        // Reshuffling things a little
        Apple.getApplesInventory().set(1, new Apple("red", 20));

        // 3
        Apple.getApplesInventory().sort((apple1, apple2) -> Integer.compare(apple1.getWeight(), apple2.getWeight()));
        System.out.println("Apples inventory: " + Apple.getApplesInventory());

        // Reshuffling things a little
        Apple.getApplesInventory().set(1, new Apple("red", 10));

        // 4
        Apple.getApplesInventory().sort(comparing(Apple::getWeight));
        System.out.println("Apples inventory: " + Apple.getApplesInventory());
    }
}
