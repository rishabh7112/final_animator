import static org.junit.Assert.assertEquals;

import org.junit.Test;
import shape.ShapeColor;

/**
 * tests the methods of the Color class.
 */
public class ShapeColorTest {

  ShapeColor red = new ShapeColor(255, 0, 0);
  ShapeColor green = new ShapeColor(0, 255, 0);
  ShapeColor blue = new ShapeColor(0, 0, 255);

  //tests the getter methods of Color
  @Test
  public void getRbgValTest() {
    assertEquals(255, red.getX(), 0.0);
    assertEquals(0, red.getY(), 0.0);
    assertEquals(0, red.getZ(), 0.0);
    assertEquals(0, green.getX(), 0.0);
    assertEquals(255, green.getY(), 0.0);
    assertEquals(0, green.getZ(), 0.0);
    assertEquals(0, blue.getX(), 0.0);
    assertEquals(0, blue.getY(), 0.0);
    assertEquals(255, blue.getZ(), 0.0);
  }


}
