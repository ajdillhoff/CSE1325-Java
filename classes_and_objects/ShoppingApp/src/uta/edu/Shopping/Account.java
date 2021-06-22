package uta.edu.Shopping;

import java.util.Date;

/**
 * Represents an account linked to a <code>Customer</code>.
 * @see uta.edu.Shopping.Customer
 */
public class Account {
    private int id;
    private Address billingAddress;
    private Date dateOpened;

    public Account(Address a) {
        id = 0;
        billingAddress = a;
        dateOpened = new Date();
    }
}
