import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MarsRoverTest {

  @Test
  void should_forward_1_step_to_south() {
    // Given
    MarsRover marsRover = new MarsRover(new Location(0, 0, new Grid(100, 100)), Direction.SOUTH);

    // When
    marsRover.move("f");

    // Then
    Location expected = new Location(0, 1, new Grid(100, 100));
    assertThat(marsRover.location()).isEqualTo(expected);
  }

  @Test
  void should_forward_1_step_to_east() {
    // Given
    MarsRover marsRover = new MarsRover(new Location(0, 0, new Grid(100, 100)), Direction.EAST);

    // When
    marsRover.move("f");

    // Then
    Location expected = new Location(1, 0, new Grid(100, 100));
    assertThat(marsRover.location()).isEqualTo(expected);
  }

  @Test
  void should_backward_1_step_to_east() {
    // Given
    MarsRover marsRover = new MarsRover(new Location(0, 0, new Grid(100, 100)), Direction.WEST);

    // When
    marsRover.move("b");

    // Then
    Location expected = new Location(1, 0, new Grid(100, 100));
    assertThat(marsRover.location()).isEqualTo(expected);
  }

  @Test
  void should_forward_1_step_and_backward_1_step() {
    // Given
    MarsRover marsRover = new MarsRover(new Location(0, 0, new Grid(100, 100)), Direction.SOUTH);

    // When
    marsRover.move("fb");

    // Then
    Location expected = new Location(0, 0, new Grid(100, 100));
    assertThat(marsRover.location()).isEqualTo(expected);
  }

  @Test
  void turn_left() {
    // Given
    MarsRover marsRover = new MarsRover(new Location(0, 0, new Grid(100, 100)), Direction.SOUTH);

    // When
    marsRover.move("lf");

    // Then
    Location expected = new Location(1, 0, new Grid(100, 100));
    assertThat(marsRover.location()).isEqualTo(expected);
  }

  @Test
  void turn_right() {
    // Given
    MarsRover marsRover = new MarsRover(new Location(0, 0, new Grid(100, 100)), Direction.NORTH);

    // When
    marsRover.move("rf");

    // Then
    Location expected = new Location(1, 0, new Grid(100, 100));
    assertThat(marsRover.location()).isEqualTo(expected);
  }
}