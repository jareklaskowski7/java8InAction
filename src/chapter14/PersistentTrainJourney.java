//: chapter14/PersistentTrainJourney.java

package chapter14;

import com.simple.classes.TrainJourney;

import java.util.function.Consumer;

public class PersistentTrainJourney {
    public static TrainJourney link(TrainJourney a, TrainJourney b) {
        if (a == null)
            return b;
        TrainJourney t = a;
        while (t.getOnward() != null)
            t = t.getOnward();
        t.setOnward(b);
        return a;
    }

    public static TrainJourney append(TrainJourney a, TrainJourney b) {
        return a == null ? b : new TrainJourney(a.getPrice(), append(a.getOnward(), b));
    }

    public static void visit(TrainJourney journey, Consumer<TrainJourney> c) {
        if (journey != null) {
            c.accept(journey);
            visit(journey.getOnward(), c);
        }
    }

    public static void main(String... args) {
        TrainJourney tj1 = new TrainJourney(40, new TrainJourney(30, null));
        TrainJourney tj2 = new TrainJourney(20, new TrainJourney(50, null));

        TrainJourney appended = append(tj1, tj2);
        visit(appended, tj -> { System.out.print(tj.getPrice() + " - "); });
        System.out.println();

        // A new TrainJourney is created without altering tj1 and tj2.
        TrainJourney appended2 = append(tj1, tj2);
        visit(appended2, tj -> { System.out.print(tj.getPrice() + " - "); });
        System.out.println();

        // tj1 is altered but it's still not visible in the results.
        TrainJourney linked = link(tj1, tj2);
        visit(linked, tj -> { System.out.print(tj.getPrice() + " - "); });
        System.out.println();

        // ... but here, if this code is uncommented, tj2 will be appended
        // at the end of the already altered tj1. This will cause a
        // StackOverflowError from the endless visit() recursive calls on
        // the tj2 part of the twice altered tj1.
        /*TrainJourney linked2 = link(tj1, tj2);
        visit(linked2, tj -> { System.out.print(tj.price + " - "); });
        System.out.println();*/
    }
}
