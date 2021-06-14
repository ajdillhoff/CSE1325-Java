/**
 * Implementation test of the Player class.
 * @version 1.0 2021-06-11
 * @author Alex Dillhoff
 */
public class PlayerTest {
    public static void main(String[] args) {
        // We do not need to import a package since this class is in the same directory.
        Player p1 = new Player("Grog Strongjaw", 313, 20, 100000);

        // Print the stats of the Player using accessors.
        System.out.printf("%s, level %d (%d xp) with %d HP\n", p1.getName(), p1.getLevel(), p1.getXp(), p1.getHp());

        // Call the takeDamage(int) method
        p1.takeDamage(36);

        // Print the stats using the override of toString()
        System.out.println(p1);

        // Create another player
        Player p2 = new Player("Pike Trickfoot", 145, 20, 100000);

        System.out.println(p2);

        p2.attack(p1, 46);
    }
}
