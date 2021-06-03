//: chapter05/Practice108.java

package chapter05;

import com.simple.classes.Trader;
import com.simple.classes.Transaction;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class Practice108 {
    public static void main(String... args) {
        // 1
        List<Transaction> transactions2011 =
                Transaction.getTRANSACTIONS().stream()
                        .filter(transaction -> transaction.getYear() == 2011)
                        .sorted(comparing(Transaction::getValue))
                        .collect(toList());
        System.out.println(transactions2011);

        // 2
        Set<String> citiesTraders =
                Transaction.getTRANSACTIONS().stream()
                        .map(transaction -> transaction.getTrader().getCity())
                        .collect(toSet());
        System.out.println(citiesTraders);

        // 3
        List<Trader> tradersOfCambridge =
                Transaction.getTRANSACTIONS().stream()
                        .map(Transaction::getTrader)
                        .filter(trader -> trader.getCity().equals("Cambridge"))
                        .distinct()
                        .sorted(comparing(Trader::getName))
                        .collect(toList());
        System.out.println(tradersOfCambridge);

        // 4
        Transaction.getTRANSACTIONS().stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted(String::compareTo)
                .forEach(System.out::println);

        // 5
        boolean tradersOfMilan = Transaction.getTRANSACTIONS().stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(tradersOfMilan);

        // 6
        Transaction.getTRANSACTIONS().stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        // 7
        Optional<Integer> transactionsHighestValue = Transaction.getTRANSACTIONS().stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(transactionsHighestValue);

        // 8
        Optional<Transaction> transactionsLowestValue = Transaction.getTRANSACTIONS().stream()
                .min(comparing(Transaction::getValue));
        System.out.println(transactionsLowestValue);
    }
}
