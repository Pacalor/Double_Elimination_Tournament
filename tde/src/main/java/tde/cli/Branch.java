package tde.cli;

import java.util.ArrayList;
import java.util.Random;

/*
 * List of players
 */

public class Branch {
    private ArrayList<Player> players;
    private ArrayList<Player> winners;
    private ArrayList<Player> losers;

    public Branch(ArrayList<Player> _players) {
        players = _players;
        winners = new ArrayList<>();
        losers = new ArrayList<>();
    }

    /**
     * This method will pair the players on a branch
     * and return the losers
     */
    public ArrayList<Player> resolve_branch() {
        // Instantiate BinaryTournament class
        BinaryTournament bitour = new BinaryTournament(null, 0);

        // run matches
        // TODO: missing odd players situation
        while (players.size() > 1) {
            // pick random users
            int player1, player2;
            Random random = new Random();
            do {
                player1 = random.nextInt(players.size() - 1);
                player2 = random.nextInt(players.size() - 1);
            } while (player1 != player2);

            // Add the player to its correspondent list
            if (bitour.run(players.get(player1), players.get(player2))) {
                winners.add(players.get(player1));
                losers.add(players.get(player2));
            } else {
                winners.add(players.get(player2));
                losers.add(players.get(player1));
            }

            // needed because the index will be different once player1 is removed
            Player toDelete = players.get(player2);

            // remove players from general list
            players.remove(players.get(player1));
            players.remove(toDelete);

            // TODO: David dice que players estará vacío, por no se qué de memoria xD

        }
        return losers;
    }

    public void new_round() {

        players = new ArrayList<Player>(winners);

        winners.clear();
        losers.clear();
    }
}
