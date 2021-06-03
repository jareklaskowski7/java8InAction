//: com/simple/classes/AppleRedAndHeavyPredicate.java

package com.simple.classes;

import com.simple.interfaces.ApplePredicate;

public class AppleRedAndHeavyPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        return apple.getColor().equals("red") && apple.getWeight() > 150;
    }
}
