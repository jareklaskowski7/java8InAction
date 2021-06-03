//: chapter14/PatternMatching.java

package chapter14;

import com.simple.classes.BinOp;
import com.simple.classes.Expr;
import com.simple.classes.Number;
import com.simple.interfaces.TriFunction;

import java.util.function.Function;
import java.util.function.Supplier;

public class PatternMatching {
    public static void simplify() {
        TriFunction<String, Expr, Expr, Expr> binopcase =
                (opname, left, right) -> {
                    if ("+".equals(opname)) {
                        if (left instanceof Number && ((Number) left).getVal() == 0)
                            return right;
                        if (right instanceof Number && ((Number) right).getVal() == 0)
                            return left;
                    }
                    if ("*".equals(opname)) {
                        if (left instanceof Number && ((Number) left).getVal() == 1)
                            return right;
                        if (right instanceof Number && ((Number) right).getVal() == 1)
                            return left;
                    }
                    return new BinOp(opname, left, right);
                };
        Function<Integer, Expr> numcase = val -> new Number(val);
        Supplier<Expr> defaultcase = () -> new Number(0);

        Expr e = new BinOp("+", new Number(5), new Number(0));
        Expr match = patternMatchExpr(e, binopcase, numcase, defaultcase);
        if (match instanceof Number)
            System.out.println("Number: " + match);
        else if (match instanceof BinOp)
            System.out.println("BinOp: " + match);
    }

    public static Integer evaluate(Expr e) {
        Function<Integer, Integer> numcase = val -> val;
        Supplier<Integer> defaultcase = () -> 0;
        TriFunction<String, Expr, Expr, Integer> binopcase =
                (opname, left, right) -> {
                    if ("+".equals(opname)) {
                        if (left instanceof Number && right instanceof Number)
                            return ((Number) left).getVal() + ((Number) right).getVal();
                        if (right instanceof Number && left instanceof BinOp)
                            return ((Number) right).getVal() + evaluate((BinOp) left);
                        if (left instanceof Number && right instanceof BinOp)
                            return ((Number) left).getVal() + evaluate((BinOp) right);
                        if (left instanceof BinOp && right instanceof BinOp)
                            return evaluate((BinOp) left) + evaluate((BinOp) right);
                    }
                    if ("*".equals(opname)) {
                        if (left instanceof Number && right instanceof Number)
                            return ((Number) left).getVal() * ((Number) right).getVal();
                        if (right instanceof Number && left instanceof BinOp)
                            return ((Number) right).getVal() * evaluate((BinOp) left);
                        if (left instanceof Number && right instanceof BinOp)
                            return ((Number) left).getVal() * evaluate((BinOp) right);
                        if (left instanceof BinOp && right instanceof BinOp)
                            return evaluate((BinOp) left) * evaluate((BinOp) right);
                    }
                    return defaultcase.get();
                };
        return patternMatchExpr(e, binopcase, numcase, defaultcase);
    }

    public static <T> T MyIf(boolean b, Supplier<T> truecase, Supplier<T> falsecase) {
        return b ? truecase.get() : falsecase.get();
    }

    public static <T> T patternMatchExpr(Expr e,
                                         TriFunction<String, Expr, Expr, T> binopcase,
                                         Function<Integer, T> numcase, Supplier<T> defaultcase) {
        if (e instanceof BinOp)
            return binopcase.apply(((BinOp) e).getOpname(), ((BinOp) e).getLeft(), ((BinOp) e).getRight());
        else if (e instanceof Number)
            return numcase.apply(((Number) e).getVal());
        else
            return defaultcase.get();
    }

    public static void main(String... args) {
        simplify();
        Expr e = new BinOp("+", new Number(5), new BinOp("*", new Number(3), new Number(4)));
        Integer result = evaluate(e);
        System.out.println(e + " = " + result);
    }
}
