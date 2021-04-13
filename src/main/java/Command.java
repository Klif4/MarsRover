import java.util.Arrays;
import java.util.function.BiFunction;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

public enum Command {
  FORWARD("f", ((direction, location) -> new CommandResponse(direction, direction.forward().apply(location)))),
  BACKWARD("b", ((direction, location) -> new CommandResponse(direction, direction.backward().apply(location)))),
  LEFT("l", ((direction, location) -> new CommandResponse(direction.turnLeft(), location))),
  RIGHT("r", ((direction, location) -> new CommandResponse(direction.turnRight(), location)));

  private final String code;

  private final BiFunction<Direction, Location, CommandResponse> movingFunction;

  Command(String code, BiFunction<Direction, Location, CommandResponse> movingFunction) {
    this.code = code;
    this.movingFunction = movingFunction;
  }

  public BiFunction<Direction, Location, CommandResponse> movingFunction() {
    return movingFunction;
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
}
