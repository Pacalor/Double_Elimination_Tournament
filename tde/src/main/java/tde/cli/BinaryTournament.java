package tde.cli;

import java.util.Random;

/*
 * BinaryTournament between 2 players, it needs a CLI input or a random winner
 */
public class BinaryTournament {

    Player player1;
    Player player2;
    CLI ui;
    int method;
     

    /**
     * @param _ui User interface to use
     * @param chooseMethod Type of tournament winner selection
     */
    public BinaryTournament(CLI _ui, int chooseMethod) {
        ui=_ui;
        method= (Integer)chooseMethod==null ? 0 : chooseMethod;
    }

    /**
     * @param a first player 
     * @param b second player
     * @return the winner player
     */
    public boolean run(Player a, Player b){
        
        player1=a;
        player2=b;
        boolean winner=false;

        winner = match();

        return winner;
    }


    /**
     * @return winner of the match after make 2 player compite 
     */
    private boolean match(){

        boolean winner=false;

        switch (method) {
            
            case 0: //CLI method
                winner = CLI.askWinner(player1,player2);
                break;

            case 1: //Random method
                Random random = new Random();
                winner= random.nextBoolean();
                break;
        }

        return winner;
    }



}
