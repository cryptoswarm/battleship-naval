import java.util.Objects;

public class Coordinate {
    private int startX;
    private int startY;

    public Coordinate(int rowCoordinate, int columnCoordinate) {
        this.startX = rowCoordinate;
        this.startY = columnCoordinate;
    }

    public int getRowCoordinate() {
        return startX;
    }

    public int getColumnCoordinate() {
        return startY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return startX == that.startX && startY == that.startY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startX, startY);
    }
}
