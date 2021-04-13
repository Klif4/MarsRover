import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

public enum Command {
  FORWARD("f", MovingFunctions.forward),
  BACKWARD("b", MovingFunctions.backward),
  LEFT("l", MovingFunctions.left),
  RIGHT("r", MovingFunctions.right);

  private final String code;
  private final Moving moving;

  Command(String code, Moving moving) {
    this.code = code;
    this.moving = moving;
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
  }

  private static class MovingFunctions {
    private static final Moving forward = ((direction, location) -> new CommandResponse(direction, direction.forward().apply(location)));
    private static final Moving backward = ((direction, location) -> new CommandResponse(direction, direction.backward().apply(location)));
    private static final Moving left = ((direction, location) -> new CommandResponse(direction.turnLeft(), location));
    private static final Moving right = ((direction, location) -> new CommandResponse(direction.turnRight(), location));
  }
}
