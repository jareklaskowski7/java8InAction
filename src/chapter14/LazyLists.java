//: chapter14/LazyLists.java

package chapter14;

import com.simple.classes.Empty;
import com.simple.classes.LazyList;
import com.simple.classes.MyLinkedList;
import com.simple.interfaces.MyList;

public class LazyLists {
    public static LazyList<Integer> from(int n) {
        return new LazyList<>(n, () -> from(n + 1));
    }

    public static MyList<Integer> primes(MyList<Integer> numbers) {
        return new LazyList<>(numbers.head(), () -> primes(numbers.tail()
                .filter(n -> n % numbers.head() != 0)));
    }

    public static <T> void printAll(MyList<T> numbers) {
        if (numbers.isEmpty())
            return;
        System.out.println(numbers.head());
        printAll(numbers.tail());
    }

    public static void main(String... args) {
        MyList<Integer> l = new MyLinkedList<>(5, new MyLinkedList<>(10, new Empty<Integer>()));
        System.out.println(l.head());

        LazyList<Integer> numbers = from(2);
        int two = numbers.head();
        int three = numbers.tail().head();
        int four = numbers.tail().tail().head();
        System.out.println(two + " " + three + " " + four);

        numbers = from(2);
        int prime_two = primes(numbers).head();
        int prime_three = primes(numbers).tail().head();
        int prime_five = primes(numbers).tail().tail().head();
        System.out.println(prime_two + " " + prime_three + " " + prime_five);

        // this will run until a stackoverflow occur because Java does not
        // support tail call elimination
        // printAll(primes(from(2)));
    }
}
