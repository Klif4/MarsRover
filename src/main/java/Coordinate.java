import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Coordinate {

  private int value;
  private final int maxValue;

  public Coordinate(int value, int maxValue) {

    this.value = value;
    this.maxValue = maxValue;
  }


  public void incr() {
    value = value == maxValue ? value : value + 1;
  }

  public void decr() {
    value = value == 0 ? value : value -1;
  }
}
