package SortPlayerExample;

import java.util.Arrays;

public class SortPlayerExample {
    public static void main(String[] args) {
        Player[] players = {
                new Player("Taryon Darrington"),
                new Player("Keyleth"),
                new Player("Percival Fredrickstein von Musel Klossowski de Rolo III"),
                new Player("Grog Strongjaw"),
                new Player("Pike Trickfoot"),
                new Player("Scanlan Shorthalt"),
                new Player("Vax'ildan"),
                new Player("Vex'ahlia"),
        };

        Arrays.sort(players);

        for (var p : players) {
            System.out.println(p.getName());
        }
    }
}
