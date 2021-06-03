//: chapter09/Diamond.java

package chapter09;

public class Diamond {
    private interface A {
        default void identify() {
            System.out.println("identify() in interface A");
        }
    }

    private interface B extends A {}

    private interface C extends A {}

    private static class D implements B, C {}

    public static void main(String... args) {
        new D().identify();
    }
}
