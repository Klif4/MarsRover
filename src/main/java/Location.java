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

  public void incrX() {
    x.incr();
  }

  public void decrY() {
    y.decr();
  }

  public  void decrX() {
    x.decr();
  }

  public void incrY() {
    y.incr();
  }
}
