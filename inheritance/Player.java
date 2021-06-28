import java.util.Formatter;

public class Player extends Creature {
    private PlayerClass playerClass;

    public Player(String name) {
        super(name);
    }

    public Player(String name, PlayerClass playerClass) {
        super(name);
        this.playerClass = playerClass;
    }

    public int getAc() {
        return 15 + getStatModifier(this.getDex());
    }

    public int getStatModifier(int stat) {
        return stat - 5;
    }

    @Override
    public String toString() {
        return String.format("%s, level %d %s.", getName(), getLevel(), playerClass);
    }
}
