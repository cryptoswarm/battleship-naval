import java.util.Objects;

public abstract class Coordinate {
    private int x;
    private int y;

    public Coordinate(int columnCoordinate, int rowCoordinate) {
        this.y = columnCoordinate;
        this.x = rowCoordinate;
    }

    public int getRowCoordinate() {
        return x;
    }

    public int getColumnCoordinate() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
