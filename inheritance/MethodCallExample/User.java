package MethodCallExample;

import java.util.Date;

public class User {
    private int id;
    private Date modifiedDate;

    public User(int id) {
        this.id = id;
        this.modifiedDate = new Date();
    }

    public void update() {
        System.out.println("Updating user.");
        this.modifiedDate = new Date();
    }
}
