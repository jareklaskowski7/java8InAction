//: com/simple/interfaces/Resizable.java

package com.simple.interfaces;

public interface Resizable extends Drawable {
    int getWidth();

    void setWidth(int width);

    int getHeight();

    void setHeight(int height);

    void setAbsoluteSize(int width, int height);

    default void setRelativeSize(int widthFactor, int heightFactor) {
        setAbsoluteSize(getWidth() / widthFactor, getHeight() / heightFactor);
    }
}
