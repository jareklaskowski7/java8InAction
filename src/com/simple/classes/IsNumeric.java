//: com/simple/classes/IsNumeric.java

package com.simple.classes;

import com.simple.interfaces.ValidationStrategy;

public class IsNumeric implements ValidationStrategy {
    public boolean execute(String str) {
        return str.matches("\\d+");
    }
}
