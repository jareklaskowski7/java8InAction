//: com/simple/classes/AppleHeavyWeightPredicate.java

package com.simple.classes;

import com.simple.interfaces.ApplePredicate;

public class AppleHeavyWeightPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
