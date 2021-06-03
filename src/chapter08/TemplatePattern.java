//: chapter08/TemplatePattern.java

package chapter08;

import com.simple.classes.Customer;
import com.simple.classes.Database;

import java.util.function.Consumer;

public class TemplatePattern {
    public static void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
        Customer cust = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(cust);
    }

    public static void main(String... args) {
        TemplatePattern.processCustomer(1337, (Customer cust) -> System.out.println("Welcome to the TD Bank!"));
    }
}
