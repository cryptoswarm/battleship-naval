import java.util.HashMap;
import java.util.Map;

public class Grid {

    private final int rowLength;
    private final int columnLength;
    private final Map<Coordinate, Character> grid;
    private final char initialContent;

    public Grid(int rowLength, int columnLength, char initialContent) {
        this.rowLength = rowLength;
        this.columnLength = columnLength;
        this.grid = new HashMap<>();
        this.initialContent = initialContent;
    }

    public void createInitialGrid(){

        for(int i=0; i< this.rowLength; i++ ){
            for(int j=0; j< this.columnLength; j++){
                this.grid.put(new Coordinate(i, j), this.initialContent);
            }
        }
    }

    public void displayGrid(){
        DisplayMessage.displayLetters();
        Pep8.charo('\n');
        for (int i=0; i < this.rowLength; i++) {
            Pep8.deco(i + 1);

            Pep8.charo('|');

            for (int j=0; j < this.columnLength; j++) {

                Pep8.charo(grid.get(new Coordinate(i, j)));
                Pep8.charo(' ');
            }
            Pep8.charo('|');
            Pep8.charo('\n');
        }
    }

    public void replaceContent(Coordinate coordinate, char replacement){
        this.grid.replace(coordinate, replacement);
    }

    public char getContentByCoordinate(Coordinate coordinate){
        return this.grid.get(coordinate);
    }
}
