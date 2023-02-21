package tde.cli;

import java.util.ArrayList;

import tde.cli.Constants.InitType;

/*
 * Class that will hold the tournament, and the branches. 
 * Its function will be to do rounds of matches
 */

public class Tournament {
    private ArrayList<Branch> branches;
    private int totalLose;
    private int initType;

    public Tournament() {
        branches = new ArrayList<>();
    }

    /**
     * 
     */
    public void run() {
        // CLI needed
        CLI cli = new CLI();
        totalLose = cli.welcome();
        int playerSize = 0;

        // Initialization
        Initialization init = new Initialization(cli);
        initType = cli.initializationType();
        if (initType == InitType.BASIC.getValue())
            playerSize = cli.playerNumber();

        ArrayList<Player> players = (ArrayList) init.start(initType, playerSize);

        // once we have the players, we can start the tournament
        // by resolving a branch
        Branch branch = new Branch(players, cli);

        // store the resulting branch in branches
        branches.add(branch);

        // flags to control programm flow
        boolean thereIsAMatch = true;
        boolean finishTournament = false;

        // auxiliary arraylist
        ArrayList<Player> losers = null;
        String winString = "And the winner is: \n";

        // Inside this loop we are running the tournament itself
        // Each loop cycle represent a branch, meaning that i = 0 will be used for the
        // winners branch
        for (int i = 0; !finishTournament; i++) {

            // when cycle equals the limit of possible losed matches, restart the counter
            // and set flag to false
            if (i == totalLose) {
                i = 0;
                thereIsAMatch = false;
            }

            // get branch from ArrayList of branches
            Branch _branch = branches.get(i);

            // representation of branch resolution
            if (_branch.getPlayers().size() > 1) {
                System.out.println(">>> BRANCH: " + i);
                
                // get losers
                losers = _branch.resolve_branch();

                // start new round
                _branch.new_round();
                thereIsAMatch = true;

                // check branches
                if (branches.size() < totalLose)
                    branches.add(new Branch(losers, cli));
                else if (i < (totalLose - 1)) {
                    branches.get(i + 1).addPlayers(losers);
                }
            }

            // final phase of the tournament
            // in this phase will take place the final match
            if (i == (totalLose - 1) && !thereIsAMatch) {
                
                // final match
                BinaryTournament deathmatch = new BinaryTournament(cli, 0);
                
                //get finalists
                Player player1 = branches.get(0).getPlayers().get(0);
                Player player2 = branches.get(1).getPlayers().get(0);

                // determine winner
                if (!deathmatch.run(player1, player2)) {
                    if (deathmatch.run(player1, player2))
                        winString += player1.getName();
                    else
                        winString += player2.getName();
                } else {
                    winString += player1.getName();
                }

                // end tournament
                finishTournament = true;
            }
        }

        // print winner
        System.out.println(winString);
    }
}
