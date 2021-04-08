public enum Direction {
  EAST(Location::incrX),
  NORTH(Location::decrY),
  WEST(Location::decrX),
  SOUTH(Location::incrY);

  private final LocationForwarding locationForwarding;

  Direction(LocationForwarding test) {
    this.locationForwarding = test;
  }

  public void forwardLocation(Location location) {
    locationForwarding.handle(location);
  }

  interface LocationForwarding {
    void handle(Location location);
  }
}
