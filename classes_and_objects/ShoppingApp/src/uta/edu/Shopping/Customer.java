package uta.edu.Shopping;

import java.util.Date;

public class Customer {
    private int id;
    private String name;
    private Address address;
    private String email;
    private Date joinDate;
    private Account account;

    public Customer(int i, String n, Address a, String e) {
        id = i;
        name = n;
        address = a;
        email = e;
        joinDate = new Date();
        account = new Account(a);
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
