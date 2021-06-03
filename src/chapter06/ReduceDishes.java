//: chapter06/ReduceDishes.java

package chapter06;

import com.simple.classes.Dish;

import static java.util.stream.Collectors.reducing;

public class ReduceDishes {
    private static int calculateTotalCalories() {
        return Dish.getMENU().stream().collect(
                reducing(0, Dish::getCalories, (Integer i, Integer j) -> i + j));
    }

    private static int calculateTotalCaloriesWithMethodReference() {
        return Dish.getMENU().stream().collect(
                reducing(0, Dish::getCalories, Integer::sum));
    }

    private static int calculateTotalCaloriesWithoutCollectors() {
        return Dish.getMENU().stream()
                .map(Dish::getCalories)
                .reduce(Integer::sum)
                .get();
    }

    private static int calculateTotalCaloriesUsingSum() {
        return Dish.getMENU().stream()
                .mapToInt(Dish::getCalories)
                .sum();
    }

    public static void main(String... args) {
        System.out.println("Total calories in menu: " + calculateTotalCalories());
        System.out.println("Total calories in menu: " + calculateTotalCaloriesWithMethodReference());
        System.out.println("Total calories in menu: " + calculateTotalCaloriesWithoutCollectors());
        System.out.println("Total calories in menu: " + calculateTotalCaloriesUsingSum());
    }
}
