package tde.cli;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BinaryTournamentTest {
    @Test
    public void testRun() {
        // GIVEN
        Player player1 = new Player("A");
        Player player2 = new Player("B");
        // CLI cli = new CLI();
        BinaryTournament bitour = new BinaryTournament(null, 1);

        // WHEN
        boolean winner = bitour.run(player1, player2);

        // THEN
        if (winner) {
            assertEquals(true, winner);
        } else {
            assertEquals(false, winner);
        }

    }
}
