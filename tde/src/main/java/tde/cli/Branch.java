package tde.cli;

import java.util.ArrayList;

/*
 * List of players
 */

public class Branch {
    private ArrayList players = new ArrayList<Player>();

    public Branch(ArrayList<Player> _players) {
        players = _players;
    }

    /* Class methods */

    public ArrayList<Player> generate_winners(ArrayList<Player> playersList){
        return playersList;
    }
}
