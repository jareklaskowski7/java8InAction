//: com/simple/classes/Empty.java

package com.simple.classes;

import com.simple.interfaces.MyList;

import java.util.function.Predicate;

public class Empty<T> implements MyList<T> {
    public T head() {
        throw new UnsupportedOperationException();
    }

    public MyList<T> tail() {
        throw new UnsupportedOperationException();
    }

    public MyList<T> filter(Predicate<T> p) {
        return this;
    }
}
