//: com/simple/classes/Discount.java

package com.simple.classes;

import static com.simple.classes.Util.delay;
import static com.simple.classes.Util.format;

public class Discount {
    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    private static double apply(double price, Code code) {
        delay();
        return format(price * (100 - code.percentage) / 100);
    }

    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is " + apply(quote.getPrice(), quote.getDiscountCode());
    }
}
