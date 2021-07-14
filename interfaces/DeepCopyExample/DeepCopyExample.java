package DeepCopyExample;

public class DeepCopyExample {
    public static void main(String[] args) {
        Player p1 = new Player("Keyleth");

        try {
            Player p2 = p1.clone();
            // This will also update `p1` since it refers to the same object.
            p2.setHp(100);

            System.out.println(p1);
            System.out.println(p2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
