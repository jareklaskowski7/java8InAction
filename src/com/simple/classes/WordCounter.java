//: com/simple/classes/WordCounter.java

package com.simple.classes;

public class WordCounter {
    private final int counter;
    private final boolean lastSpace;

    public WordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    public int getCounter() {
        return counter;
    }

    public WordCounter accumulate(Character c) {
        if (Character.isWhitespace(c))
            return lastSpace ? this : new WordCounter(counter, true);
        else
            return lastSpace ? new WordCounter(counter + 1, false) : this;
    }

    public WordCounter combine(WordCounter wordCounter) {
        return new WordCounter(wordCounter.counter + counter, wordCounter.lastSpace);
    }
}
