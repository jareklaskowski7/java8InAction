//: com/simple/classes/Bond.java

package com.simple.classes;

import com.simple.interfaces.FinancialProduct;

public class Bond implements FinancialProduct {
    private static int bondNumber;

    public Bond() {
        bondNumber++;
    }

    public String toString() {
        return "Bond #" + bondNumber;
    }
}
