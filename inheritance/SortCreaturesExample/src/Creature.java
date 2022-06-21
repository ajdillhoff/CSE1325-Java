import java.util.Objects;

public class Creature {
    private String name = "Unknown";
    private int level = 1;
    private int xp = 0;
    private int hp = 1;
    private int ac = 1;
    private int str = 0;
    private int dex = 0;
    private int con = 0;

    public Creature() {}

    public Creature(String name) {
        this.name = name;
    }

    /* Getters and Setters */
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getDex() {
        return dex;
    }
}
