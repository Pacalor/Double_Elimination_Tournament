package tde.cli;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

/*
 * List of players
 */

public class Branch {
    private ArrayList<Player> players;
    private ArrayList<Player> winners;
    private ArrayList<Player> losers;
    private CLI ui;
    private Random random;

    /**
     * @param _players
     * @param cli
     */
    public Branch(ArrayList<Player> _players, CLI cli) {
        players = _players;
        winners = new ArrayList<>();
        losers = new ArrayList<>();
        ui = cli;
        random = new Random(LocalTime.now().getNano());
    }

    /**
     * This method will pair the players on a branch
     * and return the losers
     * 
     * @return losers
     */
    public ArrayList<Player> resolve_branch() {
        // Instantiate BinaryTournament class
        BinaryTournament bitour = new BinaryTournament(ui, 0);

        // run matches
        while (players.size() > 1) {
            // pick random users
            int player1, player2;

            do {
                player1 = random.nextInt(players.size());
                player2 = random.nextInt(players.size());
            } while (player1 == player2);

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
        }
        return new ArrayList<>(losers);
    }

    /**
     * Start a new round by storing the winners in players
     * and clearing winners and losers
     */
    public void new_round() {

        players.addAll(new ArrayList<Player>(winners));

        winners.clear();
        losers.clear();
    }

    /**
     * @return players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param pToAdd
     */
    public void addPlayers(ArrayList<Player> pToAdd) {

        for (Player player : pToAdd) {
            players.add(player);
        }
    }
}
