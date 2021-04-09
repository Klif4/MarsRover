public enum Direction {
  EAST(Location::incrX, Location::decrX),
  NORTH(Location::decrY, Location::incrY),
  WEST(Location::decrX, Location::incrX),
  SOUTH(Location::incrY, Location::decrY);

  private final LocationTranslation locationForwarding;
  private final LocationTranslation locationBackwarding;

  Direction(LocationTranslation locationForwarding, LocationTranslation locationBackwarding) {
    this.locationForwarding = locationForwarding;
    this.locationBackwarding = locationBackwarding;
  }


  public Location forwardLocation(Location location) {
    return locationForwarding.handle(location);
  }

  public Location backwardLocation(Location location) {
    return locationBackwarding.handle(location);
  }

  public Direction turnLeft() {
    Direction[] directions = values();
    return directions[(ordinal() + 1) % directions.length];
  }

  public Direction turnRight() {
    Direction[] directions = values();
    return directions[(ordinal() - 1 + directions.length) % directions.length];
  }

  @FunctionalInterface
  interface LocationTranslation {

    Location handle(Location location);
  }

}
