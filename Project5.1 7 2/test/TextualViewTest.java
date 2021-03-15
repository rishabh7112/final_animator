import static org.junit.Assert.assertEquals;
import animator.IMotion;
import animator.Motion;
import cs3500.animator.view.IAnimationView;
import cs3500.animator.view.TextualView;
import java.io.IOException;
import model.BasicAnimatorModel;
import model.IAnimatorModel;
import org.junit.Test;
import shape.IShape;
import shape.Oval;
import shape.Position;
import shape.Rectangle;
import shape.ShapeColor;

/**
 * tests all the textual view methods.
 */
public class TextualViewTest {

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
  int tempo = 500;
  Appendable a = new StringBuilder();
  IAnimationView textualView = new TextualView(model, tempo, a);
  int x = 30;
  int y = 40;
  int w = 100;
  int h = 200;


  @Test
  public void setTempo() {
    assertEquals(500, tempo);
    textualView.setTempo(1000);
    assertEquals(500, tempo);
    textualView.setTempo(12);
    assertEquals(500, tempo);


  }

  @Test
  public void output() throws IOException {
    model.setBounds(x, y, w, h);
    model.addShape(rectangle);
    model.addMotion(rectangle, rectangleMotion6);
    model.addMotion(rectangle, rectangleMotion7);
    model.addMotion(rectangle, rectangleMotion8);
    model.addMotion(rectangle, rectangleMotion9);
    model.addMotion(rectangle, rectangleMotion10);

    assertEquals("canvas 30 40 100 200\n"
            + "shape R rectangle\n"
            + "motion R 0.002 200.0 200.0 50.0 100.0 255 0 0     "
            + "0.02 200.0 200.0 50.0 100.0 255 0 0\n"
            + "motion R 0.02 200.0 200.0 50.0 100.0 255 0 0     "
            + "0.1 300.0 300.0 50.0 100.0 255 0 0\n"
            + "motion R 0.1 300.0 300.0 50.0 100.0 255 0 0     "
            + "0.102 300.0 300.0 50.0 100.0 255 0 0\n"
            + "motion R 0.102 300.0 300.0 50.0 100.0 255 0 0     "
            + "0.14 300.0 300.0 25.0 100.0 255 0 0\n"
            + "motion R 0.14 300.0 300.0 25.0 100.0 255 0 0     "
            + "0.2 200.0 200.0 25.0 100.0 255 0 0\n",
        textualView.output());

    model.addShape(ellipse);
    model.addMotion(ellipse, ellipseMotion3);
    model.addMotion(ellipse, ellipseMotion4);
    model.addMotion(ellipse, ellipseMotion5);
    model.addMotion(ellipse, ellipseMotion6);
    model.addMotion(ellipse, ellipseMotion7);

    assertEquals("canvas 30 40 100 200\n"
            + "shape R rectangle\n"
            + "motion R 0.002 200.0 200.0 50.0 100.0 255 0 0     "
            + "0.02 200.0 200.0 50.0 100.0 255 0 0\n"
            + "motion R 0.02 200.0 200.0 50.0 100.0 255 0 0     "
            + "0.1 300.0 300.0 50.0 100.0 255 0 0\n"
            + "motion R 0.1 300.0 300.0 50.0 100.0 255 0 0     "
            + "0.102 300.0 300.0 50.0 100.0 255 0 0\n"
            + "motion R 0.102 300.0 300.0 50.0 100.0 255 0 0     "
            + "0.14 300.0 300.0 25.0 100.0 255 0 0\n"
            + "motion R 0.14 300.0 300.0 25.0 100.0 255 0 0    "
            + "0.2 200.0 200.0 25.0 100.0 255 0 0\n"
            + "shape C ellipse\n"
            + "motion C 0.012 440.0 70.0 120.0 60.0 0 0 255     "
            + "0.04 440.0 70.0 120.0 60.0 0 0 255\n"
            + "motion C 0.04 440.0 70.0 120.0 60.0 0 0 255     "
            + "0.1 440.0 250.0 120.0 60.0 0 0 255\n"
            + "motion C 0.1 440.0 250.0 120.0 60.0 0 0 255     "
            + "0.14 440.0 370.0 120.0 60.0 0 170 85\n"
            + "motion C 0.14 440.0 370.0 120.0 60.0 0 170 85     "
            + "0.16 440.0 370.0 120.0 60.0 0 255 0\n"
            + "motion C 0.16 440.0 370.0 120.0 60.0 0 255 0     "
            + "0.2 440.0 370.0 120.0 60.0 0 255 0\n",
        textualView.output());
  }


  @Test
  public void getTempo() {
    assertEquals(500, textualView.getTempo());
  }


}