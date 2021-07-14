package ShallowCopyExample;

public class Player {
    private String name;
    private int hp;
    private int ac;

    public Player(String name) {
        this.name = name;
        hp = 50;
        ac = 15;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", ac=" + ac +
                '}';
    }
}
