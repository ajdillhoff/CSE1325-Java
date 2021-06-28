import java.util.ArrayList;
import java.util.Arrays;

public class PolymorphismTest {
    public static void main(String[] args) {
        Player p1 = new Player("Grog", PlayerClass.WARRIOR);
        Monster[] monsters = {
                new Monster("Red Dragon", MonsterType.DRAGON),
                new Monster("Imp", MonsterType.FIEND),
                new Monster("Spy", MonsterType.HUMANOID)
        };

        var creatures = new ArrayList<Creature>();
        creatures.add(p1);
        creatures.addAll(Arrays.asList(monsters));

        for (var creature : creatures) {
            System.out.println(creature);
        }
    }
}
