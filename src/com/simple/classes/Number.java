//: com/simple/classes/Number.java

package com.simple.classes;

public class Number extends Expr {
    private final int val;

    public Number(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public String toString() {
        return "" + val;
    }
}
