//: com/simple/classes/ToListCollector.java

package com.simple.classes;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {
    public BiConsumer<List<T>, T> accumulator() {
        return List::add;
    }

    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(
                EnumSet.of(IDENTITY_FINISH, CONCURRENT));
    }

    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
    }

    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }
}
