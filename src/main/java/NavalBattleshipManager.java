/**
 The following code represents a naval battleship game.
 The game space consists of 9 rows and 18 columns.
 Initially, the code displays a welcome message followed by a table filled with '~'.
 Then, a message asks the user to enter boats according to a format.
 If the format is not respected, an error message will be displayed asking the user to enter boats again.
 Then, a message prompts the user to enter shots.
 If the shots fired are not valid, the user will be prompted to enter shots again.
 The program is functional except that it displays 'o' instead of '*' for hit boat parts.
 The program runs in a loop until the enter key is clicked.
 */

public class NavalBattleshipManager {

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

    /**
     * Check the size of the boat
     * @param grandeurBateau is the size of the boat, can be p, m, or g
     */
    public static boolean isBoatSizeValid(char grandeurBateau) {
        boolean estValide;

        estValide = true;

        if (grandeurBateau != 'p' && grandeurBateau != 'm' && grandeurBateau != 'g') {

            Pep8.charo('\n');
            estValide = false;
        }
        return estValide;
    }

    /**
     * @param orientation, the orientation of the boat h for horizontal. v for vertical.
     * @return character > when the position is horizontal otherwise V.
     */
    public static boolean isBoatDirectionValid(char orientation) {
        boolean estValide;

        estValide = true;
        if(orientation != 'h' && orientation != 'v') {
            estValide = false;
        }

        return estValide;
    }

    /**
     * @param alpha the letter designating the column, must be between A and R
     * @return alpha
     */
    public static boolean isColumnLetterValid(char alpha) {
        boolean estValide;

        estValide = true;
        if (alpha < 'A' || alpha > 'R') {

            estValide = false;

        }
        return estValide;
    }

    /**
     * @param rangee, number of rows, cannot be more than 9
     * @return number of rows
     */
    public static boolean isNbrInRange(char rangee) {
        boolean estValide;
        estValide = true;
        if ((int) rangee < 49 || (int) rangee > 57) {
            estValide = false;
        }
        return estValide;
    }

    /**
     * @param rangee row of the array
     * @param colonne column of the array
     * @param tild the character '~'
     * @return prints the game board array
     */
    public static char [][] displayInitialGrid(int rangee, int colonne, char tild){
        char [][]situationInitiale = new char [rangee][colonne];

        situationInitiale[rangee-1][colonne-1] =tild;

        for (rangee = 0; rangee < situationInitiale.length; rangee++) {
            Pep8.deco(rangee + 1);
            Pep8.charo('|');

            for (colonne = 0; colonne < (situationInitiale[rangee].length); colonne++) {

                Pep8.charo(situationInitiale[rangee][colonne] =tild);
                Pep8.charo(' ');
            }
            Pep8.charo('|');
            Pep8.charo('\n');
        };
        return situationInitiale;
    }

    /**
     * @param positionDesBateau game space array
     * @return boolean, whether there are any parts of the boat left undestroyed or not
     */
    public static boolean stillHasBoat(char [][]positionDesBateau){

        boolean resultat = false;
        for(int rangee=0; rangee<positionDesBateau.length; rangee++){
            for(int colonne=0; colonne<positionDesBateau[rangee].length; colonne++){
                if(positionDesBateau[rangee][colonne]=='v' ||positionDesBateau[rangee][colonne]=='>' ){
                    resultat=true;
                }
            }
        }
        return resultat;
    }

    /**
     * @param tailleTab boat size
     * @param orint orientation
     * @param rangee number of rows
     * @param col number of columns
     * @return the boolean is used to repeat the request to enter boats if they exceed the game space.
     */
    public static boolean isBoatSizeDirectionValid(char []tailleTab, char []orint, int []rangee, int []col){
        int j=0;
        boolean res=false;

        if(tailleTab[j]=='g'){

            if(orint[j]=='v'){
                if(rangee[j]>=6 ){
                    res=true;
                    Pep8.stro(Constant.BOAT_SIZE_INVALID_MSG);
                }
            }
        }

        if( tailleTab[j] =='m'){
            if(orint[j]=='v'){
                if(rangee[j]>7){
                    res=true;
                }
            }
        }

        if(tailleTab[j]=='g' ){
            if(orint[j]=='h'){
                if(col[j]>13){
                    res=true;
                }
            }
        }

        if( tailleTab[j] =='m'){
            if(orint[j]=='h'){
                if(col[j]>15){
                    res=true;
                }
            }
        }
        return res;
    }

    public static boolean isBoatDestroyed(char [][] positionDesBateau, int []rangFeu, int []colFeu, int j) {

        boolean effect = false;
        int[] tempRangeeFeu = new int[5000];
        int[] tempColonneFeu = new int[5000];

        for (int rangee = 0; rangee < positionDesBateau.length; rangee++) {
            for (int colonne = 0; colonne < positionDesBateau[rangee].length; colonne++) {

                if ((rangFeu[j] >0 || rangFeu[j]<=9) && (colFeu[j]>0 || colFeu[j]<=18) ) {

                    if (positionDesBateau[rangee][colonne] == 'v' || positionDesBateau[rangee][colonne] == '>') {

                        if (positionDesBateau[rangFeu[j] - 1][colFeu[j]] == 'v' || positionDesBateau[rangFeu[j] - 1][colFeu[j]] == '>') {

                            positionDesBateau[rangFeu[j] - 1][colFeu[j]] = '*';

                            if (rangFeu[j] > 1 && rangFeu[j] < 9) {

                                if (positionDesBateau[(rangFeu[j] - 1) - 1][colFeu[j]] == '>' || positionDesBateau[(rangFeu[j] - 1) - 1][colFeu[j]] == 'v') {
                                    positionDesBateau[(rangFeu[j] - 1) - 1][colFeu[j]] = '*';
                                } else {
                                    positionDesBateau[(rangFeu[j] - 1) - 1][colFeu[j]] = 'o';
                                }
                                if (positionDesBateau[(rangFeu[j] - 1)][colFeu[j] - 1] == '>' || positionDesBateau[(rangFeu[j] - 1)][colFeu[j] - 1] == 'v') {
                                    positionDesBateau[(rangFeu[j] - 1)][colFeu[j] - 1] = '*';
                                } else {
                                    positionDesBateau[(rangFeu[j] - 1)][colFeu[j] - 1] = 'o';
                                }
                                if (positionDesBateau[(rangFeu[j] - 1) + 1][colFeu[j]] == 'v' || positionDesBateau[(rangFeu[j] - 1) + 1][colFeu[j]] == '>') {
                                    positionDesBateau[(rangFeu[j] - 1) + 1][colFeu[j]] = '*';
                                } else {
                                    positionDesBateau[(rangFeu[j] - 1) + 1][colFeu[j]] = 'o';
                                }

                            } else if (rangFeu[j] == 9) {
                                tempRangeeFeu[j] = rangFeu[j] - 1;
                                positionDesBateau[(tempRangeeFeu[j])][colFeu[j]] = '*';

                                positionDesBateau[tempRangeeFeu[j] - 1][colFeu[j]] = 'o';
                                positionDesBateau[tempRangeeFeu[j]][colFeu[j] - 1] = 'o';

                            } else if (rangFeu[j] == 1) {
                                tempRangeeFeu[j] = rangFeu[j] + 1;

                                positionDesBateau[(tempRangeeFeu[j] - 1) - 1][colFeu[j]] = 'o';
                                positionDesBateau[(tempRangeeFeu[j] - 1)][colFeu[j]] = 'o';
                            }
                            positionDesBateau[rangFeu[j] - 1][(colFeu[j]) + 1] = 'o';

                            if (colFeu[j] == 1) {
                                tempColonneFeu[j] = colFeu[j] + 1;
                                positionDesBateau[rangFeu[j]][tempColonneFeu[j] - 1] = 'o';
                            }
                            effect = true;
                        }
                    }
                }
            }
        }
        return effect;
    }

    public static void main(String[] args) {

        boolean estValide;
        char lignInput1;
        char charQuitter;
        int n=0;
        int k=0;
        int j;

        int rangeeInitiale;

        int colonneInitiale;

        displayWelcomeMsg();
        displayLetters();
        Pep8.charo('\n');

        char [][] positionDesBateau = displayInitialGrid(9, 18, '~');

        char []tailleTab=new char[1000];
        char []orientationTab=new char[1000];
        char []colonneTab=new char[1000];
        int  []colonneTabConvertis = new int [1000];
        char []rangeeTab=new char[1000];
        int  []rangeeTabConvertis = new int [1000];

        do {
            /**
             * Loop to stop the program when the Enter key is pressed.
            */
            do {
                displayBoatSizePositionMsg();
                estValide = true;

                /**
                 Loop to stop reading the input line.
                 The space between characters is taken as the condition to continue reading.
                 */
                do {
                    /**
                     * The 1st character is the boat size
                     */
                    tailleTab[n] = Pep8.chari();

                    if (!isBoatSizeValid(tailleTab[n])) {
                        estValide = false;
                    }

                    /**
                     * The 2nd character is the boat direction
                     */
                    orientationTab[n] = Pep8.chari();

                    if (!isBoatDirectionValid(orientationTab[n])) {
                        estValide = false;
                    }

                    /**
                     * The 3rd character is the column
                     */
                    colonneTab[n] = Pep8.chari();

                    if (!isColumnLetterValid(colonneTab[n])) {
                        estValide = false;
                    }

                    /**
                     * The 4th character is the row
                     */
                    rangeeTab[n] = Pep8.chari();

                    if (!isNbrInRange(rangeeTab[n])) {
                        estValide = false;
                    }

                    if(!estValide){
                        n=0;

                    }else{
                        n++;
                    }

                    /**
                     * The 5th character is the space separating the specifications of one boat from another.
                     */
                    lignInput1 = Pep8.chari();
                } while (lignInput1 == ' ');

                /**
                 * Conversion of characters to integers
                 */
                for ( j = 0; j < n; j++) {
                    colonneTabConvertis[j] = (int) colonneTab[j] - 65;
                    rangeeTabConvertis[j] = (int) rangeeTab[j] - 48;

                    /**
                     * Displaying the updated game space
                     */
                    for (rangeeInitiale = 0; rangeeInitiale < positionDesBateau.length; rangeeInitiale++) {

                        for (colonneInitiale = 0; colonneInitiale < positionDesBateau[rangeeInitiale].length; colonneInitiale++) {

                            /**
                             When the coordinates of the initial boat equal the coordinates of the entered position,
                             a coordinate of the initial boat is defined by the row number and column number,
                             and a coordinate of the boat position is defined by the row number and column number.
                             */
                            if (tailleTab[j] == 'g') {

                                if (orientationTab[j] == 'h') {
                                    /**
                                     If the boat is large and oriented horizontally,
                                     and if the column starts at O, the boat will not be displayed.
                                     */
                                    if (positionDesBateau[rangeeInitiale].length - (colonneTabConvertis[j] - 1) > 5) {

                                        for (int i = 0; i < 5; i++) {

                                            if (rangeeInitiale == (rangeeTabConvertis[j] - 1) && (colonneInitiale == colonneTabConvertis[j])) {
                                                positionDesBateau[rangeeTabConvertis[j] - 1][colonneTabConvertis[j] + i] = '>';

                                            } else if ((rangeeTabConvertis[j] == rangeeTabConvertis[j + 1]) && (colonneTabConvertis[j + 1] > colonneTabConvertis[j])) {
                                                // }
                                                positionDesBateau[rangeeTabConvertis[j + 1]][colonneTabConvertis[j + 1] + i] = ' ';
                                            }
                                        }
                                    }

                                    /**
                                     * If the boat is large and oriented vertically,
                                     * and if the row starts at 6, the boat will not be displayed.
                                     */
                                } else if (orientationTab[j] == 'v') {
                                    if (positionDesBateau.length - (rangeeTabConvertis[j] -1) >= 5) {
                                        for (int i = 0; i < 5; i++) {
                                            if (rangeeInitiale == (rangeeTabConvertis[j] - 1 + i) && (colonneInitiale == colonneTabConvertis[j])) {
                                                positionDesBateau[(rangeeTabConvertis[j] - 1) + i][colonneTabConvertis[j]] = 'v';
                                            }
                                        }
                                    }
                                }
                            }else if (tailleTab[j] == 'm') {
                                if (orientationTab[j] == 'h') {

                                    /**
                                     * If the boat is medium-sized and oriented horizontally,
                                     * and if the column starts at Q, the boat will not be displayed.
                                     */
                                    if (positionDesBateau[rangeeInitiale].length - (colonneTabConvertis[j] - 1) > 3) {
                                        for (int i = 0; i < 3; i++) {
                                            if (rangeeInitiale == (rangeeTabConvertis[j] - 1) && (colonneInitiale == colonneTabConvertis[j])) {
                                                positionDesBateau[rangeeTabConvertis[j] - 1][colonneTabConvertis[j] + i] = '>';
                                            }
                                        }
                                    }

                                } else if (orientationTab[j] == 'v') {

                                    /**
                                     * If the boat is medium-sized and oriented vertically,
                                     * and if the row starts at 8, the boat will not be displayed.
                                     */
                                    if (positionDesBateau.length - (rangeeTabConvertis[j] -1) >= 3) {
                                        for (int i = 0; i < 3; i++) {
                                            if (rangeeInitiale == (rangeeTabConvertis[j] - 1 + i) && (colonneInitiale == colonneTabConvertis[j])) {
                                                positionDesBateau[(rangeeTabConvertis[j] - 1) + i][colonneTabConvertis[j]] = 'v';
                                            }
                                        }
                                    }
                                }
                            } else if (tailleTab[j] == 'p') {

                                if (orientationTab[j] == 'h') {
                                    for (int i = 0; i < 1; i++) {
                                        if (rangeeInitiale == (rangeeTabConvertis[j] - 1) && (colonneInitiale == colonneTabConvertis[j])) {
                                            positionDesBateau[rangeeTabConvertis[j] - 1][colonneTabConvertis[j] + i] = '>';
                                        }
                                    }
                                }
                            } else if (orientationTab[j] == 'v') {

                                for (int i = 0; i < 1; i++) {
                                    if (rangeeInitiale == (rangeeTabConvertis[j] - 1 + i) && (colonneInitiale == colonneTabConvertis[j])) {
                                        positionDesBateau[rangeeTabConvertis[j] - 1 + i][colonneTabConvertis[j]] = 'v';
                                    }
                                }
                            }
                        }
                    }
                }
            }while(!estValide || isBoatSizeDirectionValid(tailleTab, orientationTab, rangeeTabConvertis, colonneTabConvertis));

            /**
             * Displaying the updated game space
             */
            displayLetters();
            Pep8.charo('\n');
            char c;
            for (rangeeInitiale = 0; rangeeInitiale < positionDesBateau.length; rangeeInitiale++) {
                Pep8.deco(rangeeInitiale + 1);
                Pep8.charo('|');
                for (colonneInitiale = 0; colonneInitiale < positionDesBateau[rangeeInitiale].length; colonneInitiale++) {
                    c = positionDesBateau[rangeeInitiale][colonneInitiale];

                    Pep8.charo(c);

                    Pep8.charo(' ');
                }
                Pep8.charo('|');
                Pep8.charo('\n');
            }

            /**
             * The following code snippet will display a message asking the player to enter shots.
             */
            char  espaceEntreCoup;
            char []colonneFeu = new char[1000];
            int [] colonneFeuConvertis = new int [1000];
            char []rangeeFeu = new char [1000];
            int [] rangeeFeuConvertis = new int [1000];

            /**
             * Verification of the entered shots.
             */
            do{
                Pep8.charo('\n');
                displayTakeShotMsg();
                estValide=true;

                do{
                    colonneFeu[k] = Pep8.chari();
                    if (!isColumnLetterValid(colonneFeu[k])){
                        estValide = false;
                    }
                    rangeeFeu[k] = Pep8.chari() ;
                    if (!isNbrInRange(rangeeFeu[k])) {
                        estValide = false;
                    }

                    if(!estValide){
                        k=0;
                    }else{
                        k++;}

                    espaceEntreCoup = Pep8.chari();

                }while(espaceEntreCoup==' ');

                for (j = 0; j < k; j++) {

                    /**
                     * Conversion of characters to integers
                     */
                    colonneFeuConvertis[j] = (int) colonneFeu[j] - 65;
                    Pep8.charo('\n');

                    rangeeFeuConvertis[j] = (int) rangeeFeu[j] - 48;
                    Pep8.charo('\n');

                    /**
                     The following code is supposed to display the updated game
                     the position of the boats & the fired shots
                     */
                    displayLetters();
                    Pep8.charo('\n');

                    for (rangeeInitiale = 0; rangeeInitiale < positionDesBateau.length; rangeeInitiale++) {
                        Pep8.deco(rangeeInitiale + 1);
                        Pep8.charo('|');

                        for (colonneInitiale = 0; colonneInitiale < positionDesBateau[rangeeInitiale].length; colonneInitiale++) {

                            /**
                             * When the coordinates of the initial boat equal the coordinates of the entered position,
                             * a coordinate of the initial boat is defined by the row number and column number,
                             * and a coordinate of the boat position is defined by the row number and column number.
                             */
                            if (tailleTab[j] == 'g') {
                                if (orientationTab[j] == 'h') {

                                    if (positionDesBateau[rangeeInitiale].length - (colonneTabConvertis[j] - 1) > 5) {

                                        for (int i = 0; i < 5; i++) {

                                            if (rangeeInitiale == (rangeeTabConvertis[j] - 1) && (colonneInitiale == colonneTabConvertis[j])) {
                                                positionDesBateau[rangeeTabConvertis[j] - 1][colonneTabConvertis[j] + i] = '>';

                                            } else if ((rangeeTabConvertis[j] == rangeeTabConvertis[j + 1]) && (colonneTabConvertis[j + 1] > colonneTabConvertis[j])) {

                                                positionDesBateau[rangeeTabConvertis[j + 1]][colonneTabConvertis[j + 1] + i] = ' ';
                                            }
                                        }
                                    }
                                } else if (orientationTab[j] == 'v') {

                                    if (positionDesBateau.length - (rangeeTabConvertis[j] -1) >= 5) {
                                        for (int i = 0; i < 5; i++) {
                                            if (rangeeInitiale == (rangeeTabConvertis[j] - 1 + i) && (colonneInitiale == colonneTabConvertis[j])) {
                                                positionDesBateau[(rangeeTabConvertis[j] - 1) + i][colonneTabConvertis[j]] = 'v';
                                            }
                                        }
                                    }
                                }
                            }else if (tailleTab[j] == 'm') {

                                if (orientationTab[j] == 'h') {
                                    if (positionDesBateau[rangeeInitiale].length - (colonneTabConvertis[j] - 1) > 3) {

                                        for (int i = 0; i < 3; i++) {
                                            if (rangeeInitiale == (rangeeTabConvertis[j] - 1) && (colonneInitiale == colonneTabConvertis[j])) {
                                                positionDesBateau[rangeeTabConvertis[j] - 1][colonneTabConvertis[j] + i] = '>';
                                            }
                                        }
                                    }
                                } else if (orientationTab[j] == 'v') {
                                    if (positionDesBateau.length - (rangeeTabConvertis[j] -1) >= 3) {
                                        for (int i = 0; i < 3; i++) {
                                            if (rangeeInitiale == (rangeeTabConvertis[j] - 1 + i) && (colonneInitiale == colonneTabConvertis[j])) {
                                                positionDesBateau[(rangeeTabConvertis[j] - 1) + i][colonneTabConvertis[j]] = 'v';
                                            }
                                        }
                                    }
                                }
                            } else if (tailleTab[j] == 'p') {

                                if (orientationTab[j] == 'h') {

                                    for (int i = 0; i < 1; i++) {
                                        if (rangeeInitiale == (rangeeTabConvertis[j] - 1) && (colonneInitiale == colonneTabConvertis[j])) {
                                            positionDesBateau[rangeeTabConvertis[j] - 1][colonneTabConvertis[j] + i] = '>';
                                        }
                                    }
                                }
                            } else if (orientationTab[j] == 'v') {

                                for (int i = 0; i < 1; i++) {
                                    if (rangeeInitiale == (rangeeTabConvertis[j] - 1 + i) && (colonneInitiale == colonneTabConvertis[j])) {
                                        positionDesBateau[rangeeTabConvertis[j] - 1 + i][colonneTabConvertis[j]] = 'v';
                                    }
                                }
                            }

                            /**
                             * Condition verifying if the coordinates of the shots fired are at the same place as the positions of the boats.
                             **/

                            if(isBoatDestroyed(positionDesBateau, rangeeFeuConvertis, colonneFeuConvertis, j)){

                            } else {
                                positionDesBateau[rangeeFeuConvertis[j] - 1][colonneFeuConvertis[j]] = 'o';
                            }

                            /**
                             * le char c est '~'
                             */
                            c = positionDesBateau[rangeeInitiale][colonneInitiale];

                            Pep8.charo(c);
                            Pep8.charo(' ');
                        }
                        Pep8.charo('|');
                        Pep8.charo('\n');
                    }
                }
                /**
                 * We redo the execution of the program if the entered shots are invalid
                 * or if there are still boats not destroyed.
                 */
            }while(!estValide || stillHasBoat(positionDesBateau));

            /**
             * To quit the game, enter a character other than <Enter> and then press <Enter>.
             */
            for(rangeeInitiale=0; rangeeInitiale<positionDesBateau.length; rangeeInitiale++){
                for(colonneInitiale=0; colonneInitiale<positionDesBateau[rangeeInitiale].length; colonneInitiale++){
                    positionDesBateau[rangeeInitiale][colonneInitiale]='~';
                }
            }

            Pep8.charo('\n');
            displayExitMsg();
            charQuitter = Pep8.chari();
            if(charQuitter=='\n') {
                n = 0;
                k=0;
            }
        } while (charQuitter == '\n');
    }
}



