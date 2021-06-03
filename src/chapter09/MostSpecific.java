//: chapter09/MostSpecific.java

package chapter09;

public class MostSpecific {
    private interface A {
        default void identify() {
            System.out.println("identify() in interface A");
        }
    }

    private interface B extends A {
        default void identify() {
            System.out.println("identify() in interface B");
        }
    }

    private static class C implements A, B {}

    private static class D implements A {}

    private static class E extends D implements A, B {}

    private static class F implements A, B {
        public void identify() {
            System.out.println("identify() in class F");
        }
    }

    private static class G extends F implements A, B {}

    public static void main(String... args) {
        new C().identify();
        new E().identify();
        new G().identify();
    }
}
