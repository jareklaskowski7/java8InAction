//: chapter06/PrimesCollectorHarness.java

package chapter06;

import java.util.function.Consumer;

public class PrimesCollectorHarness {
    private static long execute(Consumer<Integer> primePartitioner) {
        long totalTime = 0L;
        for (int idx = 0; idx < 10; idx++) {
            long start = System.nanoTime();
            primePartitioner.accept(1000000);
            long durationTime = (System.nanoTime() - start) / 1000000;
            totalTime += durationTime;
        }
        return totalTime;
    }

    public static void main(String... args) {
        System.out.println("Partitioning primes done in: " + execute(PartitionPrimeNumbers::partitionPrimes) + " msecs");
        System.out.println("Partitioning primes with custom collector done in: " + execute(PartitionPrimeNumbers::partitionPrimesWithCustomCollector) + " msecs");
        System.out.println("Partitioning primes with inline collector done in: " + execute(PartitionPrimeNumbers::partitionPrimesWithInlineCollector) + " msecs");
    }
}
