//: com/simple/classes/Person.java

package com.simple.classes;

import java.util.Optional;

public class Person {
    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }
}
