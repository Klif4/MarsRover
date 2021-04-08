import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LocationTest {

  @Test
  void translate_south() {
    Location location = new Location(0, 0, new Grid(100, 100));
    location.translate(Direction.SOUTH);
    assertThat(location).isEqualTo(new Location(0, 1, new Grid(100, 100)));
  }

  @Test
  void translate_east() {
    Location location = new Location(0, 0, new Grid(100, 100));
    location.translate(Direction.EAST);
    assertThat(location).isEqualTo(new Location(1, 0, new Grid(100, 100)));
  }

  @Test
  void translate_north() {
    Location location = new Location(0, 10, new Grid(100, 100));
    location.translate(Direction.NORTH);
    assertThat(location).isEqualTo(new Location(0, 9, new Grid(100, 100)));
  }

  @Test
  void translate_west() {
    Location location = new Location(10, 0, new Grid(100, 100));
    location.translate(Direction.WEST);
    assertThat(location).isEqualTo(new Location(9, 0, new Grid(100, 100)));
  }

  @Test
  void translate_north_limit_case() {
    Location location = new Location(0, 0, new Grid(100, 100));
    location.translate(Direction.NORTH);
    assertThat(location).isEqualTo(new Location(0, 0, new Grid(100, 100)));
  }

  @Test
  void translate_west_limit_case() {
    Location location = new Location(0, 0, new Grid(100, 100));
    location.translate(Direction.WEST);
    assertThat(location).isEqualTo(new Location(0, 0, new Grid(100, 100)));
  }

  @Test
  void translate_south_limit_case() {
    Location location = new Location(100, 100, new Grid(100, 100));
    location.translate(Direction.SOUTH);
    assertThat(location).isEqualTo(new Location(100, 100, new Grid(100, 100)));
  }

  @Test
  void translate_east_limit_case() {
    Location location = new Location(100, 100, new Grid(100, 100));
    location.translate(Direction.EAST);
    assertThat(location).isEqualTo(new Location(100, 100, new Grid(100, 100)));
  }

}