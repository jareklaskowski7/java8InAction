//: chapter06/GroupTransactions.java

package chapter06;

import com.simple.classes.Transaction2;
import com.simple.enums.Currency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class GroupTransactions {
    private static void groupTransactionsImperatively() {
        Map<Currency, List<Transaction2>> transactionsByCurrencies = new HashMap<>();
        for (Transaction2 transaction : Transaction2.getTransactions2()) {
            Currency currency = transaction.getCurrency();
            List<Transaction2> transactionsForCurrency = transactionsByCurrencies.get(currency);
            if (transactionsForCurrency == null) {
                transactionsForCurrency = new ArrayList<>();
                transactionsByCurrencies.put(currency, transactionsForCurrency);
            }
            transactionsForCurrency.add(transaction);
        }
        System.out.println(transactionsByCurrencies);
    }

    private static void groupTransactionsFunctionally() {
        Map<Currency, List<Transaction2>> transactionsByCurrencies = Transaction2.getTransactions2().stream().collect(
                groupingBy(Transaction2::getCurrency));
        System.out.println(transactionsByCurrencies);
    }

    public static void main(String... args) {
        System.out.println("Group transactions imperatively:");
        groupTransactionsImperatively();
        System.out.println("Group transactions functionally:");
        groupTransactionsFunctionally();
    }
}
