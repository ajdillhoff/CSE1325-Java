package RollInitiativeExample;

import java.util.Arrays;

public class RollInitiativeExample {
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

        InitiativeUtility initUtil = new InitiativeUtility(players);
        Integer[] indices = initUtil.rollInitiative();

        System.out.println("Initiative Order");
        for (int i = 0; i < players.length; i++) {
            System.out.printf("%d. %s\n", i + 1, players[indices[i]]);
        }
    }
}
