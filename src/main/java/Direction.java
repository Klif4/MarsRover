public enum Direction {
  EAST(Location::incrX),
  NORTH(Location::decrY),
  WEST(Location::decrX),
  SOUTH(Location::incrY);

  private final LocationTranslation locationTranslation;

  Direction(LocationTranslation test) {
    this.locationTranslation = test;
  }

  public void forwardLocation(Location location) {
    locationTranslation.forward(location);
  }

  interface LocationTranslation {
    void forward(Location location);
  }
}
