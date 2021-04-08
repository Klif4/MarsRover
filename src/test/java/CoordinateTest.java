import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CoordinateTest {

  @Test
  void incr() {
    Coordinate coordinate = new Coordinate(0, 100);
    coordinate.incr();
    assertThat(coordinate).isEqualTo(new Coordinate(1, 100));
  }

  @Test
  void incr_limit() {
    Coordinate coordinate = new Coordinate(100, 100);
    coordinate.incr();
    assertThat(coordinate).isEqualTo(new Coordinate(100, 100));
  }

  @Test
  void decr() {
    Coordinate coordinate = new Coordinate(1, 100);
    coordinate.decr();
    assertThat(coordinate).isEqualTo(new Coordinate(0, 100));
  }

  @Test
  void decr_limit() {
    Coordinate coordinate = new Coordinate(0, 100);
    coordinate.decr();
    assertThat(coordinate).isEqualTo(new Coordinate(0, 100));
  }
}