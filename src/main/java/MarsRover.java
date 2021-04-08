public class MarsRover {

  private Location location;
  private final Direction direction;

  public MarsRover(Location location, Direction direction) {
    this.location = location;
    this.direction = direction;
  }

  public Location location() {
    return location;
  }

  public void move(Command command) {
    location = direction.forwardLocation(location);
  }
}
