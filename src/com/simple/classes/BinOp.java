//: com/simple/classes/BinOp.java

package com.simple.classes;

public class BinOp extends Expr {
    private final String opname;
    private final Expr left, right;

    public BinOp(String opname, Expr left, Expr right) {
        this.opname = opname;
        this.left = left;
        this.right = right;
    }

    public String getOpname() {
        return opname;
    }

    public Expr getLeft() {
        return left;
    }

    public Expr getRight() {
        return right;
    }

    public String toString() {
        return "(" + left + " " + opname + " " + right + ")";
    }
}
