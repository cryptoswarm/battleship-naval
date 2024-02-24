import java.util.ArrayList;
import java.util.List;

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
                                s.charAt(1),
                                new BoatCoordinate((int)s.charAt(2) - 65, (int)s.charAt(3) - 48));

            this.addBoat(boat);
        }
    }
}
