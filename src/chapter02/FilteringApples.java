//: chapter02/FilteringApples.java

package chapter02;

import com.simple.classes.Apple;
import com.simple.classes.AppleGreenColorPredicate;
import com.simple.classes.AppleHeavyWeightPredicate;
import com.simple.classes.AppleRedAndHeavyPredicate;
import com.simple.interfaces.ApplePredicate;

import java.util.ArrayList;
import java.util.List;

public class FilteringApples {
    private static List<Apple> filterGreenApples(List<Apple> applesInventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : applesInventory)
            if (apple.getColor().equals("green"))
                result.add(apple);
        return result;
    }

    private static List<Apple> filterApplesByColor(List<Apple> applesInventory, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : applesInventory)
            if (apple.getColor().equals(color))
                result.add(apple);
        return result;
    }

    private static List<Apple> filterApplesByWeight(List<Apple> applesInventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : applesInventory)
            if (apple.getWeight() > weight)
                result.add(apple);
        return result;
    }

    private static List<Apple> filter(List<Apple> applesInventory, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : applesInventory)
            if (predicate.test(apple))
                result.add(apple);
        return result;
    }

    public static void main(String... args) {
        List<Apple> greenApples = filterApplesByColor(Apple.getApplesInventory(), "green");
        System.out.println("Filter green apples: " + greenApples);

        List<Apple> redApples = filterApplesByColor(Apple.getApplesInventory(), "red");
        System.out.println("Filter red apples: " + redApples);

        List<Apple> greenApples2 = filter(Apple.getApplesInventory(), new AppleGreenColorPredicate());
        System.out.println("Filter green apples: " + greenApples2);

        List<Apple> heavyApples = filter(Apple.getApplesInventory(), new AppleHeavyWeightPredicate());
        System.out.println("Filter heavy apples: " + heavyApples);

        List<Apple> redAndHeavyApples = filter(Apple.getApplesInventory(), new AppleRedAndHeavyPredicate());
        System.out.println("Filter red and heavy apples: " + redAndHeavyApples);

        List<Apple> redApples2 = filter(Apple.getApplesInventory(), new ApplePredicate() {
            public boolean test(Apple apple) {
                return apple.getColor().equals("red");
            }
        });
        System.out.println("Filter red apples: " + redApples2);
    }
}
