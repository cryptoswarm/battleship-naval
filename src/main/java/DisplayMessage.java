public class DisplayMessage {
    public static void displayBoatSizePositionMsg() {
        Pep8.stro(Constant.BOAT_SIZE_POSITION_MSG);
    }

    public static void displayWelcomeMsg() {
        Pep8.stro(Constant.WELCOME_MSG);
    }

    public static void displayLetters() {
        char colonne = 'A';
        Pep8.charo(' ');
        while (colonne <= 'R') {

            Pep8.stro(" " + colonne);

            colonne = (char) (colonne + 1);
        }
    }

    public static void displayTakeShotMsg() {
        Pep8.stro(Constant.FIRE_AT_WILL_MSG);
    }

    public static void displayExitMsg(){
        Pep8.stro(Constant.EXIT_MSG);
    }
}
