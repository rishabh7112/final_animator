import static org.junit.Assert.assertEquals;

import org.junit.Test;
import shape.IShape;
import shape.Oval;
import shape.Rectangle;

/**
 * tests methods of the Oval and Rectangle class.
 */
public class OvalAndRectangleTest {

  IShape oval = new Oval("C", 440, 70, 120, 60, 0, 0, 255);
  IShape rectangle = new Rectangle("R", 200, 200, 50, 100, 255, 0, 0);

  //tests copy method for a shape
  @Test
  public void getCopyTest() {
    assertEquals(new Oval("C", 440, 70, 120, 60, 0, 0, 255), oval.copy());
    assertEquals(new Rectangle("R", 200, 200, 50, 100, 255, 0, 0), rectangle.copy());
  }

  //tests copy method for a shape
  @Test
  public void toStringTest() {
    assertEquals("shape C ellipse", oval.toString());
    assertEquals("shape R rectangle", rectangle.toString());
  }
}
