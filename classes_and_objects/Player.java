import java.util.Objects;

/**
 * Represents a player in an RPG.
 * @version 1.0 2021-06-11
 * @author Alex Dillhoff
 */
public class Player {
    /* Instance Fields */
    private String name = ""; // Creates an empty string BEFORE the constructor is called.
    private int hp;
    private int level;
    private int xp;

    /* Constructors */
    public Player(String n) {
        // If `n` is null, it will throw an exception here.
        // This will be easier to trace in the future.
        Objects.requireNonNull(n);
        name = n;

        // If `n` is null, `name` will be initialized with "NoName"
//        name = Objects.requireNonNullElse(n, "NoName");

        hp = 10;
        level = 1;
        xp = 0;
    }

    public Player(String n, int h, int l, int x) {
        this(n); // Calls the constructor above
        hp = Math.max(h, 0);
        level = Math.max(l, 1);
        xp = Math.max(x, 0);
    }

    /* Accessors and Mutators */
    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getLevel() {
        return level;
    }

    public int getXp() {
        return xp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    /* Overrides */
    @Override
    public String toString() {
        return String.format("%s, level %d (%d xp) with %d HP", name, level, xp, hp);
    }

    /* Class Methods */
    public void takeDamage(int damage) {
        hp = Math.max(hp - damage, 0);

        System.out.printf("%s took %d points of damage and now has %d HP.\n", name, damage, hp);
    }

    public void attack(Player target, int damage) {
        // Because the input is an object of the Player class, we can access private instance fields.
//        target.hp -= damage;
        System.out.printf("%s attacked %s for %d points of damage.\n", name, target.name, damage);

        // However, we should still utilize a method, if available.
        target.takeDamage(damage);
    }
}
