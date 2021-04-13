import java.util.Arrays;
import java.util.function.BiFunction;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

public enum Command {
  FORWARD("f", MovingFunctions.forward),
  BACKWARD("b", MovingFunctions.backward),
  LEFT("l", MovingFunctions.left),
  RIGHT("r", MovingFunctions.right);

  private final String code;

  public BiFunction<Direction, Location, CommandResponse> movingFunction() {
    return movingFunction;
  }

  private final BiFunction<Direction, Location, CommandResponse> movingFunction;

  Command(String code, BiFunction<Direction, Location, CommandResponse> movingFunction) {
    this.code = code;
    this.movingFunction = movingFunction;
  }

  public static Command getByCode(String code) {
    return Arrays.stream(values())
        .filter(command -> command.code.equals(code))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException(code + " is not a command"));
  }

  @AllArgsConstructor
  @EqualsAndHashCode
  public static class CommandResponse {
    public Direction direction;
    public Location location;
  }

  private static class MovingFunctions {
    private static final BiFunction<Direction, Location, CommandResponse> forward = ((direction, location) -> new CommandResponse(direction, direction.forward().apply(location)));
    private static final BiFunction<Direction, Location, CommandResponse> backward = ((direction, location) -> new CommandResponse(direction, direction.backward().apply(location)));
    private static final BiFunction<Direction, Location, CommandResponse> left = ((direction, location) -> new CommandResponse(direction.turnLeft(), location));
    private static final BiFunction<Direction, Location, CommandResponse> right = ((direction, location) -> new CommandResponse(direction.turnRight(), location));
  }
}
