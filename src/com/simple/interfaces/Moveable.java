//: com/simple/interfaces/Moveable.java

package com.simple.interfaces;

public interface Moveable {
    int getX();

    void setX(int x);

    int getY();

    void setY(int y);

    default void moveHorizontally(int distance) {
        setX(getX() + distance);
    }

    default void moveVertically(int distance) {
        setY(getY() + distance);
    }
}
