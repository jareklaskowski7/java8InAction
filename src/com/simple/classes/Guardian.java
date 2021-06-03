//: com/simple/classes/Guardian.java

package com.simple.classes;

import com.simple.interfaces.Observer;

public class Guardian implements Observer {
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("queen"))
            System.out.println("Yet another news in London... " + tweet);
    }
}
