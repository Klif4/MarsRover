import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Grid {

  private final int x;
  private final int y;

  public Grid(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int x() {
    return x;
  }

  public int y() {
    return y;
  }
}
