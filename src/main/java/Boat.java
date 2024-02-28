import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Boat {
    private char direction;
    private int size;
    private List<Coordinate> coordinates;

    public Boat(char size, char direction) {
        this.coordinates = new ArrayList<>();
        setSize(size);
        this.direction = direction;
    }

    public int getSize() {
        return size;
    }

    public boolean isHorizontal(){
        return this.direction == 'h';
    }

    public boolean isVertical(){
        return direction == 'v';
    }

    private void setSize(char size) {
        switch (size) {
            case 'l' -> this.size = 5;
            case 'm' -> this.size = 3;
            case 's' -> this.size = 1;
        }
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public Optional<Coordinate> getFirstCoordinate(){
        if(coordinates.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(coordinates.get(0));
    }

    public Optional<Coordinate> getLastCoordinate(){
        if(coordinates.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(coordinates.get(coordinates.size() - 1));
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }
}
