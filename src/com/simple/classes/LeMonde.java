//: com/simple/classes/LeMonde.java

package com.simple.classes;

import com.simple.interfaces.Observer;

public class LeMonde implements Observer {
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("wine"))
            System.out.println("Today cheese, wine and news! " + tweet);
    }
}
