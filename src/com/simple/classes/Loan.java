//: com/simple/classes/Loan.java

package com.simple.classes;

import com.simple.interfaces.FinancialProduct;

public class Loan implements FinancialProduct {
    private static int loanNumber;

    public Loan() {
        loanNumber++;
    }

    public String toString() {
        return "Loan #" + loanNumber;
    }
}
