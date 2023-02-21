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
        boolean finishTournament=false;
        ArrayList<Player> losers = null;

        for (int i = 0; !finishTournament; i++) {

            if (i == totalLose) {
                i = 0;
                thereIsAMatch=false;
            }

            Branch _branch = branches.get(i);

            if (_branch.getPlayers().size() > 1) {
                System.out.println("--------------------  BRANCH -" + i);
                losers = _branch.resolve_branch();
                _branch.new_round();
                thereIsAMatch=true;
            }

            if (branches.size() < totalLose)
                branches.add(new Branch(losers, cli));

            if(i==(totalLose-1) && !thereIsAMatch) finishTournament=true;
        }


        //TODO winners battle of death

    }
}
