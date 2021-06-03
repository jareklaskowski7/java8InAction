//: chapter08/StrategyPattern.java

package chapter08;

import com.simple.classes.IsAllLowerCase;
import com.simple.classes.IsNumeric;
import com.simple.classes.ValidatorStrategy;

public class StrategyPattern {
    public static void main(String... args) {
        System.out.println("Old school:");
        ValidatorStrategy v1 = new ValidatorStrategy(new IsNumeric());
        System.out.println(v1.validateStrategy("aaaa"));
        ValidatorStrategy v2 = new ValidatorStrategy(new IsAllLowerCase());
        System.out.println(v2.validateStrategy("bbbb"));

        System.out.println("\nWith lambdas:");
        ValidatorStrategy v3 = new ValidatorStrategy((String str) -> str.matches("\\d+"));
        System.out.println(v3.validateStrategy("aaaa"));
        ValidatorStrategy v4 = new ValidatorStrategy((String str) -> str.matches("[a-z]+"));
        System.out.println(v4.validateStrategy("bbbb"));
    }
}
