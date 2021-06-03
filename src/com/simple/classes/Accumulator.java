//: com/simple/classes/Accumulator.java

package com.simple.classes;

public class Accumulator {
    private long total = 0;

    public long getTotal() {
        return total;
    }

    public void add(long value) {
        total += value;
    }
}
