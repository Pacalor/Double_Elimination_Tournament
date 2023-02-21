package tde.cli;

/*
 * Main execution class, it will be the API to call in order to use the TDE
 */
public class App {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        tournament.run();
    }
}
