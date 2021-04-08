public enum Direction {
  EAST(Location::incrX),
  NORTH(Location::decrY),
  WEST(Location::decrX),
  SOUTH(Location::incrY);

  private final LocationForwarding locationForwarding;

  Direction(LocationForwarding test) {
    this.locationForwarding = test;
  }

  public Location forwardLocation(Location location) {
    return locationForwarding.handle(location);
  }

  interface LocationForwarding {
    Location handle(Location location);
  }
}
