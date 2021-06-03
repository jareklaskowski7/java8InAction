//: chapter06/PartitionDishes.java

package chapter06;

import com.simple.classes.Dish;
import com.simple.enums.DishType;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class PartitionDishes {
    private static Map<Boolean, List<Dish>> partitionDishesByVegetarian() {
        return Dish.getMENU().stream().collect(
                partitioningBy(Dish::isVegetarian));
    }

    private static List<Dish> filterDishesByVegetarian() {
        return Dish.getMENU().stream()
                .filter(Dish::isVegetarian).collect(toList());
    }

    private static Map<Boolean, Map<DishType, List<Dish>>> partitionTypeOfDishesByVegetarian() {
        return Dish.getMENU().stream().collect(
                partitioningBy(Dish::isVegetarian,
                        groupingBy(Dish::getDishType)));
    }

    private static Map<Boolean, Dish> partitionMostCaloricDishesByVegetarian() {
        return Dish.getMENU().stream().collect(
                partitioningBy(Dish::isVegetarian,
                        collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
    }

    public static void main(String... args) {
        System.out.println("Partition dishes by vegetarian: " + partitionDishesByVegetarian());
        System.out.println("Filter dishes by vegetarian: " + filterDishesByVegetarian());
        System.out.println("Partition type of dishes by vegetarian: " + partitionTypeOfDishesByVegetarian());
        System.out.println("Partition most caloric dishes by vegetarian: " + partitionMostCaloricDishesByVegetarian());
    }
}
