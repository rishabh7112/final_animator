import java.util.ArrayList;
import java.util.List;
import animator.IMotion;
import animator.Motion;
import model.BasicAnimatorModel;
import model.IAnimatorModel;
import shape.ShapeColor;
import shape.IShape;
import shape.Oval;
import shape.Position;
import shape.Rectangle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * this class tests all the methods of the BasicAnimatorModel class.
 */
public class BasicAnimatorModelTest {

  IShape rectangle = new Rectangle("R", 10.0, 10.0, 2.0, 3.0, 244, 243, 222);
  IShape ellipse = new Oval("C", 4.2, 7.3, 1.0, 4.0, 7, 8, 9);
  IShape rectangle2 = new Rectangle("R2", -11.9, -23.8, 2.0, 3.0, 244, 243, 222);
  IMotion recatangleMotion1 = new Motion(rectangle, 2, 3, new Position(10.0, 10.0),
      new Position(2.0, 3.0),
      new ShapeColor(244, 243, 222), new Position(13.0, 14.0), new Position(7.0, 8.0),
      new ShapeColor(1, 2, 3));

  IMotion rectangleMotion2 = new Motion(rectangle, 3, 4, new Position(13.0, 14.0),
      new Position(7.0, 8.0),
      new ShapeColor(1, 2, 3), new Position(8.0, 14.0), new Position(7.0, 8.0),
      new ShapeColor(9, 2, 4));


  IMotion rectangleMotion4 = new Motion(rectangle, 2, 5, new Position(13.0, 14.0),
      new Position(7.0, 8.0),
      new ShapeColor(1, 2, 3), new Position(8.0, 14.0), new Position(7.0, 8.0),
      new ShapeColor(9, 2, 4));

  IMotion rectangleMotion5 = new Motion(rectangle, 1, 5, new Position(13.0, 14.0),
      new Position(7.0, 8.0),
      new ShapeColor(1, 2, 3), new Position(8.0, 14.0), new Position(7.0, 8.0),
      new ShapeColor(9, 2, 4));


  IMotion ellipseMotion1 = new Motion(ellipse, 2, 5, new Position(1.0, 10.0),
      new Position(11.0, 2.0),
      new ShapeColor(244, 243, 222), new Position(8.0, 14.0), new Position(7.0, 8.0),
      new ShapeColor(9, 2, 4));

  IMotion ellipseMotion2 = new Motion(ellipse, 5, 12, new Position(1.0, 10.0),
      new Position(11.0, 2.0),
      new ShapeColor(244, 243, 222), new Position(10.0, 14.0), new Position(7.0, 10.0),
      new ShapeColor(1, 2, 4));

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


  IAnimatorModel model = new BasicAnimatorModel();

  int x = 30;
  int y = 40;
  int w = 100;
  int h = 200;


  //tests to see if a shape is properly added to the list
  @Test
  public void addShape() {
    model.addShape(rectangle);
    assertEquals("shape R rectangle\n", model.toString());
    model.addShape(ellipse);
    assertEquals("shape R rectangle\n"
        + "shape C ellipse\n", model.toString());
    model.addShape(rectangle2);
    assertEquals("shape R rectangle\n"
        + "shape C ellipse\n"
        + "shape R2 rectangle\n", model.toString());

    try {
      model.addShape(null);
      fail("Didn't throw any Exceptions");
    } catch (IllegalArgumentException e) {
      assertEquals("shape is null", e.getMessage());
    }

  }


  //tests whether it returns a list of shapes so far
  @Test
  public void copyAllShapes() {
    model.addShape(rectangle);
    model.addShape(ellipse);
    model.copyAllShapes();
    assertEquals("shape R rectangle\n"
        + "shape C ellipse\n", model.toString());
    model.addShape(rectangle2);
    assertEquals("shape R rectangle\n"
        + "shape C ellipse\n"
        + "shape R2 rectangle\n", model.toString());
  }

  //tests if the model is correctly adding the motion of the given shape
  @Test
  public void addMotion() {
    model.addShape(rectangle);
    model.addMotion(rectangle, recatangleMotion1);
    assertEquals("shape R rectangle\n"
            + "motion R 2 10.0 10.0 2.0 3.0 244.0 243.0 222.0     "
            + "3 13.0 14.0 7.0 8.0 1.0 2.0 3.0\n",
        model.toString());

    model.addShape(ellipse);
    model.addMotion(ellipse, ellipseMotion2);
    assertEquals("shape C ellipse\n"
            + "motion C 5 1.0 10.0 11.0 2.0 244.0 243.0 222.0     "
            + "12 10.0 14.0 7.0 10.0 1.0 2.0 4.0\n"
            + "shape R rectangle\n"
            + "motion R 2 10.0 10.0 2.0 3.0 244.0 243.0 222.0     "
            + "3 13.0 14.0 7.0 8.0 1.0 2.0 3.0\n",
        model.toString());

    //tests invariant(1)
    try {
      model.addShape(ellipse);
      model.addMotion(ellipse, recatangleMotion1);
      fail("Didn't throw any exceptions");
    } catch (IllegalArgumentException e) {
      assertEquals("Incorrect Shape/Motion or didn't add any shapes yet", e.getMessage());
    }

    try {
      model.addMotion(null, ellipseMotion2);
      fail("Didn't throw any Exceptions");
    } catch (IllegalArgumentException e) {
      assertEquals("shape is null", e.getMessage());
    }

    try {
      model.addShape(rectangle);
      model.addMotion(rectangle, null);
      fail("Didn't throw any Exceptions");
    } catch (IllegalArgumentException e) {
      assertEquals("motion is null", e.getMessage());
    }
    try {
      model.addMotion(ellipse, recatangleMotion1);
      fail("Didn't throw any exceptions");
    } catch (IllegalArgumentException e) {
      assertEquals("Incorrect Shape/Motion or didn't add any shapes yet", e.getMessage());
    }

    try {
      IMotion rectangleMotion3 = new Motion(rectangle, 5, 2, new Position(13.0, 14.0),
          new Position(7.0, 8.0),
          new ShapeColor(1, 2, 3), new Position(8.0, 14.0), new Position(7.0, 8.0),
          new ShapeColor(9, 2, 4));
      fail("Didn't throw any exceptions");
    } catch (IllegalArgumentException e) {
      assertEquals("End Tick is <= Start Tick", e.getMessage());
    }

    try {
      model.addShape(rectangle);
      model.addMotion(rectangle, recatangleMotion1);
      model.addMotion(rectangle, rectangleMotion2);
      model.addMotion(rectangle, rectangleMotion4);
    } catch (IllegalArgumentException e) {
      assertEquals("Overlapping occured", e.getMessage());
    }

    try {
      model.addShape(rectangle);
      model.addMotion(rectangle, recatangleMotion1);
      model.addMotion(rectangle, rectangleMotion2);
      model.addMotion(rectangle, rectangleMotion5);
    } catch (IllegalArgumentException e) {
      assertEquals("Overlapping occured", e.getMessage());
    }

  }


  //checks if the given shape is outputting the correct motions
  @Test
  public void giveMotion1() {
    model.addShape(rectangle);
    model.addMotion(rectangle, recatangleMotion1);
    model.addMotion(rectangle, rectangleMotion2);

    List<IMotion> motions = new ArrayList<>();
    motions.add(recatangleMotion1);
    motions.add(rectangleMotion2);

    model.addShape(ellipse);
    model.addMotion(ellipse, ellipseMotion1);

    List<IMotion> motions1 = new ArrayList<>();
    motions1.add(ellipseMotion1);

    assertEquals(motions, model.giveMotion(rectangle));
    assertEquals(motions1, model.giveMotion(ellipse));

    try {
      model.giveMotion(null);
      fail("Didn't throw any Exceptions");
    } catch (IllegalArgumentException e) {
      assertEquals("shape is null", e.getMessage());
    }
  }

  //checks if the given shape is outputting the correct motions
  @Test
  public void giveMotion2() {
    model.addShape(rectangle);
    model.addMotion(rectangle, recatangleMotion1);
    model.addMotion(rectangle, rectangleMotion2);

    List<IMotion> motions = new ArrayList<>();
    motions.add(recatangleMotion1);
    motions.add(rectangleMotion2);

    List<IMotion> givenMotion = model.giveMotion(rectangle);
    givenMotion.remove(recatangleMotion1);

    assertEquals(motions, model.giveMotion(rectangle));
  }

  //tests invariant(2)
  @Test
  public void giveMotion3() {
    IAnimatorModel model2 = new BasicAnimatorModel();
    IShape ellipse = new Oval("C", 4.2, 7.3, 1.0, 4.0, 7, 8, 9);
    IMotion ellipseMotion2 = new Motion(ellipse, 5, 12, new Position(1.0, 10.0),
        new Position(11.0, 2.0),
        new ShapeColor(244, 243, 222), new Position(10.0, 14.0), new Position(7.0, 10.0),
        new ShapeColor(1, 2, 4));
    try {
      model2.addMotion(ellipse, ellipseMotion2);
      fail("Didn't throw any exceptions");
    } catch (IllegalArgumentException e) {
      assertEquals("Incorrect Shape/Motion or didn't add any shapes yet", e.getMessage());
    }
  }


  //tests the toString()
  @Test
  public void testToString() {

    model.addShape(rectangle);
    model.addMotion(rectangle, rectangleMotion6);
    model.addMotion(rectangle, rectangleMotion7);
    model.addMotion(rectangle, rectangleMotion8);
    model.addMotion(rectangle, rectangleMotion9);
    model.addMotion(rectangle, rectangleMotion10);

    model.addShape(ellipse);
    model.addMotion(ellipse, ellipseMotion3);
    model.addMotion(ellipse, ellipseMotion4);
    model.addMotion(ellipse, ellipseMotion5);
    model.addMotion(ellipse, ellipseMotion6);
    model.addMotion(ellipse, ellipseMotion7);

    assertEquals("shape C ellipse\n"
            + "motion C 6 440.0 70.0 120.0 60.0 0.0 0.0 255.0     "
            + "20 440.0 70.0 120.0 60.0 0.0 0.0 255.0\n"
            + "motion C 20 440.0 70.0 120.0 60.0 0.0 0.0 255.0     "
            + "50 440.0 250.0 120.0 60.0 0.0 0.0 255.0\n"
            + "motion C 50 440.0 250.0 120.0 60.0 0.0 0.0 255.0    "
            + "70 440.0 370.0 120.0 60.0 0.0 170.0 85.0\n"
            + "motion C 70 440.0 370.0 120.0 60.0 0.0 170.0 85.0     "
            + "80 440.0 370.0 120.0 60.0 0.0 255.0 0.0\n"
            + "motion C 80 440.0 370.0 120.0 60.0 0.0 255.0 0.0     "
            + "100 440.0 370.0 120.0 60.0 0.0 255.0 0.0\n"
            + "shape R rectangle\n"
            + "motion R 1 200.0 200.0 50.0 100.0 255.0 0.0 0.0     "
            + "10 200.0 200.0 50.0 100.0 255.0 0.0 0.0\n"
            + "motion R 10 200.0 200.0 50.0 100.0 255.0 0.0 0.0     "
            + "50 300.0 300.0 50.0 100.0 255.0 0.0 0.0\n"
            + "motion R 50 300.0 300.0 50.0 100.0 255.0 0.0 0.0     "
            + "51 300.0 300.0 50.0 100.0 255.0 0.0 0.0\n"
            + "motion R 51 300.0 300.0 50.0 100.0 255.0 0.0 0.0     "
            + "70 300.0 300.0 25.0 100.0 255.0 0.0 0.0\n"
            + "motion R 70 300.0 300.0 25.0 100.0 255.0 0.0 0.0     "
            + "100 200.0 200.0 25.0 100.0 255.0 0.0 0.0\n",
        model.toString());
  }


  @Test
  public void getX() {
    model.setBounds(x, y, w, h);
    assertEquals(30, model.getX());
  }

  @Test
  public void getY() {
    model.setBounds(x, y, w, h);
    assertEquals(40, model.getY());
  }

  @Test
  public void getW() {
    model.setBounds(x, y, w, h);
    assertEquals(100, model.getW());
  }

  @Test
  public void getH() {
    model.setBounds(x, y, w, h);
    assertEquals(200, model.getH());
  }

  @Test
  public void currentMotions() {
    model.addShape(rectangle);
    model.addMotion(rectangle, rectangleMotion6);
    model.addMotion(rectangle, rectangleMotion7);
    model.addMotion(rectangle, rectangleMotion8);
    model.addMotion(rectangle, rectangleMotion9);
    model.addMotion(rectangle, rectangleMotion10);

    assertEquals(rectangleMotion6, model.currentMotions(rectangle, 5));
    assertEquals(rectangleMotion7, model.currentMotions(rectangle, 40));
    assertEquals(rectangleMotion9, model.currentMotions(rectangle, 53));
  }

  @Test
  public void setBounds() {
    model.setBounds(x, y, w, h);
    assertEquals(30, model.getX());
    assertEquals(40, model.getY());
    assertEquals(100, model.getW());
    assertEquals(200, model.getH());

  }

  @Test
  public void removeShape() {
    model.addShape(rectangle2);
    model.addShape(ellipse);
    assertEquals("shape R2 rectangle\n"
        + "shape C ellipse\n", model.toString());
    model.removeShape(ellipse);
    assertEquals("shape R2 rectangle\n", model.toString());
    model.removeShape(rectangle2);
    assertEquals("", model.toString());
  }

  @Test
  public void removeMotion() {
    model.addShape(rectangle);
    model.addMotion(rectangle, rectangleMotion6);
    assertEquals("shape R rectangle\n"
            + "motion R 1 200.0 200.0 50.0 100.0 255 0 0     10 200.0 200.0 50.0 100.0 255 0 0\n",
        model.toString());

    model.removeMotion(rectangle, rectangleMotion6);
    assertEquals("shape R rectangle\n", model.toString());


  }


}

