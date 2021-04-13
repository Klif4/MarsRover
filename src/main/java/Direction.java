import java.util.function.Function;

public enum Direction {
  EAST(Location::incrX, Location::decrX),
  NORTH(Location::decrY, Location::incrY),
  WEST(Location::decrX, Location::incrX),
  SOUTH(Location::incrY, Location::decrY);

  private final Function<Location, Location> locationForwarding;
  private final Function<Location, Location> locationBackwarding;

  Direction(Function<Location, Location> locationForwarding, Function<Location, Location> locationBackwarding) {
    this.locationForwarding = locationForwarding;
    this.locationBackwarding = locationBackwarding;
  }

  public Function<Location, Location> forward() {
    return locationForwarding;
  }

  public Function<Location, Location> backward() {
    return locationBackwarding;
  }

  public Direction turnLeft() {
    Direction[] directions = values();
    return directions[(ordinal() + 1) % directions.length];
  }

  public Direction turnRight() {
    Direction[] directions = values();
    return directions[(ordinal() - 1 + directions.length) % directions.length];
  }

}
