//: chapter06/PartitionPrimeNumbers.java

package chapter06;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.IntStream;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import static java.util.stream.Collectors.partitioningBy;

public class PartitionPrimeNumbers {
    private static boolean isPrime(int candidatePrime) {
        //System.out.println("isPrime1()");
        //System.out.println("candidatePrime = " + candidatePrime);
        int candidatePrimeRoot = (int) Math.sqrt(candidatePrime);
        //System.out.println("candidatePrimeRoot = " + candidatePrimeRoot);
        return IntStream.rangeClosed(2, candidatePrimeRoot)
                .noneMatch(number -> candidatePrime % number == 0);
    }

    private static boolean isPrime(List<Integer> primes, Integer candidatePrime) {
        int candidatePrimeRoot = (int) Math.sqrt(candidatePrime);
        return takeWhile(primes, number -> number <= candidatePrimeRoot).stream()
                .noneMatch(number -> candidatePrime % number == 0);
    }

    private static <A> List<A> takeWhile(List<A> primes, Predicate<A> p) {
        for (int idx = 0; idx < primes.size(); idx++)
            if (!p.test(primes.get(idx)))
                return primes.subList(0, idx);
        return primes;
    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n)
                .boxed()
                .collect(partitioningBy(PartitionPrimeNumbers::isPrime));
    }

    public static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n)
                .boxed()
                .collect(new PrimeNumbersCollector());
    }

    public static Map<Boolean, List<Integer>> partitionPrimesWithInlineCollector(int n) {
        return IntStream.rangeClosed(2, n)
                .boxed()
                .collect(
                        () -> new HashMap<Boolean, List<Integer>>() {{
                            put(true, new ArrayList<>());
                            put(false, new ArrayList<>());
                        }},
                        (acc, candidatePrime) -> {
                            acc.get(isPrime(acc.get(true), candidatePrime))
                                    .add(candidatePrime);
                        },
                        (map1, map2) -> {
                            map1.get(true).addAll(map2.get(true));
                            map1.get(false).addAll(map2.get(false));
                        });
    }

    private static class PrimeNumbersCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {
        public Supplier<Map<Boolean, List<Integer>>> supplier() {
            return () -> new HashMap<Boolean, List<Integer>>() {
                {
                    put(true, new ArrayList<>());
                    put(false, new ArrayList<>());
                }
            };
        }

        public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
            return (Map<Boolean, List<Integer>> acc, Integer candidatePrime) -> {
                acc.get(isPrime(acc.get(true), candidatePrime))
                        .add(candidatePrime);
            };
        }

        public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
            return (Map<Boolean, List<Integer>> map1, Map<Boolean, List<Integer>> map2) -> {
                map1.get(true).addAll(map2.get(true));
                map1.get(false).addAll(map2.get(false));
                return map1;
            };
        }

        public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
            return Function.identity();
        }

        public Set<Characteristics> characteristics() {
            return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH));
        }
    }

    public static void main(String... args) {
        System.out.println("Partitioning primes:                       " + partitionPrimes(100));
        System.out.println("Partitioning primes with custom collector: " + partitionPrimesWithCustomCollector(100));
        System.out.println("Partitioning primes with inline collector: " + partitionPrimesWithInlineCollector(100));
    }
}
