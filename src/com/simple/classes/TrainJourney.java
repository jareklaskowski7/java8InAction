//: com/simple/classes/TrainJourney.java

package com.simple.classes;

public class TrainJourney {
    private int price;
    private TrainJourney onward;

    public TrainJourney(int price, TrainJourney onward) {
        this.price = price;
        this.onward = onward;
    }

    public int getPrice() {
        return price;
    }

    public TrainJourney getOnward() {
        return onward;
    }

    public void setOnward(TrainJourney onward) {
        this.onward = onward;
    }
}
