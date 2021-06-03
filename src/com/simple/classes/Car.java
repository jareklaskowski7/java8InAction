//: com/simple/classes/Car.java

package com.simple.classes;

import java.util.Optional;

public class Car {
    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}
