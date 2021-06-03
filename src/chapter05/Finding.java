//: chapter05/Finding.java

package chapter05;

import com.simple.classes.Dish;

import java.util.Optional;

public class Finding {
    private static boolean isVegetarianFriendlyMenu() {
        return Dish.getMENU().stream()
                .anyMatch(Dish::isVegetarian);
    }

    private static boolean isHealthyMenu() {
        return Dish.getMENU().stream()
                .allMatch(d -> d.getCalories() < 1000);
    }

    private static boolean isHealthyMenu2() {
        return Dish.getMENU().stream()
                .noneMatch(d -> d.getCalories() >= 1000);
    }

    private static Optional<Dish> findVegetarianDish() {
        return Dish.getMENU().stream()
                .filter(Dish::isVegetarian)
                .findAny();
    }

    public static void main(String... args) {
        if (isVegetarianFriendlyMenu())
            System.out.println("This menu is vegetarian friendly");
        System.out.println(isHealthyMenu());
        System.out.println(isHealthyMenu2());
        Optional<Dish> dish = findVegetarianDish();
        dish.ifPresent(d -> System.out.println(d.getName()));
    }
}
