public class Monster extends Creature {
    private int cr = 1;
    private MonsterType type;

    public Monster(String name) {
        super(name);
    }

    public Monster(String name, MonsterType type) {
        super(name);
        this.type = type;
    }

    public int getCr() {
        return cr;
    }

    public void setCr(int cr) {
        this.cr = cr;
    }

    @Override
    public String toString() {
        return getName() + ", " + type.toString() + ", CR = " + cr;
    }
}
