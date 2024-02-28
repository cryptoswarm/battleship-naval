import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BoatManager {

    private List<Boat> boats;

    public BoatManager() {
        boats = new ArrayList<>();
    }

    public List<Boat> getBoats() {
        return this.boats;
    }

    public void addBoat(Boat boat){
        this.boats.add(boat);
    }

    public void constructBoats(String validInput) {
        String[] sizeDirections = validInput.split(" ");
        for (String s: sizeDirections) {
            Boat boat = new Boat(s.charAt(0),
                                s.charAt(1));
            var coordinates = createCoordinates(boat, (int)s.charAt(3) - 48, (int)s.charAt(2) - 65);
            boat.setCoordinates(coordinates);

            this.addBoat(boat);
        }
    }

    public boolean isBoatInsideGrid(Boat boat, Grid grid){
        Optional<Coordinate> first = boat.getFirstCoordinate();
        Optional<Coordinate> last = boat.getLastCoordinate();

        if(first.isEmpty() || last.isEmpty()){
            return false;
        }

        Coordinate firstCoordinate = first.get();
        Coordinate lastCoordinate = last.get();

        try{
            grid.replaceContent(firstCoordinate, '~');
            grid.replaceContent(lastCoordinate, '~');

        }catch (ArrayIndexOutOfBoundsException ex){
            return false;
        }

        return true;
    }

    private List<Coordinate> createCoordinates(Boat boat, int startX, int startY){
        List<Coordinate> coordinates = new ArrayList<>();
        int maxLength = boat.getSize();

        for (int i=0; i < maxLength; i++){
            if(boat.isHorizontal()){
                Coordinate coordinate = new Coordinate(startX - 1 , startY + i);
                coordinates.add(coordinate);
            } else if (boat.isVertical()) {
                coordinates.add(new Coordinate(startX - 1 + i, startY));
            }
        }
        return coordinates;
    }

    public boolean stilHasBoat(Grid grid){

        for (Boat boat: boats) {
            for (Coordinate coordinate: boat.getCoordinates()) {
                if(grid.getContentByCoordinate(coordinate) == 'v' ||
                        grid.getContentByCoordinate(coordinate) == '>'){
                    return true;
                }
            }
        }
        return false;
//        boolean resultat = false;
//        for(int rangee=0; rangee<boatPosition.length; rangee++){
//            for(int colonne=0; colonne<boatPosition[rangee].length; colonne++){
//                if(boatPosition[rangee][colonne]=='v' || boatPosition[rangee][colonne]=='>' ){
//                    resultat=true;
//                }
//            }
//        }
//
//        return resultat;
    }

}
