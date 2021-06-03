//: chapter04/StreamBasic.java

package chapter04;

import com.simple.classes.Dish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class StreamBasic {
    private static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes) {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : dishes)
            if (dish.getCalories() < 400)
                lowCaloricDishes.add(dish);
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish dish1, Dish dish2) {
                return Integer.compare(dish1.getCalories(), dish2.getCalories());
            }
        });
        for (Dish dish : lowCaloricDishes)
            lowCaloricDishesName.add(dish.getName());
        return lowCaloricDishesName;
    }

    private static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes) {
        return dishes.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }

    public static void main(String... args) {
        System.out.println("Low caloric dishes names in Java 7:");
        getLowCaloricDishesNamesInJava7(Dish.getMENU()).forEach(System.out::println);
        System.out.println("---");
        System.out.println("Low caloric dishes names in Java 8:");
        getLowCaloricDishesNamesInJava8(Dish.getMENU()).forEach(System.out::println);
    }
}
