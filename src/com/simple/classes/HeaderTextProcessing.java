//: com/simple/classes/HeaderTextProcessing.java

package com.simple.classes;

import com.simple.abstractClasses.ProcessingObject;

public class HeaderTextProcessing extends ProcessingObject<String> {
    public String handleWork(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }
}
