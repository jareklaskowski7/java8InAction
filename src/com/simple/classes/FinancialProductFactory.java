//: com/simple/classes/FinancialProductFactory.java

package com.simple.classes;

import com.simple.interfaces.FinancialProduct;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class FinancialProductFactory {
    private static final Map<String, Supplier<FinancialProduct>> FINANCIAL_PRODUCTS = new HashMap<>();

    public static Map<String, Supplier<FinancialProduct>> getFinancialProducts() {
        return FINANCIAL_PRODUCTS;
    }

    public static FinancialProduct createFinancialProduct(String financialProdDesc) {
        switch (financialProdDesc) {
            case "loan":
                return new Loan();
            case "stock":
                return new Stock();
            case "bond":
                return new Bond();
            default:
                throw new RuntimeException("No such financial product " + financialProdDesc);
        }
    }

    public static FinancialProduct createFinancialProductLambda(String financialProdDesc) {
        Supplier<FinancialProduct> fp = FINANCIAL_PRODUCTS.get(financialProdDesc);
        if (fp != null)
            return fp.get();
        throw new RuntimeException("No such financial product " + financialProdDesc);
    }
}
