import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Coordinate {

  private final int value;
  private final int maxValue;

  public Coordinate incr() {
    return value == maxValue ? new Coordinate(value, maxValue) : new Coordinate(value + 1, maxValue);
  }

  public Coordinate decr() {
    return value == 0 ? new Coordinate(value, maxValue) : new Coordinate(value - 1, maxValue);
  }

  public int value() {
    return value;
  }
}
