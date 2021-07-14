package MethodCallExample;

public class Account extends User {

    public Account(int id) {
        super(id);
    }

    public void update() {
        System.out.println("Updating account.");
    }
}
