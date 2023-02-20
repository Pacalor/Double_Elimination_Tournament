package tde.cli;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static tde.cli.Constants.*;

/*
 * Method selection to return a start player list
 * 
 */
public class Initialization {

    List<Player> players;
    CLI ui;

    
    /**
     * Basic constructor
     * @param cli user interface to use
     */
    public Initialization(CLI cli) {
        players= new ArrayList<Player>();
        ui=cli;
    }

    /**
     * @param type of initialization to do
     * @param size of the Players (for random and basic)
     * @return list of player 
     */
    public List<Player> start(int type, int size){
        
        switch (type) {
            case 0:
                try {
                    readText();
                } catch (FileNotFoundException e) {
                    Logger.getAnonymousLogger().log(Level.INFO, DATAFILE + " file not found");
                } catch (IOException e) {
                    Logger.getAnonymousLogger().log(Level.INFO, DATAFILE + " error reading the file");
                }
                break;
            case 1:
                basic(size);
            break;
            case 2:
                fromCLI();
            break;
        }

        return players;
    }

    /**
     * funtion to read the players form a file
     * 
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void readText() throws FileNotFoundException, IOException{
        File textFile = new File(DATAFILE);
        
        if (!textFile.exists()) {
            throw new FileNotFoundException("Text file empty");
        }

        try ( BufferedReader br = new BufferedReader(new FileReader(textFile))) {
            String line;

            while ((line = br.readLine()) != null) {
                if(line!="") players.add(new Player(line)); 
            }
        }

    }


    /**
     * function to do a generic X playerrs
     * @param size number of players
     */
    private void basic(int size) {

        for (int index = 0; index < size; index++) {
            players.add(new Player("Player "+index));
        }

    }

    /**
     * Create playres from cli imput
     */
    private void fromCLI(){
        players=ui.getPlayers();
    } 
}
