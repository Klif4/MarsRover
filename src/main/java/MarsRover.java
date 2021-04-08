public class MarsRover {

  private final Location location;
  private final Direction direction;

  public MarsRover(Location location, Direction direction) {
    this.location = location;
    this.direction = direction;
  }

  public Location location() {
    return location;
  }

  public void move(Command command) {
    direction.forwardLocation(location);
  }
}
