import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DirectionTest {

  @Test
  void south_forwarding() {
    Location location = new Location(0, 0, new Grid(100, 100));
    Location expected = Direction.SOUTH.forwardLocation(location);
    assertThat(expected).isEqualTo(new Location(0, 1, new Grid(100, 100)));
  }

  @Test
  void south_forwarding_limit_case() {
    Location location = new Location(0, 100, new Grid(100, 100));
    Location expected = Direction.SOUTH.forwardLocation(location);
    assertThat(expected).isEqualTo(new Location(0, 100, new Grid(100, 100)));
  }

  @Test
  void east_forwarding() {
    Location location = new Location(0, 0, new Grid(100, 100));
    Location expected = Direction.EAST.forwardLocation(location);
    assertThat(expected).isEqualTo(new Location(1, 0, new Grid(100, 100)));
  }

  @Test
  void east_forwarding_limit_case() {
    Location location = new Location(100, 0, new Grid(100, 100));
    Location expected = Direction.EAST.forwardLocation(location);
    assertThat(expected).isEqualTo(new Location(100, 0, new Grid(100, 100)));
  }

  @Test
  void north_forwarding() {
    Location location = new Location(0, 10, new Grid(100, 100));
    Location expected = Direction.NORTH.forwardLocation(location);
    assertThat(expected).isEqualTo(new Location(0, 9, new Grid(100, 100)));
  }

  @Test
  void north_forwarding_limit_case() {
    Location location = new Location(0, 0, new Grid(100, 100));
    Location expected = Direction.NORTH.forwardLocation(location);
    assertThat(expected).isEqualTo(new Location(0, 0, new Grid(100, 100)));
  }

  @Test
  void west_forwarding() {
    Location location = new Location(10, 0, new Grid(100, 100));
    Location expected = Direction.WEST.forwardLocation(location);
    assertThat(expected).isEqualTo(new Location(9, 0, new Grid(100, 100)));
  }

  @Test
  void west_forwarding_limit_case() {
    Location location = new Location(0, 0, new Grid(100, 100));
    Location expected = Direction.WEST.forwardLocation(location);
    assertThat(expected).isEqualTo(new Location(0, 0, new Grid(100, 100)));
  }
}