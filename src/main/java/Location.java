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

  public void forward(Direction direction) {
    switch (direction) {
      case SOUTH:
        y.incr();
        break;
      case EAST:
        x.incr();
        break;
      case NORTH:
        y.decr();
        break;
      case WEST:
        x.decr();
        break;
      default:
        break;
    }
  }
}
