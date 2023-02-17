package tde.cli;

/**
 * Player
 */

public class Player {
    private String name;

    /**
     * @param _name
     */
    public Player(String _name) {
        name = _name == null ? "No name" : _name;
    }

    /**
     * @return the player's name
     */
    public String getName() {
        return name;
    }

   
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "Player:" + name;
    }
}