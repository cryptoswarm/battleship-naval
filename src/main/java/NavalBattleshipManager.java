import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

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

    /**
     * @param positionDesBateau game space array
     * @return boolean, whether there are any parts of the boat left undestroyed or not
     */
    public static boolean stillHasBoat(char [][]positionDesBateau){

        boolean resultat = false;
        for(int row=0; row<positionDesBateau.length; row++){
            for(int column=0; column<positionDesBateau[row].length; column++){
                if(positionDesBateau[row][column]=='v' ||positionDesBateau[row][column]=='>' ){
                    resultat=true;
                }
            }
        }
        return resultat;
    }

    public static boolean isBoatDestroyed(char [][] positionDesBateau, List<Boat> boats, List<Shot> shots) {

        boolean effect = false;

        for (Boat boat: boats) {
            for(Shot shot: shots){
                if(boat.getPosition().equals(shot.getShotCoordinate())){
                    int x = shot.getShotCoordinate().getRowCoordinate() - 1; //rangFeu[j] - 1;
                    int y = shot.getShotCoordinate().getColumnCoordinate();// colFeu[j];

                    positionDesBateau[x][y] = '*';

                    if (x > 1 && x < 9) {

                        if (positionDesBateau[(x - 1) - 1][y] == '>' || positionDesBateau[(x - 1) - 1][y] == 'v') {
                            positionDesBateau[(x - 1) - 1][y] = '*';
                        } else {
                            positionDesBateau[(x - 1) - 1][y] = 'o';
                        }
                        if (positionDesBateau[(x - 1)][y - 1] == '>' || positionDesBateau[(x - 1)][y - 1] == 'v') {
                            positionDesBateau[(x - 1)][y - 1] = '*';
                        } else {
                            positionDesBateau[(x - 1)][y - 1] = 'o';
                        }
                        if (positionDesBateau[(x - 1) + 1][y] == 'v' || positionDesBateau[(x - 1) + 1][y] == '>') {
                            positionDesBateau[(x - 1) + 1][y] = '*';
                        } else {
                            positionDesBateau[(x - 1) + 1][y] = 'o';
                        }

                    } else if (x == 9) {
                        positionDesBateau[(x + 1)][y] = '*';

                        positionDesBateau[x + 1 - 1][y] = 'o';
                        positionDesBateau[x + 1][y - 1] = 'o';

                    } else if (x == 1) {
                        positionDesBateau[(x + 1 - 1) - 1][y] = 'o';
                        positionDesBateau[(x + 1 - 1)][y] = 'o';
                    }
                    positionDesBateau[x - 1][(y) + 1] = 'o';

                    if (y == 1) {
                        positionDesBateau[x][y + 1 - 1] = 'o';
                    }
                    effect = true;
                }
            }
        }
        return effect;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean isValid;
        char exitCharacter;
        int j;

        int initialRow;

        int initialColumn;

        char []tailleTab=new char[1000];
        char []orientationTab=new char[1000];
        int  []colonneTabConvertis = new int [1000];
        int  []rangeeTabConvertis = new int [1000];

        do {
            DisplayMessage.displayWelcomeMsg();
            DisplayMessage.displayLetters();
            Pep8.charo('\n');

            char [][] grid = Grid.displayInitialGrid(9, 18, '~');
            /**
             * Loop to stop the program when the Enter key is pressed.
            */
            String input = "";
            do {
                DisplayMessage.displayBoatSizePositionMsg();
                input = scanner.nextLine();
                isValid = isUserInputValid(input, "^[sml][hv][A-R][1-9]$");
            } while (!isValid);

            BoatManager boatManager = new BoatManager();
            boatManager.constructBoats(input);
            List<Boat> boats = boatManager.getBoats();

                /**
                 * Conversion of characters to integers
                 */
                j =0;
                for (Boat boat: boats) {
                    colonneTabConvertis[j] = boat.getPosition().getColumnCoordinate();
                    rangeeTabConvertis[j] =  boat.getPosition().getRowCoordinate();

                    /**
                     * Displaying the updated game space
                     */
                    for (initialRow = 0; initialRow < grid.length; initialRow++) {
                        for (initialColumn = 0; initialColumn < grid[initialRow].length; initialColumn++) {

                            /**
                             When the coordinates of the initial boat equal the coordinates of the entered position,
                             a coordinate of the initial boat is defined by the row number and column number,
                             and a coordinate of the boat position is defined by the row number and column number.
                             */
                            if (boat.isBoatLarge()) {
                                if (boat.isBoatHorizontal()) {
                                    /**
                                     If the boat is large and oriented horizontally,
                                     and if the column starts at O, the boat will not be displayed.
                                     */
                                    if (grid[initialRow].length - (boat.getPosition().getColumnCoordinate() - 1) > 5) {

                                        for (int i = 0; i < 5; i++) {

                                            if (initialRow == (rangeeTabConvertis[j] - 1) && (initialColumn == boat.getPosition().getColumnCoordinate())) {
                                                grid[rangeeTabConvertis[j] - 1][boat.getPosition().getColumnCoordinate() + i] = '>';

                                            } else if ((rangeeTabConvertis[j] == rangeeTabConvertis[j + 1]) && (colonneTabConvertis[j + 1] > boat.getPosition().getColumnCoordinate())) {
                                                grid[rangeeTabConvertis[j + 1]][colonneTabConvertis[j + 1] + i] = ' ';
                                            }
                                        }
                                    }

                                    /**
                                     * If the boat is large and oriented vertically,
                                     * and if the row starts at 6, the boat will not be displayed.
                                     */
                                } else if (boat.isBoatVertical()) {
                                    if (grid.length - (rangeeTabConvertis[j] -1) >= 5) {
                                        for (int i = 0; i < 5; i++) {
                                            if (initialRow == (rangeeTabConvertis[j] - 1 + i) && (initialColumn == boat.getPosition().getColumnCoordinate())) {
                                                grid[(rangeeTabConvertis[j] - 1) + i][boat.getPosition().getColumnCoordinate()] = 'v';
                                            }
                                        }
                                    }
                                }
                            }else if (boat.isBoatMedium()) {
                                if (boat.isBoatHorizontal()) {

                                    /**
                                     * If the boat is medium-sized and oriented horizontally,
                                     * and if the column starts at Q, the boat will not be displayed.
                                     */
                                    if (grid[initialRow].length - (boat.getPosition().getColumnCoordinate() - 1) > 3) {
                                        for (int i = 0; i < 3; i++) {
                                            if (initialRow == (rangeeTabConvertis[j] - 1) && (initialColumn == boat.getPosition().getColumnCoordinate())) {
                                                grid[rangeeTabConvertis[j] - 1][boat.getPosition().getColumnCoordinate() + i] = '>';
                                            }
                                        }
                                    }
                                } else if (boat.isBoatVertical()) {

                                    /**
                                     * If the boat is medium-sized and oriented vertically,
                                     * and if the row starts at 8, the boat will not be displayed.
                                     */
                                    if (grid.length - (rangeeTabConvertis[j] -1) >= 3) {
                                        for (int i = 0; i < 3; i++) {
                                            if (initialRow == (rangeeTabConvertis[j] - 1 + i) && (initialColumn == boat.getPosition().getColumnCoordinate())) {
                                                grid[(rangeeTabConvertis[j] - 1) + i][boat.getPosition().getColumnCoordinate()] = 'v';
                                            }
                                        }
                                    }
                                }
                            } else if (boat.isBoatSmall()) {
                                if (boat.isBoatHorizontal()) {
                                    for (int i = 0; i < 1; i++) {
                                        if (initialRow == (rangeeTabConvertis[j] - 1) && (initialColumn == boat.getPosition().getColumnCoordinate())) {
                                            grid[rangeeTabConvertis[j] - 1][boat.getPosition().getColumnCoordinate() + i] = '>';
                                        }
                                    }
                                }
                            } else if (boat.isBoatVertical()) {
                                for (int i = 0; i < 1; i++) {
                                    if (initialRow == (rangeeTabConvertis[j] - 1 + i) && (initialColumn == boat.getPosition().getColumnCoordinate())) {
                                        grid[rangeeTabConvertis[j] - 1 + i][boat.getPosition().getColumnCoordinate()] = 'v';
                                    }
                                }
                            }
                        }
                    }
                }
            /**
             * Displaying the updated game space
             */
            DisplayMessage.displayLetters();
            Pep8.charo('\n');
            char c;
            for (initialRow = 0; initialRow < grid.length; initialRow++) {
                Pep8.deco(initialRow + 1);
                Pep8.charo('|');
                for (initialColumn = 0; initialColumn < grid[initialRow].length; initialColumn++) {
                    c = grid[initialRow][initialColumn];

                    Pep8.charo(c);

                    Pep8.charo(' ');
                }
                Pep8.charo('|');
                Pep8.charo('\n');
            }

            /**
             * Verification of the entered shots.
             */

            do{
                Pep8.charo('\n');
                boolean isShotsInputValid;
                String shotsInput;

                do {
                    DisplayMessage.displayTakeShotMsg();
                    shotsInput = scanner.nextLine();
                    isShotsInputValid = isUserInputValid(shotsInput, "^[A-R][1-9]$");
                }while (!isShotsInputValid);

                ShotManager shotManager = new ShotManager();
                shotManager.constructShots(shotsInput);
                List<Shot> shots = shotManager.getShots();

                do{
                    isBoatDestroyed(grid, boats, shots);
                }while (!stillHasBoat(grid));

            }while(stillHasBoat(grid));

            /**
             * To quit the game, enter a character other than <Enter> and then press <Enter>.
             */
            for(initialRow=0; initialRow<grid.length; initialRow++){
                for(initialColumn=0; initialColumn<grid[initialRow].length; initialColumn++){
                    grid[initialRow][initialColumn]='~';
                }
            }

            Pep8.charo('\n');
            DisplayMessage.displayExitMsg();
            exitCharacter = Pep8.chari();
        } while (exitCharacter == '\n');
    }

    private static boolean isUserInputValid(String input, String requiredPattern) {
        String[] sizeDirections = input.split(" ");
        Pattern pattern = Pattern.compile(requiredPattern);
        for (String s: sizeDirections) {
            if(!pattern.matcher(s).matches()){
                return false;
            }
        }
        return true;
    }
}