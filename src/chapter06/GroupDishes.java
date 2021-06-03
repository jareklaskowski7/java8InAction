//: chapter06/GroupDishes.java

package chapter06;

import com.simple.classes.Dish;
import com.simple.enums.CaloricLevel;
import com.simple.enums.DishType;

import java.util.*;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class GroupDishes {
    private static Map<DishType, List<Dish>> groupDishesByType() {
        return Dish.getMENU().stream().collect(
                groupingBy(Dish::getDishType));
    }

    private static Map<CaloricLevel, List<Dish>> groupDishesByCaloricLevel() {
        return Dish.getMENU().stream().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400)
                        return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700)
                        return CaloricLevel.NORMAL;
                    else
                        return CaloricLevel.FAT;
                }));
    }

    private static Map<DishType, Map<CaloricLevel, List<Dish>>> groupDishesByTypeAndCaloricLevel() {
        return Dish.getMENU().stream().collect(
                groupingBy(Dish::getDishType,
                        groupingBy(Dish::getCaloricLevelOfDish)));
    }

    private static Map<DishType, Long> countDishesInGroups() {
        return Dish.getMENU().stream().collect(
                groupingBy(Dish::getDishType, counting()));
    }

    private static Map<DishType, Optional<Dish>> groupMostCaloricDishesByType() {
        return Dish.getMENU().stream().collect(
                groupingBy(Dish::getDishType,
                        reducing((Dish d1, Dish d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)));
    }

    private static Map<DishType, Optional<Dish>> groupMostCaloricDishesByTypeImproved() {
        return Dish.getMENU().stream().collect(
                groupingBy(Dish::getDishType,
                        maxBy(comparingInt(Dish::getCalories))));
    }

    private static Map<DishType, Dish> groupMostCaloricDishesByTypeWithoutOptionals() {
        return Dish.getMENU().stream().collect(
                groupingBy(Dish::getDishType,
                        collectingAndThen(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2), Optional::get)));
    }

    private static Map<DishType, Dish> groupMostCaloricDishesByTypeWithoutOptionalsImproved() {
        return Dish.getMENU().stream().collect(
                groupingBy(Dish::getDishType,
                        collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
    }

    private static Map<DishType, Integer> sumOfCaloriesOfDishesByType() {
        return Dish.getMENU().stream().collect(
                groupingBy(Dish::getDishType,
                        summingInt(Dish::getCalories)));
    }

    private static Map<DishType, Set<CaloricLevel>> groupCaloricLevelsOfDishesByType() {
        return Dish.getMENU().stream().collect(
                groupingBy(Dish::getDishType,
                        mapping(Dish::getCaloricLevelOfDish, toSet())));
    }

    private static Map<DishType, Set<CaloricLevel>> groupCaloricLevelsOfDishesByTypeImproved() {
        return Dish.getMENU().stream().collect(
                groupingBy(Dish::getDishType,
                        mapping(Dish::getCaloricLevelOfDish, toCollection(HashSet::new))));
    }

    public static void main(String... args) {
        System.out.println("Group dishes by type: " + groupDishesByType());
        System.out.println("Group dishes by caloric level: " + groupDishesByCaloricLevel());
        System.out.println("Group dishes by type and caloric level: " + groupDishesByTypeAndCaloricLevel());
        System.out.println("Count dishes in groups: " + countDishesInGroups());
        System.out.println("Group most caloric dishes by type: " + groupMostCaloricDishesByType());
        System.out.println("Group most caloric dishes by type improved: " + groupMostCaloricDishesByTypeImproved());
        System.out.println("Group most caloric dishes by type without optionals: " + groupMostCaloricDishesByTypeWithoutOptionals());
        System.out.println("Group most caloric dishes by type without optionals improved: " + groupMostCaloricDishesByTypeWithoutOptionalsImproved());
        System.out.println("Sum of calories of dishes by type: " + sumOfCaloriesOfDishesByType());
        System.out.println("Group caloric levels of dishes by type: " + groupCaloricLevelsOfDishesByType());
        System.out.println("Group caloric levels of dishes by type improved: " + groupCaloricLevelsOfDishesByTypeImproved());
    }
}
