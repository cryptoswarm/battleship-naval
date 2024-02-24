public class Boat {
    private char direction;
    private char size;
    private BoatCoordinate position;

    public Boat(char size, char direction, BoatCoordinate position) {
        this.size = size;
        this.direction = direction;
        this.position = position;
    }

    public char getDirection() {
        return direction;
    }

    public char getSize() {
        return size;
    }

    public boolean isBoatHorizontal(){
        return this.direction == 'h';
    }

    public boolean isBoatVertical(){
        return direction == 'v';
    }

    public boolean isBoatSmall(){
        return size == 's';
    }

    public boolean isBoatMedium(){
        return size == 'm';
    }

    public boolean isBoatLarge(){
        return size == 'l';
    }

    public BoatCoordinate getPosition() {
        return position;
    }
}
