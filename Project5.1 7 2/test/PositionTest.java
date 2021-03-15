import static org.junit.Assert.assertEquals;

import org.junit.Test;
import shape.Position;

/**
 * tests the methods of Position.
 */
public class PositionTest {

  Position posn1 = new Position(200, 200);
  Position posn2 = new Position(200, 200);
  Position posn3 = new Position(0, 200);

  //returns the x and y value
  @Test
  public void getXAndYTest() {
    assertEquals(200, posn1.getX(), 0.0);
    assertEquals(200, posn1.getY(), 0.0);
  }

  //sets the x and y value
  @Test
  public void setXAndYTest() {
    assertEquals(24, posn1.setX(24), 0.0);
    assertEquals(150.8, posn1.setY(150.8), 0.0);
  }

  //tests equals method
  @Test
  public void testEquals() {
    assertEquals(true, posn1.equals(posn2));
    assertEquals(false, posn1.equals(posn3));
  }

  //tests hashCode method
  @Test
  public void testHash() {
    assertEquals(220201921, posn1.hashCode());
    assertEquals(1080624065, posn3.hashCode());
  }

}
