//: chapter11/BestPriceFinderMain.java

package chapter11;

import com.simple.classes.BestPriceFinder;

import java.util.List;
import java.util.function.Supplier;

public class BestPriceFinderMain {
    private static final BestPriceFinder BEST_PRICE_FINDER = new BestPriceFinder();

    private static void execute(String msg, Supplier<List<String>> s) {
        long start = System.nanoTime();
        System.out.println(s.get());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println(msg + " done in " + duration + " msecs");
    }

    public static void main(String... args) {
        execute("sequential", () -> BEST_PRICE_FINDER.findPricesSequential("myPhone27S"));
        execute("parallel", () -> BEST_PRICE_FINDER.findPricesParallel("myPhone27S"));
        execute("composed CompletableFuture", () -> BEST_PRICE_FINDER.findPricesFuture("myPhone27S"));
        BEST_PRICE_FINDER.printPricesStream("myPhone27S");
    }
}
