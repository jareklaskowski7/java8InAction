//: com/simple/classes/Database.java

package com.simple.classes;

// dummy Database class
public class Database {
    public static Customer getCustomerWithId(int id) {
        return new Customer(id);
    }
}
