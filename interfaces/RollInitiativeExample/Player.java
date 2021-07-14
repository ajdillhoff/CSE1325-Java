package RollInitiativeExample;

import java.util.Random;

public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public int rollInitiative() {
        Random r = new Random();
        return r.nextInt(20) + 1;
    }

    @Override
    public String toString() {
        return name;
    }
}
