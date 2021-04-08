public class MarsRover {

  private final Location location;
  private final Direction direction;

  public MarsRover(Location location, Direction direction) {
    this.location = location;
    this.direction = direction;
  }

  public void move(String command) {
    location.translate(direction);
  }

  public Location location() {
    return location;
  }
}
