//: chapter11/AsyncShopClient.java

package chapter11;

import com.simple.classes.AsyncShop;

import java.util.concurrent.Future;

public class AsyncShopClient {
    public static void main(String... args) {
        AsyncShop asyncShop = new AsyncShop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = asyncShop.getPrice("myPhone");
        long time = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + time + " msecs");
        try {
            System.out.println("Price is " + futurePrice.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        time = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + time + " msecs");
    }
}
