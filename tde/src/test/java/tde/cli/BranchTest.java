package tde.cli;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;

public class BranchTest {
    @Test
    public void testAddPlayers() {
        // GIVEN
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Player> toAdd = new ArrayList<>();
        Player player1 = new Player("A");
        Player player2 = new Player("B");
        Player player3 = new Player("C");
        Branch branch = new Branch(players, null);

        toAdd.add(player1);
        toAdd.add(player2);
        toAdd.add(player3);

        // WHEN
        branch.addPlayers(toAdd);

        // THEN
        assertEquals(players, toAdd);
    }

    @Test
    public void testNew_round() {
        // GIVEN
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Player> winners = new ArrayList<>();
        ArrayList<Player> losers = new ArrayList<>();
        Player player1 = new Player("A");
        Player player2 = new Player("B");
        Player player3 = new Player("C");
        Branch branch = new Branch(players, null);

        winners.add(player1);
        winners.add(player2);
        winners.add(player3);

        branch.addWinners(winners);
        branch.addLosers(losers);

        // WHEN
        branch.new_round();

        int winnersSize = branch.getWinners().size();
        int losersSize = branch.getLosers().size();
        int playersSize = branch.getPlayers().size();

        // THEN
        assertEquals(winnersSize, 0);
        assertEquals(losersSize, 0);
        assertEquals(playersSize, 3);
    }

    @Test
    public void testResolve_branch() {
        // GIVEN
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Player> winners = new ArrayList<>();
        ArrayList<Player> losers = new ArrayList<>();
        Player player1 = new Player("A");
        Player player2 = new Player("B");
        Player player3 = new Player("C");
        Player player4 = new Player("D");
        Branch branch = new Branch(players, null);
        BinaryTournament bitour = new BinaryTournament(null, 0);

        // WHEN
        // THEN
    }
}
