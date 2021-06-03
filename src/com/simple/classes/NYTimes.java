//: com/simple/classes/NYTimes.java

package com.simple.classes;

import com.simple.interfaces.Observer;

public class NYTimes implements Observer {
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("money"))
            System.out.println("Breaking news in NY! " + tweet);
    }
}
