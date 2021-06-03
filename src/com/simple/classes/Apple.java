//: com/simple/classes/Apple.java

package com.simple.classes;

import java.util.Arrays;
import java.util.List;

public class Apple {
    private final String color;
    private final int weight;
    private static final List<Apple> APPLES_INVENTORY = Arrays.asList(
            new Apple("green", 80),
            new Apple("green", 155),
            new Apple("red", 120));

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public static List<Apple> getApplesInventory() {
        return APPLES_INVENTORY;
    }

    public String toString() {
        return "Apple{color=" + color + ", weight=" + weight + "}";
    }
}
