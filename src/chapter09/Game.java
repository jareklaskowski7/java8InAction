//: chapter09/Game.java

package chapter09;

import com.simple.classes.Ellipse;
import com.simple.classes.Square;
import com.simple.classes.Triangle;
import com.simple.classes.Utils;
import com.simple.interfaces.Resizable;

import java.util.Arrays;
import java.util.List;

public class Game {
    public static void main(String... args) {
        List<Resizable> resizableShapes = Arrays.asList(new Square(), new Triangle(), new Ellipse());
        Utils.paint(resizableShapes);
    }
}
