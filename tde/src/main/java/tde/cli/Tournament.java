package tde.cli;

import java.util.ArrayList;

/*
 * Class that will hold the tournament, and the branches. It's function will be to do rounds of matches
 * 
 */

public class Tournament {
    private ArrayList<Player> initialPlayers;

    public Tournament(ArrayList<Player> _players) {
        initialPlayers = _players;
    }

    /**
     * Method to run the tournament
     */
    public void round() {
        // Starting branch
        Branch round = new Branch(initialPlayers);

        // while there are players in the branch, keep going
        while (round.getPlayers().size() > 1) {
            round.resolve_branch();
            round.new_round();
        }
    }
}
