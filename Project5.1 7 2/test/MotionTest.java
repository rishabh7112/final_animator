import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import animator.IMotion;
import animator.Motion;
import org.junit.Test;
import shape.IShape;
import shape.Oval;
import shape.ShapeColor;
import shape.Position;
import shape.Rectangle;

/**
 * Tests all the methods of motion class.
 */
public class MotionTest {

  IMotion motion1 = new Motion(new Rectangle("R", 200, 200, 50, 100, 255, 0, 0),
      1, 10, new Position(200, 200), new Position(50, 100),
      new ShapeColor(255, 0, 0), new Position(200, 200), new Position(50, 100),
      new ShapeColor(255, 0, 0));

  IShape rectangle = new Rectangle("R", 10.0, 10.0, 2.0, 3.0, 244, 243, 222);
  IShape ellipse = new Oval("C", 4.2, 7.3, 1.0, 4.0, 7, 8, 9);


  IMotion motion2 = new Motion(new Rectangle("R", 200, 200, 50, 100, 255, 0, 0),
      1, 1, new Position(200, 200), new Position(50, 100),
      new ShapeColor(255, 0, 0), new Position(200, 200), new Position(50, 100),
      new ShapeColor(255, 0, 0));

  IMotion rectangleMotion6 = new Motion(rectangle, 1, 10, new Position(200.0, 200.0),
      new Position(50.0, 100.0),
      new ShapeColor(255, 0, 0), new Position(200.0, 200.0), new Position(50.0, 100.0),
      new ShapeColor(255, 0, 0));

  IMotion rectangleMotion7 = new Motion(rectangle, 10, 50, new Position(200.0, 200.0),
      new Position(50.0, 100.0),
      new ShapeColor(255, 0, 0), new Position(300.0, 300.0), new Position(50.0, 100.0),
      new ShapeColor(255, 0, 0));

  IMotion rectangleMotion8 = new Motion(rectangle, 50, 51, new Position(300.0, 300.0),
      new Position(50.0, 100.0),
      new ShapeColor(255, 0, 0), new Position(300.0, 300.0), new Position(50.0, 100.0),
      new ShapeColor(255, 0, 0));

  IMotion rectangleMotion9 = new Motion(rectangle, 51, 70, new Position(300.0, 300.0),
      new Position(50.0, 100.0),
      new ShapeColor(255, 0, 0), new Position(300.0, 300.0), new Position(25.0, 100.0),
      new ShapeColor(255, 0, 0));

  IMotion rectangleMotion10 = new Motion(rectangle, 70, 100, new Position(300.0, 300.0),
      new Position(25.0, 100.0),
      new ShapeColor(255, 0, 0), new Position(200.0, 200.0), new Position(25.0, 100.0),
      new ShapeColor(255, 0, 0));

  IMotion ellipseMotion3 = new Motion(ellipse, 6, 20, new Position(440.0, 70.0),
      new Position(120.0, 60.0),
      new ShapeColor(0, 0, 255), new Position(440.0, 70.0), new Position(120.0, 60.0),
      new ShapeColor(0, 0, 255));

  IMotion ellipseMotion4 = new Motion(ellipse, 20, 50, new Position(440.0, 70.0),
      new Position(120.0, 60.0),
      new ShapeColor(0, 0, 255), new Position(440.0, 250.0), new Position(120.0, 60.0),
      new ShapeColor(0, 0, 255));

  IMotion ellipseMotion5 = new Motion(ellipse, 50, 70, new Position(440.0, 250.0),
      new Position(120.0, 60.0),
      new ShapeColor(0, 0, 255), new Position(440.0, 370.0), new Position(120.0, 60.0),
      new ShapeColor(0, 170, 85));

  IMotion ellipseMotion6 = new Motion(ellipse, 70, 80, new Position(440.0, 370.0),
      new Position(120.0, 60.0),
      new ShapeColor(0, 170, 85), new Position(440.0, 370.0), new Position(120.0, 60.0),
      new ShapeColor(0, 255, 0));

  IMotion ellipseMotion7 = new Motion(ellipse, 80, 100, new Position(440.0, 370.0),
      new Position(120.0, 60.0),
      new ShapeColor(0, 255, 0), new Position(440.0, 370.0), new Position(120.0, 60.0),
      new ShapeColor(0, 255, 0));


  //tests the start and end positions of a motion
  //add null cases?
  @Test
  public void getPositionTest() {
    assertEquals(new Position(200, 200), motion1.getStartPosition());
    assertEquals(new Position(200, 200), motion1.getEndPosition());
  }

  //tests the start and end sizes of a motion
  @Test
  public void getSizeTest() {
    assertEquals(new Position(50, 100), motion1.getStartSize());
    assertEquals(new Position(50, 100), motion1.getEndSize());
  }

  //tests the start and end colors of a motion
  @Test
  public void getColorTest() {
    assertEquals(new ShapeColor(255, 0, 0), motion1.getStartColor());
    assertEquals(new ShapeColor(255, 0, 0), motion1.getEndColor());
  }

  //tests the toString output for a motion
  @Test
  public void toStringTest() {
    assertEquals(
        "motion R 1 200.0 200.0 50.0 100.0 255 0 0     "
            + "10 200.0 200.0 50.0 100.0 255 0 0",
        motion1.toString());

  }

  //tests getPositionAtTest
  @Test
  public void getPositionAtTest() {
    assertEquals(new Position(200, 200), motion1.getPositionAt(1));

    assertEquals("(200.0 200.0)", motion1.getPositionAt(5).toString());

    assertEquals("(205.0 205.0)", rectangleMotion7.getPositionAt(12).toString());
    assertEquals("(297.5 297.5)", rectangleMotion7.getPositionAt(49).toString());
    assertEquals("(200.0 200.0)", rectangleMotion7.getPositionAt(10).toString());
    assertEquals("(300.0 300.0)", rectangleMotion7.getPositionAt(50).toString());

    try {
      rectangleMotion7.getPositionAt(51);
      fail("Didn't throw Exceptions!");
    } catch (IllegalArgumentException e) {
      assertEquals("invalid tick", e.getMessage());
    }

    try {
      rectangleMotion7.getPositionAt(9);
      fail("Didn't throw Exceptions!");
    } catch (IllegalArgumentException e) {
      assertEquals("invalid tick", e.getMessage());
    }

    try {
      motion2.getPositionAt(1);
      fail("Didn't throw Exceptions!");
    } catch (IllegalArgumentException e) {
      assertEquals("end tick - start tick = 0", e.getMessage());
    }

  }

  //tests getSizeAtTest
  @Test
  public void getSizeAtTest() {
    assertEquals(new Position(50, 100), motion1.getSizeAt(1));

    assertEquals("(50.0 100.0)", rectangleMotion9.getSizeAt(51).toString());
    assertEquals("(25.0 100.0)", rectangleMotion9.getSizeAt(70).toString());
    assertEquals("(30.263157894736842 100.0)", rectangleMotion9.getSizeAt(66).toString());
    assertEquals("(48.68421052631579 99.99999999999999)",
        rectangleMotion9.getSizeAt(52).toString());


    try {
      rectangleMotion9.getSizeAt(71);
      fail("Didn't throw Exceptions!");
    } catch (IllegalArgumentException e) {
      assertEquals("invalid tick", e.getMessage());
    }

    try {
      rectangleMotion9.getSizeAt(50);
      fail("Didn't throw Exceptions!");
    } catch (IllegalArgumentException e) {
      assertEquals("invalid tick", e.getMessage());
    }

    try {
      motion2.getSizeAt(1);
      fail("Didn't throw Exceptions!");
    } catch (IllegalArgumentException e) {
      assertEquals("end tick - start tick = 0", e.getMessage());
    }
  }

  //tests getColorAtTest
  @Test
  public void getColorAtTest() {
    assertEquals(new ShapeColor(255, 0, 0), motion1.getColorAt(1));

    assertEquals("(0 0 255)", ellipseMotion5.getColorAt(50).toString());
    assertEquals("(0 170 85)", ellipseMotion5.getColorAt(70).toString());
    assertEquals("(0 136 119)", ellipseMotion5.getColorAt(66).toString());
    assertEquals("(0 17 238)",
        ellipseMotion5.getColorAt(52).toString());


    try {
      ellipseMotion5.getColorAt(71);
      fail("Didn't throw Exceptions!");
    } catch (IllegalArgumentException e) {
      assertEquals("invalid tick", e.getMessage());
    }

    try {
      ellipseMotion5.getColorAt(49);
      fail("Didn't throw Exceptions!");
    } catch (IllegalArgumentException e) {
      assertEquals("invalid tick", e.getMessage());
    }

    try {
      motion2.getColorAt(1);
      fail("Didn't throw Exceptions!");
    } catch (IllegalArgumentException e) {
      assertEquals("end tick - start tick = 0", e.getMessage());
    }
  }

}
