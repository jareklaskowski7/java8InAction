//: com/simple/classes/OptionalMain.java

package com.simple.classes;

import java.util.Optional;

public class OptionalMain {
    public String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }
}
