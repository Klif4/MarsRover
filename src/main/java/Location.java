import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Location {

  private final Coordinate x;
  private final Coordinate y;
  private final Grid grid;

  public Location(int x, int y, Grid grid) {

    this.x = new Coordinate(x, grid.x());
    this.y = new Coordinate(y, grid.y());
    this.grid = grid;
  }

  public Location incrX() {
    x.incr();
    return this;
  }

  public Location decrY() {
    y.decr();
    return this;
  }

  public  Location decrX() {
    x.decr();
    return this;
  }

  public Location incrY() {
    y.incr();
    return this;
  }
}
