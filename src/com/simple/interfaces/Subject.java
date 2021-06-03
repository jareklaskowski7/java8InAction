//: com/simple/interfaces/Subject.java

package com.simple.interfaces;

public interface Subject {
    void notifyObservers(String tweet);

    void registerObserver(Observer observer);
}
