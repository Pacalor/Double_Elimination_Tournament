package tde.cli;

public class Constants {

    public static String DATAFILE = "tde\\src\\main\\java\\tde\\cli\\names.txt";
    public static String WELCOMEMENSAJE = "Welcome to the Tournament CLI";
    public static String MENUINITIALIZATION = " 0 from file, 1 from random, 2 from CLI";
    public static enum InitType{
        FILE(0),BASIC(1),CLI(2);

        private final int value;
        private InitType(int value) {
            this.value = value;
        }
    
        public int getValue() {
            return value;
        }
    } 



}
