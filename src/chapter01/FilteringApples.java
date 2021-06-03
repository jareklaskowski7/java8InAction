//: chapter01/FilteringApples.java

package chapter01;

import com.simple.classes.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilteringApples {
    private static List<Apple> filterGreenApples(List<Apple> applesInventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : applesInventory)
            if (apple.getColor().equals("green"))
                result.add(apple);
        return result;
    }

    private static List<Apple> filterHeavyApples(List<Apple> applesInventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : applesInventory)
            if (apple.getWeight() > 150)
                result.add(apple);
        return result;
    }

    private static List<Apple> filterApples(List<Apple> applesInventory, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : applesInventory)
            if (predicate.test(apple))
                result.add(apple);
        return result;
    }

    private static boolean isGreenApple(Apple apple) {
        return apple.getColor().equals("green");
    }

    private static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static void main(String... args) {
        List<Apple> greenApples = filterApples(Apple.getApplesInventory(), FilteringApples::isGreenApple);
        System.out.println("Filter green apples: " + greenApples);

        List<Apple> heavyApples = filterApples(Apple.getApplesInventory(), FilteringApples::isHeavyApple);
        System.out.println("Filter heavy apples: " + heavyApples);

        List<Apple> greenApples2 = filterApples(Apple.getApplesInventory(), (Apple apple) -> apple.getColor().equals("green"));
        System.out.println("Filter green apples: " + greenApples2);

        List<Apple> heavyApples2 = filterApples(Apple.getApplesInventory(), (Apple apple) -> apple.getWeight() > 150);
        System.out.println("Filter heavy apples: " + heavyApples2);

        List<Apple> weirdApples = filterApples(Apple.getApplesInventory(), (Apple apple) -> apple.getColor().equals("brown") || apple.getWeight() < 80);
        System.out.println("Filter weird apples: " + weirdApples);

        List<Apple> greenApples3 = filterGreenApples(Apple.getApplesInventory());
        System.out.println("Filter green apples: " + greenApples3);

        List<Apple> heavyApples3 = filterHeavyApples(Apple.getApplesInventory());
        System.out.println("Filter heavy apples: " + heavyApples3);
    }
}
