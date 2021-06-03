//: chapter02/MeaningOfThis.java

package chapter02;

public class MeaningOfThis {
    private final int value = 4;

    public static void main(String... args) {
        MeaningOfThis m = new MeaningOfThis();
        m.doIt(); // ???
    }

    private void doIt() {
        int value = 6;
        Runnable r = new Runnable() {
            private final int value = 5;

            public void run() {
                int value = 10;
                System.out.println(this.value);
            }
        };
        r.run();
    }
}
