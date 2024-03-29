package tde.cli;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static tde.cli.Constants.*;

/*
 * UI class
 */
public class CLI {
    private Scanner keyboard;

    public CLI() {
        keyboard = new Scanner(System.in);
    }

    public int welcome() {
        System.out.println(WELCOMEMENSAJE);

        // System.out.println("Please introduce how many times you can lose");

        int rounds = 2; // Integer.parseInt(keyboard.nextLine());
        return rounds;
    }

    public int playerNumber() {

        System.out.println("Please introduce the number of players");

        int rounds = Integer.parseInt(keyboard.nextLine());
        return rounds;
    }

    public int initializationType() {
        System.out.println("Please choose an option to insert the players:");
        System.out.println(MENUINITIALIZATION);


        int selected = Integer.parseInt(keyboard.nextLine());
        return selected;
    }

    public boolean askWinner(Player player1, Player player2) {
        System.out.println("Match between " + player1.getName() + " and " + player2.getName() + ". Who wins?");

        String selected = keyboard.nextLine();
        boolean winner = false;

        if (selected.equals(player1.getName())) {
            winner = true;
        }
        System.out.print("Winner is " + (winner ? player1 : player2));
        return winner;
    }

    public ArrayList<Player> getPlayers() {
        System.out.println("Please introduce the amount of players");
        ArrayList<Player> players = new ArrayList<>();

        int numPlayer = Integer.parseInt(keyboard.nextLine());

        for (int i = 0; i < numPlayer; i++) {
            System.out.println("Please introduce the number of a player");
            players.add(new Player(keyboard.nextLine()));
        }

        return players;
    }

}
