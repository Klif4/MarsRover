import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CommandTest {

  @Test
  void forward() {
    Command.CommandResponse commandResponse = Command.FORWARD.execute(Direction.SOUTH, new Location(0, 0, new Grid(100, 100)));
    assertThat(commandResponse).isEqualTo(new Command.CommandResponse(Direction.SOUTH, new Location(0, 1, new Grid(100, 100))));
  }

  @Test
  void backward() {
    Command.CommandResponse commandResponse = Command.BACKWARD.execute(Direction.SOUTH, new Location(0, 1, new Grid(100, 100)));
    assertThat(commandResponse).isEqualTo(new Command.CommandResponse(Direction.SOUTH, new Location(0, 0, new Grid(100, 100))));
  }

  @Test
  void SOUTH_left() {
    Command.CommandResponse commandResponse = Command.LEFT.execute(Direction.SOUTH, new Location(0, 0, new Grid(100, 100)));
    assertThat(commandResponse).isEqualTo(new Command.CommandResponse(Direction.EAST, new Location(0, 0, new Grid(100, 100))));
  }

  @Test
  void WEST_left() {
    Command.CommandResponse commandResponse = Command.LEFT.execute(Direction.WEST, new Location(0, 0, new Grid(100, 100)));
    assertThat(commandResponse).isEqualTo(new Command.CommandResponse(Direction.SOUTH, new Location(0, 0, new Grid(100, 100))));
  }

  @Test
  void SOUTH_right() {
    Command.CommandResponse commandResponse = Command.RIGHT.execute(Direction.SOUTH, new Location(0, 0, new Grid(100, 100)));
    assertThat(commandResponse).isEqualTo(new Command.CommandResponse(Direction.WEST, new Location(0, 0, new Grid(100, 100))));
  }

  @Test
  void WEST_right() {
    Command.CommandResponse commandResponse = Command.RIGHT.execute(Direction.WEST, new Location(0, 0, new Grid(100, 100)));
    assertThat(commandResponse).isEqualTo(new Command.CommandResponse(Direction.NORTH, new Location(0, 0, new Grid(100, 100))));
  }
}