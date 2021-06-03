//: com/simple/classes/IsAllLowerCase.java

package com.simple.classes;

import com.simple.interfaces.ValidationStrategy;

public class IsAllLowerCase implements ValidationStrategy {
    public boolean execute(String str) {
        return str.matches("[a-z]+");
    }
}
