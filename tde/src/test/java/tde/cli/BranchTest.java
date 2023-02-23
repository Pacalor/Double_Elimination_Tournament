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
    public void testGetPlayers() {
        // GIVEN
        // WHEN
        // THEN
    }

    @Test
    public void testNew_round() {
        // GIVEN
        // WHEN
        // THEN
    }

    @Test
    public void testResolve_branch() {
        // GIVEN
        // WHEN
        // THEN
    }
}
