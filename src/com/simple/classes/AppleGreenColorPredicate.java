//: com/simple/classes/AppleGreenColorPredicate.java

package com.simple.classes;

import com.simple.interfaces.ApplePredicate;

public class AppleGreenColorPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        return apple.getColor().equals("green");
    }
}
