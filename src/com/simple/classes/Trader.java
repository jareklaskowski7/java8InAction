//: com/simple/classes/Trader.java

package com.simple.classes;

public class Trader {
    static final Trader RAOUL = new Trader("Raoul", "Cambridge");
    static final Trader MARIO = new Trader("Mario", "Milan");
    static final Trader ALAN = new Trader("Alan", "Cambridge");
    static final Trader BRIAN = new Trader("Brian", "Cambridge");
    private final String name;
    private final String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String toString() {
        return "Trader " + name + " in " + city;
    }
}
