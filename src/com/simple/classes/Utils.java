//: com/simple/classes/Utils.java

package com.simple.classes;

import com.simple.interfaces.Resizable;

import java.util.List;

public class Utils {
    public static void paint(List<Resizable> l) {
        l.forEach(r -> r.setAbsoluteSize(42, 42));

        l.forEach(r -> r.setRelativeSize(2, 2));
    }
}
