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
 The program runs in a loop until the enter key is clicked.
 */

public class NavalBattleshipManager {

    public static void destroyBoat(Grid grid, Coordinate shotCoordinate) {

        if (shotCoordinate.getRowCoordinate() >= 0 && shotCoordinate.getRowCoordinate() < 9 &&
                shotCoordinate.getColumnCoordinate() >= 0 && shotCoordinate.getColumnCoordinate() < 18) {
            if (grid.getContentByCoordinate(shotCoordinate) == '~') {

                grid.replaceContent(shotCoordinate, 'o');

            } else if (grid.getContentByCoordinate(shotCoordinate) == '>' ||
                    grid.getContentByCoordinate(shotCoordinate) == 'v') {

                grid.replaceContent(shotCoordinate, '*');

                destroyBoat(grid, new Coordinate(shotCoordinate.getRowCoordinate(), shotCoordinate.getColumnCoordinate() + 1));
                destroyBoat(grid, new Coordinate(shotCoordinate.getRowCoordinate(), shotCoordinate.getColumnCoordinate() - 1));
                destroyBoat(grid, new Coordinate(shotCoordinate.getRowCoordinate()+1, shotCoordinate.getColumnCoordinate()));
                destroyBoat(grid, new Coordinate(shotCoordinate.getRowCoordinate()-1, shotCoordinate.getColumnCoordinate()));
            }
        }
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

    public static void play(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean isValid;
        char exitCharacter;

        Grid grid = new Grid(9, 18, '~');

        do {
            DisplayMessage.displayWelcomeMsg();
            grid.createInitialGrid();
            grid.displayGrid();

            String input;
            do {
                DisplayMessage.displayBoatSizePositionMsg();
                input = scanner.nextLine();
                isValid = isUserInputValid(input, "^[sml][hv][A-R][1-9]$");
            } while (!isValid);

            BoatManager boatManager = new BoatManager();
            boatManager.constructBoats(input);
            List<Boat> boats = boatManager.getBoats();

            for(Boat boat: boats){
                var isBoatInside = boatManager.isBoatInsideGrid(boat, grid);
                if(isBoatInside){
                    char replacementChar = boat.isHorizontal() ? '>' : 'v';
                    for (Coordinate coordinate: boat.getCoordinates()){
                        grid.replaceContent(coordinate, replacementChar);
                    }
                }
            }

            /**
             * Displaying the updated game space
             */
            grid.displayGrid();

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

                for (Shot shot: shots){
                    Coordinate coordinate = shot.getShotCoordinate();
                    destroyBoat(grid, coordinate);
                }

                grid.displayGrid();

            }while(boatManager.stilHasBoat(grid));

            /**
             * To quit the game, enter a character other than <Enter> and then press <Enter>.
             */
            Pep8.charo('\n');
            DisplayMessage.displayExitMsg();
            exitCharacter = Pep8.chari();
        } while (exitCharacter == '\n');
    }
}