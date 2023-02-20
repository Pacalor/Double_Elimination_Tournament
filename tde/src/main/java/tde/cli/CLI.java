package tde.cli;

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

    public void wellcome(){
        System.out.println(WELCOMEMENSAJE);

        System.out.println("Please introduce the number of rounds" );

        int rounds = Integer.parseInt(keyboard.nextLine());

        System.out.println("Please introduce the type of initialization" );
        System.out.println(MENUINITIALIZATION);

        
    }

    public boolean askWinner(Player player1, Player player2) {
        return false;
    }

    public List<Player> getPlayers() {
        return null;
    }


    
}
