//: com/simple/classes/WordCounterSpliterator.java

package com.simple.classes;

import java.util.Spliterator;
import java.util.function.Consumer;

public class WordCounterSpliterator implements Spliterator<Character> {
    private final String str;
    private int currentChar = 0;

    public WordCounterSpliterator(String str) {
        this.str = str;
    }

    public boolean tryAdvance(Consumer<? super Character> action) {
        action.accept(str.charAt(currentChar++));
        return currentChar < str.length();
    }

    public Spliterator<Character> trySplit() {
        int currentSize = str.length() - currentChar;
        if (currentSize < 10)
            return null;
        for (int splitPos = currentSize / 2 + currentChar; splitPos < str.length(); splitPos++)
            if (Character.isWhitespace(str.charAt(splitPos))) {
                Spliterator<Character> spliterator = new WordCounterSpliterator(str.substring(currentChar, splitPos));
                currentChar = splitPos;
                return spliterator;
            }
        return null;
    }

    public long estimateSize() {
        return str.length() - currentChar;
    }

    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }
}
