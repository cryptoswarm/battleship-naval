public class Grid {

    public static char[][] displayInitialGrid(int row, int column, char gridFilledChar){
        DisplayMessage.displayWelcomeMsg();
        DisplayMessage.displayLetters();
        Pep8.charo('\n');

        return createInitialGrid(row, column, gridFilledChar);
    }

    /**
     * @param row row of the array
     * @param column column of the array
     * @param gridFilledChar the character '~'
     * @return prints the game board array
     */
    private static char [][] createInitialGrid(int row, int column, char gridFilledChar){
        char [][]situationInitiale = new char [row][column];

        situationInitiale[row-1][column-1] = gridFilledChar;

        for (row = 0; row < situationInitiale.length; row++) {
            Pep8.deco(row + 1);

            Pep8.charo('|');

            for (column = 0; column < (situationInitiale[row].length); column++) {

                Pep8.charo(situationInitiale[row][column] =gridFilledChar);
                Pep8.charo(' ');
            }
            Pep8.charo('|');
            Pep8.charo('\n');
        };
        return situationInitiale;
    }
}
