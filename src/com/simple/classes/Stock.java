//: com/simple/classes/Stock.java

package com.simple.classes;

import com.simple.interfaces.FinancialProduct;

public class Stock implements FinancialProduct {
    private static int stockNumber;

    public Stock() {
        stockNumber++;
    }

    public String toString() {
        return "Stock #" + stockNumber;
    }
}
