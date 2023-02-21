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

        boolean thereIsAMatch = true;
        boolean finishTournament = false;
        ArrayList<Player> losers = null;
        String winString = "And the final winner is :";

        for (int i = 0; !finishTournament; i++) {

            if (i == totalLose) {
                i = 0;
                thereIsAMatch = false;
            }

            Branch _branch = branches.get(i);

            if (_branch.getPlayers().size() > 1) {
                System.out.println("--------------------  BRANCH -" + i);
                losers = _branch.resolve_branch();
                _branch.new_round();
                thereIsAMatch = true;

                if (branches.size() < totalLose)
                    branches.add(new Branch(losers, cli));
                else if (i < (totalLose - 1)) {
                    branches.get(i + 1).addPlayers(losers);
                }
            }

            if (i == (totalLose - 1) && !thereIsAMatch) {
                BinaryTournament deathmatch = new BinaryTournament(cli, 0);
                Player player1 = branches.get(0).getPlayers().get(0);
                Player player2 = branches.get(1).getPlayers().get(0);
                

                if (!deathmatch.run(player1, player2)) {
                    if(deathmatch.run(player1, player2))
                        winString += player1.getName();
                    else
                        winString += player2.getName();
                } else {
                    winString += player1.getName();
                }

                finishTournament = true;
            }
        }
        
        System.out.println(winString);
    }
}
