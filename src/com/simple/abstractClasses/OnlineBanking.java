//: com/simple/abstractClasses/OnlineBanking.java

package com.simple.abstractClasses;

import com.simple.classes.Customer;
import com.simple.classes.Database;

public abstract class OnlineBanking {
    abstract void makeCustomerHappy(Customer cust);

    public void processCustomer(int id) {
        Customer cust = Database.getCustomerWithId(id);
        makeCustomerHappy(cust);
    }
}
