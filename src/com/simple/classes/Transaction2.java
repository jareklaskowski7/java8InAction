//: com/simple/classes/Transaction2.java

package com.simple.classes;

import com.simple.enums.Currency;

import java.util.Arrays;
import java.util.List;

public class Transaction2 {
    private final Currency currency;
    private final int value;
    private static final List<Transaction2> TRANSACTIONS_2 = Arrays.asList(
            new Transaction2(Currency.EUR, 1500),
            new Transaction2(Currency.USD, 2300),
            new Transaction2(Currency.GBP, 9900),
            new Transaction2(Currency.EUR, 1100),
            new Transaction2(Currency.JPY, 7800),
            new Transaction2(Currency.CHF, 6700),
            new Transaction2(Currency.EUR, 5600),
            new Transaction2(Currency.USD, 4500),
            new Transaction2(Currency.CHF, 3400),
            new Transaction2(Currency.GBP, 3200),
            new Transaction2(Currency.USD, 4600),
            new Transaction2(Currency.JPY, 5700),
            new Transaction2(Currency.EUR, 6800));

    public Transaction2(Currency currency, int value) {
        this.currency = currency;
        this.value = value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public static List<Transaction2> getTransactions2() {
        return TRANSACTIONS_2;
    }

    public String toString() {
        return currency + " " + value;
    }
}
