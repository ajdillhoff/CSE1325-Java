import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SortCreaturesExample {
    public static void main(String[] args) {
        Player p1 = new Player("Grog", "Barbarian");
        Monster[] monsters = {
                new Monster("Adult Red Dragon", "Huge dragon"),
                new Monster("Imp", "Fiend"),
                new Monster("Spy", "Humanoid")
        };

        var creatures = new ArrayList<Creature>();
        creatures.add(p1);
        creatures.addAll(Arrays.asList(monsters));

        System.out.println("Before sorting...");
        for (var creature : creatures) {
            System.out.println(creature);
        }

        // Attempt to sort creatures.
        // According to the documentation, this will use the object's "natural ordering."
        // The natural ordering can be implemented using interfaces.
        // We can manually implement it as well.
        var comp = new Comparator<Creature>() {
            @Override
            public int compare(Creature creature, Creature t1) {
                return creature.getName().compareTo(t1.getName());
            }
        };

        creatures.sort(comp);

        System.out.println("After sorting...");
        for (var creature : creatures) {
            System.out.println(creature);
        }
    }
}
