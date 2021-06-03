//: chapter07/DifferentStreamsHarness.java

package chapter07;

import com.simple.classes.ForkJoinSumCalculator;
import com.simple.classes.ParallelStreams;

import java.util.function.Function;

public class DifferentStreamsHarness {
    public static <T, R> long measurePerf(Function<T, R> f, T input) {
        long totalTime = 0L;
        long start = System.nanoTime();
        R result = f.apply(input);
        System.out.println("Result: " + result);
        long durationTime = (System.nanoTime() - start) / 1_000_000;
        totalTime += durationTime;
        return totalTime;
    }

    public static void main(String... args) {
        System.out.println("Number of threads/processors: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Iterative sum done in: " + measurePerf(ParallelStreams::iterativeSum, 10_000_000L) + " msecs");
        System.out.println("Sequential sum done in: " + measurePerf(ParallelStreams::sequentialSum, 10_000_000L) + " msecs");
        System.out.println("Parallel sum done in: " + measurePerf(ParallelStreams::parallelSum, 10_000_000L) + " msecs");
        System.out.println("Ranged sum done in: " + measurePerf(ParallelStreams::rangedSum, 10_000_000L) + " msecs");
        System.out.println("Parallel ranged sum done in: " + measurePerf(ParallelStreams::parallelRangedSum, 10_000_000L) + " msecs");
        System.out.println("ForkJoin sum done in: " + measurePerf(ForkJoinSumCalculator::forkJoinSum, 10_000_000L) + " msecs");
        System.out.println("Side effect sum done in: " + measurePerf(ParallelStreams::sideEffectSum, 10_000_000L) + " msecs");
        System.out.println();
        for (int idx = 0; idx < 10; idx++)
            System.out.println("Side effect parallel sum done in: " + measurePerf(ParallelStreams::sideEffectParallelSum, 10_000_000L) + " msecs");
    }
}
