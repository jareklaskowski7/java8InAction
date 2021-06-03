//: chapter08/ObserverPattern.java

package chapter08;

import com.simple.classes.Feed;
import com.simple.classes.Guardian;
import com.simple.classes.LeMonde;
import com.simple.classes.NYTimes;

public class ObserverPattern {
    public static void main(String... args) {
        System.out.println("Old school:");
        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());
        f.notifyObservers("The queen said her favorite book is Java 8 in Action!");

        System.out.println("\nWith lambdas:");
        Feed feedLambda = new Feed();
        feedLambda.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("money"))
                System.out.println("Breaking news in NY! " + tweet);
        });
        feedLambda.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("queen"))
                System.out.println("Yet another news in London... " + tweet);
        });
        feedLambda.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("wine"))
                System.out.println("Today cheese, wine and news! " + tweet);
        });
        feedLambda.notifyObservers("Money money money, give me money!");
        feedLambda.notifyObservers("Let's drink some wine!");
    }
}
