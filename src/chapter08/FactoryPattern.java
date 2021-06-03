//: chapter08/FactoryPattern.java

package chapter08;

import com.simple.classes.Bond;
import com.simple.classes.FinancialProductFactory;
import com.simple.classes.Loan;
import com.simple.classes.Stock;
import com.simple.interfaces.FinancialProduct;

import java.util.function.Supplier;

import static com.simple.classes.FinancialProductFactory.getFinancialProducts;

public class FactoryPattern {
    static {
        getFinancialProducts().put("loan", Loan::new);
        getFinancialProducts().put("stock", Stock::new);
        getFinancialProducts().put("bond", Bond::new);
    }

    public static void main(String... args) {
        FinancialProduct fp1 = FinancialProductFactory.createFinancialProduct("loan");
        System.out.println(fp1);

        Supplier<FinancialProduct> loanSupplier = Loan::new;
        FinancialProduct fp2 = loanSupplier.get();
        System.out.println(fp2);

        FinancialProduct fp3 = FinancialProductFactory.createFinancialProductLambda("loan");
        System.out.println(fp3);
    }
}
