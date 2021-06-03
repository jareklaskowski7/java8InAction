//: com/simple/classes/Transaction.java

package com.simple.classes;

import java.util.Arrays;
import java.util.List;

public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;
    private static final List<Transaction> TRANSACTIONS = Arrays.asList(
            new Transaction(Trader.BRIAN, 2011, 300),
            new Transaction(Trader.RAOUL, 2012, 1000),
            new Transaction(Trader.RAOUL, 2011, 400),
            new Transaction(Trader.MARIO, 2012, 710),
            new Transaction(Trader.MARIO, 2012, 700),
            new Transaction(Trader.ALAN, 2012, 950)
    );

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    public static List<Transaction> getTRANSACTIONS() {
        return TRANSACTIONS;
    }

    public String toString() {
        return "Transaction{" + trader + ", year=" + year + ", value=" + value + "}";
    }
}
