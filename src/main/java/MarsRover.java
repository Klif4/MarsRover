import java.util.Arrays;

public class MarsRover {

  private Location location;
  private Direction direction;

  public MarsRover(Location location, Direction direction) {
    this.location = location;
    this.direction = direction;
  }

  public Location location() {
    return location;
  }

  public void move(String commands) {
    Arrays.stream(commands.split(""))
        .map(Command::getByCode)
        .forEach(this::handleMove);
  }

  public void handleMove(Command command) {
    Command.CommandResponse commandResponse = command.execute(direction, location);
    direction = commandResponse.direction();
    location = commandResponse.location();
  }
}
