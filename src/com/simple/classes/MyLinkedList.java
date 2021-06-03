//: com/simple/classes/MyLinkedList.java

package com.simple.classes;

import com.simple.interfaces.MyList;

import java.util.function.Predicate;

public class MyLinkedList<T> implements MyList<T> {
    private final T head;
    private final MyList<T> tail;

    public MyLinkedList(T head, MyList<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    public T head() {
        return head;
    }

    public MyList<T> tail() {
        return tail;
    }

    public MyList<T> filter(Predicate<T> p) {
        return isEmpty() ? this : p.test(head()) ? new MyLinkedList<>(head(), tail().filter(p)) : tail().filter(p);
    }

    public boolean isEmpty() {
        return false;
    }
}
