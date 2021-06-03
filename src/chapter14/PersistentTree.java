//: chapter14/PersistentTree.java

package chapter14;

import com.simple.classes.Tree;

public class PersistentTree {
    public static int lookup(String k, int defaultval, Tree t) {
        if (t == null)
            return defaultval;
        if (k.equals(t.getKey()))
            return t.getVal();
        return lookup(k, defaultval, k.compareTo(t.getKey()) < 0 ? t.getLeft() : t.getRight());
    }

    public static Tree update(String k, int newval, Tree t) {
        if (t == null)
            t = new Tree(k, newval, null, null);
        else if (k.equals(t.getKey()))
            t.setVal(newval);
        else if (k.compareTo(t.getKey()) < 0)
            t.setLeft(update(k, newval, t.getLeft()));
        else
            t.setRight(update(k, newval, t.getRight()));
        return t;
    }

    public static Tree fupdate(String k, int newval, Tree t) {
        return (t == null) ?
                new Tree(k, newval, null, null) :
                k.equals(t.getKey()) ?
                        new Tree(k, newval, t.getLeft(), t.getRight()) :
                        k.compareTo(t.getKey()) < 0 ?
                                new Tree(t.getKey(), t.getVal(), fupdate(k, newval, t.getLeft()), t.getRight()) :
                                new Tree(t.getKey(), t.getVal(), t.getLeft(), fupdate(k, newval, t.getRight()));
    }

    public static void main(String... args) {
        Tree t = new Tree("Mary", 22,
                new Tree("Emily", 20,
                        new Tree("Alan", 50, null, null),
                        new Tree("Georgie", 23, null, null)
                ),
                new Tree("Tian", 29,
                        new Tree("Raoul", 23, null, null),
                        null
                )
        );

        // found = 23
        System.out.println(lookup("Raoul", -1, t));
        // not found = -1
        System.out.println(lookup("Jeff", -1, t));

        Tree f = fupdate("Jeff", 80, t);
        // found = 80
        System.out.println(lookup("Jeff", -1, f));

        Tree u = update("Jim", 40, t);
        // t was not altered by fupdate, so Jeff is not found = -1
        System.out.println(lookup("Jeff", -1, u));
        // found = 40
        System.out.println(lookup("Jim", -1, u));

        Tree f2 = fupdate("Jeff", 80, t);
        // found = 80
        System.out.println(lookup("Jeff", -1, f2));
        // f2 built from t altered by update() above, so Jim is still present = 40
        System.out.println(lookup("Jim", -1, f2));
    }
}
