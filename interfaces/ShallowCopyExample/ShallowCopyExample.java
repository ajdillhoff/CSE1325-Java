package ShallowCopyExample;

public class ShallowCopyExample {
    public static void main(String[] args) {
        Player p1 = new Player("Keyleth");
        Player p2 = p1;

        // This will also update `p1` since it refers to the same object.
        p2.setHp(100);

        System.out.println(p1);
        System.out.println(p2);
    }
}
