//: com/simple/classes/ParallelStreams.java

package com.simple.classes;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreams {
    public static long iterativeSum(long n) {
        long sum = 0;
        for (long number = 0; number <= n; number++)
            sum += number;
        return sum;
    }

    public static long sequentialSum(long n) {
        return Stream.iterate(1L, number -> number + 1)
                .limit(n)
                .reduce(Long::sum)
                .get();
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, number -> number + 1)
                .limit(n)
                .parallel()
                .reduce(Long::sum)
                .get();
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(Long::sum)
                .getAsLong();
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(Long::sum)
                .getAsLong();
    }

    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n)
                .forEach(accumulator::add);
        return accumulator.getTotal();
    }

    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n)
                .parallel()
                .forEach(accumulator::add);
        return accumulator.getTotal();
    }
}
