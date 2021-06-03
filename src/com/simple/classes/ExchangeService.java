//: com/simple/classes/ExchangeService.java

package com.simple.classes;

import com.simple.enums.Money;

import static com.simple.classes.Util.delay;

public class ExchangeService {
    public static double getRate(Money source, Money destination) {
        return getRateWithDelay(source, destination);
    }

    private static double getRateWithDelay(Money source, Money destination) {
        delay();
        return destination.getRate() / source.getRate();
    }
}
