package SortPlayerExample;

public class Player implements Comparable {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        Player p = (Player) o;
        return name.compareTo(p.getName());
    }
}
