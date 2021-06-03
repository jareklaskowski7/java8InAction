//: chapter07/WordCount.java

package chapter07;

import com.simple.classes.WordCounter;
import com.simple.classes.WordCounterSpliterator;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class WordCount {
    private static final String SENTENCE = "Nel  mezzo del cammin di nostra vita mi    ritrovai in una     selva oscura che la dritta     via era smarrita";

    public static int countWordsIteratively(String s) {
        int counter = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if (lastSpace)
                    counter++;
                lastSpace = Character.isWhitespace(c);
            }
        }
        return counter;
    }

    public static int countWordsDeclaratively(String s) {
        //Stream<Character> stream = IntStream.range(0, s.length())
        //.mapToObj(SENTENCE::charAt);
        Spliterator<Character> spliterator = new WordCounterSpliterator(s);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);
        return countWordsDeclaratively(stream);
    }

    public static int countWordsDeclaratively(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(
                new WordCounter(0, true),
                WordCounter::accumulate,
                WordCounter::combine);
        return wordCounter.getCounter();
    }

    public static void main(String... args) {
        System.out.println("Found " + countWordsIteratively(SENTENCE) + " words");
        System.out.println("Found " + countWordsDeclaratively(SENTENCE) + " words");
    }
}
