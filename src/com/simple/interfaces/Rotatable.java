//: com/simple/interfaces/Rotatable.java

package com.simple.interfaces;

public interface Rotatable {
    int getRotationAngle();

    void setRotationAngle(int angleInDegrees);

    default void rotateBy(int angleInDegrees) {
        setRotationAngle((getRotationAngle() + angleInDegrees) % 360);
    }
}
