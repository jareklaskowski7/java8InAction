//: com/simple/interfaces/TriFunction.java

package com.simple.interfaces;

public interface TriFunction<S, T, U, R> {
    R apply(S s, T t, U u);
}
