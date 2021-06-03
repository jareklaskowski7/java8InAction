//: chapter09/Ambiguous.java

package chapter09;

public class Ambiguous {
    private interface A {
        default void identify() {
            System.out.println("identify() in interface A");
        }
    }

    private interface B {
        default void identify() {
            System.out.println("identify() in interface B");
        }
    }

    private static class C implements A, B {
        public void identify() {
            A.super.identify();
        }
    }

    public static void main(String... args) {
        new C().identify();
    }
}
