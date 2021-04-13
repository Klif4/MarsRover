import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DirectionTest {
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