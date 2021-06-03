//: chapter06/SummarizeDishes.java

package chapter06;

import com.simple.classes.Dish;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.function.BinaryOperator;

import static java.util.stream.Collectors.*;

public class SummarizeDishes {
    private static long howManyDishes() {
        return Dish.getMENU().stream().collect(counting());
    }

    private static Dish findMostCaloricDish() {
        return Dish.getMENU().stream().collect(
                reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)).get();
    }

    private static Dish findMostCaloricDishUsingComparator() {
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        BinaryOperator<Dish> moreCaloricOf = BinaryOperator.maxBy(dishCaloriesComparator);
        return Dish.getMENU().stream().collect(
                reducing(moreCaloricOf)).get();
    }

    private static int calculateTotalCalories() {
        return Dish.getMENU().stream().collect(
                summingInt(Dish::getCalories));
    }

    private static Double calculateAverageCalories() {
        return Dish.getMENU().stream().collect(
                averagingInt(Dish::getCalories));
    }

    private static IntSummaryStatistics calculateMenuStatistics() {
        return Dish.getMENU().stream().collect(
                summarizingInt(Dish::getCalories));
    }

    private static String getShortMenu() {
        return Dish.getMENU().stream()
                .map(Dish::getName)
                .collect(joining());
    }

    private static String getShortMenuCommaSeparated() {
        return Dish.getMENU().stream()
                .map(Dish::getName)
                .collect(joining(", "));
    }

    public static void main(String... args) {
        System.out.println("Number of dishes: " + howManyDishes());
        System.out.println("The most caloric dish is: " + findMostCaloricDish());
        System.out.println("The most caloric dish is: " + findMostCaloricDishUsingComparator());
        System.out.println("Total calories in menu: " + calculateTotalCalories());
        System.out.println("Average calories in menu: " + calculateAverageCalories());
        System.out.println("Menu statistics: " + calculateMenuStatistics());
        System.out.println("Short menu: " + getShortMenu());
        System.out.println("Short menu comma separated: " + getShortMenuCommaSeparated());
    }
}
