//: com/simple/classes/AppleComparator.java

package com.simple.classes;

import java.util.Comparator;

public class AppleComparator implements Comparator<Apple> {
    public int compare(Apple apple1, Apple apple2) {
        return Integer.compare(apple1.getWeight(), apple2.getWeight());
    }
}
