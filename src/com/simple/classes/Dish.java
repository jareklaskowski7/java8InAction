//: com/simple/classes/Dish.java

package com.simple.classes;

import com.simple.enums.CaloricLevel;
import com.simple.enums.DishType;

import java.util.Arrays;
import java.util.List;

public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final DishType dishType;
    private static final List<Dish> MENU = Arrays.asList(
            new Dish("pork", false, 800, DishType.MEAT),
            new Dish("beef", false, 700, DishType.MEAT),
            new Dish("chicken", false, 400, DishType.MEAT),
            new Dish("french fries", true, 530, DishType.OTHER),
            new Dish("rice", true, 350, DishType.OTHER),
            new Dish("season fruit", true, 120, DishType.OTHER),
            new Dish("pizza", true, 550, DishType.OTHER),
            new Dish("prawns", false, 400, DishType.FISH),
            new Dish("salmon", false, 450, DishType.FISH));

    public Dish(String name, boolean vegetarian, int calories, DishType dishType) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.dishType = dishType;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public DishType getDishType() {
        return dishType;
    }

    public static List<Dish> getMENU() {
        return MENU;
    }

    public String toString() {
        return name;
    }

    public CaloricLevel getCaloricLevelOfDish() {
        if (getCalories() <= 400)
            return CaloricLevel.DIET;
        else if (getCalories() <= 700)
            return CaloricLevel.NORMAL;
        else
            return CaloricLevel.FAT;
    }
}
