//: com/simple/classes/Feed.java

package com.simple.classes;

import com.simple.interfaces.Observer;
import com.simple.interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

public class Feed implements Subject {
    private final List<Observer> observers = new ArrayList<>();

    public void notifyObservers(String tweet) {
        observers.forEach(observer -> observer.notify(tweet));
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
}
