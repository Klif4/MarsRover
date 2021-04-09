import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

public enum Command {
  FORWARD("f", MovingFunctions.forward),
  BACKWARD("b", MovingFunctions.backward),
  LEFT("l", MovingFunctions.left);

  private final String code;
  private final Moving moving;

  Command(String code, Moving test) {

    this.code = code;
    this.moving = test;
  }

  public static Command getByCode(String code) {
    return Arrays.stream(values())
        .filter(command -> command.code.equals(code))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException(code + " is not a command"));
  }

  public CommandResponse execute(Direction direction, Location location) {
    return moving.move(direction, location);
  }

  @FunctionalInterface
  interface Moving {
    CommandResponse move(Direction direction, Location location);
  }

  @AllArgsConstructor
  @EqualsAndHashCode
  public static class CommandResponse {
    public Direction direction;
    public Location location;

    public Direction direction() {
      return direction;
    }

    public Location location() {
      return location;
    }
  }

  private static class MovingFunctions {
    private static final Moving forward = ((direction, location) -> new CommandResponse(direction, direction.forwardLocation(location)));
    private static final Moving backward = ((direction, location) -> new CommandResponse(direction, direction.backwardLocation(location)));
    private static final Moving left = ((direction, location) -> new CommandResponse(direction.toLeft(), location));
  }
}
