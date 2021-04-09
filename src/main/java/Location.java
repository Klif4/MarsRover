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
    return new Location(x.incr().value(), y.value(), grid);
  }

  public Location decrY() {
    return new Location(x.value(), y.decr().value(), grid);
  }

  public  Location decrX() {
    return new Location(x.decr().value(), y.value(), grid);
  }

  public Location incrY() {
    return new Location(x.value(), y.incr().value(), grid);
  }
}
