//: chapter09/Monster.java

package chapter09;

import com.simple.interfaces.Moveable;
import com.simple.interfaces.Resizable;
import com.simple.interfaces.Rotatable;

public class Monster implements Moveable, Resizable, Rotatable {
    private int x;
    private int y;
    private int rotationAngle;
    private int width;
    private int height;

    public int getX() {
        return x;
    }

    public void setX(int x) {}

    public int getY() {
        return y;
    }

    public void setY(int y) {}

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {}

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {}

    public int getRotationAngle() {
        return rotationAngle;
    }

    public void setRotationAngle(int angleInDegrees) {}

    public void setAbsoluteSize(int width, int height) {}

    public void draw() {}

    public static void main(String... args) {
        Monster m = new Monster();
        m.rotateBy(180);
        m.moveVertically(10);
    }
}
