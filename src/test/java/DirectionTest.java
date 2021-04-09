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

  @Test
  void EAST_turnLeft_should_return_NORTH() {
    assertThat(Direction.EAST.turnLeft()).isEqualTo(Direction.NORTH);
  }

  @Test
  void SOUTH_turnLeft_should_return_EAST() {
    assertThat(Direction.SOUTH.turnLeft()).isEqualTo(Direction.EAST);
  }

  @Test
  void WEST_turnLeft_should_return_SOUTH() {
    assertThat(Direction.WEST.turnLeft()).isEqualTo(Direction.SOUTH);
  }

  @Test
  void NORTH_turnLeft_should_return_WEST() {
    assertThat(Direction.NORTH.turnLeft()).isEqualTo(Direction.WEST);
  }

  @Test
  void EAST_turnRight_should_return_SOUTH() {
    assertThat(Direction.EAST.turnRight()).isEqualTo(Direction.SOUTH);
  }

  @Test
  void NORTH_turnRight_should_return_EAST() {
    assertThat(Direction.NORTH.turnRight()).isEqualTo(Direction.EAST);
  }

  @Test
  void WEST_turnRight_should_return_NORTH() {
    assertThat(Direction.WEST.turnRight()).isEqualTo(Direction.NORTH);
  }

  @Test
  void SOUTH_turnRight_should_return_WEST() {
    assertThat(Direction.SOUTH.turnRight()).isEqualTo(Direction.WEST);
  }
}