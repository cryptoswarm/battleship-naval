import java.util.ArrayList;
import java.util.List;

public class ShotManager {
    private List<Shot> shots;

    public ShotManager() {
        shots = new ArrayList<>();
    }

    public List<Shot> getShots() {
        return this.shots;
    }

    public void addShot(Shot shot){
        this.shots.add(shot);
    }

    public void constructShots(String validInput) {
        String[] shotsCoordiantes = validInput.split(" ");
        for (String s: shotsCoordiantes) {
            Shot shot = new Shot(new Coordinate((int)s.charAt(1) - 48 -1,
                                            (int)s.charAt(0) - 65));

            this.addShot(shot);
        }
    }
}
