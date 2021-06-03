//: com/simple/classes/SpellCheckerProcessing.java

package com.simple.classes;

import com.simple.abstractClasses.ProcessingObject;

public class SpellCheckerProcessing extends ProcessingObject<String> {
    public String handleWork(String text) {
        return text.replaceAll("labda", "lambda");
    }
}
