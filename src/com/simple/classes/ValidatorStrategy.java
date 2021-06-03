//: com/simple/classes/ValidatorStrategy.java

package com.simple.classes;

import com.simple.interfaces.ValidationStrategy;

public class ValidatorStrategy {
    private final ValidationStrategy validationStrategy;

    public ValidatorStrategy(ValidationStrategy validationStrategy) {
        this.validationStrategy = validationStrategy;
    }

    public boolean validateStrategy(String str) {
        return validationStrategy.execute(str);
    }
}
