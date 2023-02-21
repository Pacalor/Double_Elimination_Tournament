package tde.cli;

import java.util.ArrayList;

/*
 * Class that will hold the tournament, and the branches. 
 * Its function will be to do rounds of matches
 */

public class Tournament {
    private ArrayList<Branch> branches;

    public Tournament(ArrayList<Branch> _branches) {
        branches = _branches;
    }

    /**
     * 
     */
    public void run(){
        // CLI needed
        CLI cli = new CLI();

        // Initialization
        Initialization init = new Initialization(cli);
        ArrayList<Player> players = (ArrayList) init.start(0, 0);

        // once we have the players, we can start the tournament
        // by resolving a branch
        Branch branch = new Branch(players);
        branches.add(branch);

// for each branch, resolve and start new round
for (Branch branx : branches) {

    
}

        branch.resolve_branch();
        branch.new_round();

    }
}
