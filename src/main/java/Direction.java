public enum Direction {
  EAST(Location::incrX, Location::decrX),
  NORTH(Location::decrY, Location::incrY),
  WEST(Location::decrX, Location::incrX),
  SOUTH(Location::incrY, Location::decrY);

  private final LocationForwarding locationForwarding;
  private final LocationBackwarding locationBackwarding;

  Direction(LocationForwarding locationForwarding, LocationBackwarding locationBackwarding) {
    this.locationForwarding = locationForwarding;
    this.locationBackwarding = locationBackwarding;
  }


  public Location forwardLocation(Location location) {
    return locationForwarding.handle(location);
  }

  public Location backwardLocation(Location location) {
    return locationBackwarding.handle(location);
  }

  interface LocationForwarding {
    Location handle(Location location);
  }

  interface LocationBackwarding {
    Location handle(Location location);
  }
}
