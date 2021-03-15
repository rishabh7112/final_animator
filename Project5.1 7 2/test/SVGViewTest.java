import static org.junit.Assert.assertEquals;

import animator.IMotion;
import animator.Motion;
import cs3500.animator.view.IAnimationView;
import cs3500.animator.view.SVGView;
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
 * tests all the SVG methods.
 */
public class SVGViewTest {

  IShape rectangle = new Rectangle("R", 10.0, 10.0, 2.0, 3.0, 244, 243, 222);
  IShape ellipse = new Oval("C", 4.2, 7.3, 1.0, 4.0, 7, 8, 9);
  IShape rectangle2 = new Rectangle("R2", -11.9, -23.8, 2.0, 3.0, 244, 243, 222);
  IMotion rectangleMotion1 = new Motion(rectangle, 2, 3, new Position(10.0, 10.0),
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

  IAnimationView svgView = new SVGView(model, tempo, a);


  @Test
  public void setTempo() {
    assertEquals(500, tempo);
    svgView.setTempo(1000);
    assertEquals(500, tempo);
    svgView.setTempo(12);
    assertEquals(500, tempo);
  }

  @Test
  public void output() throws IOException {
    model.addShape(rectangle);
    model.addMotion(rectangle, rectangleMotion1);
    assertEquals("<svg width=\"0\" height=\"0\" viewBox=\"0 0 0 0 \" version=\"1.1\"\n"
        + "    xmlns=\"http://www.w3.org/2000/svg\">\n"
        + "<rect id=\"R\" x=\"10.0\" y=\"10.0\" width=\"2.0\" height=\"3.0\" fill=\"rgb"
        + "(244,243,222)\" visibility=\"visible\" >\n"
        + "<animate attributeType=\"xml\" begin=\"4.0ms\" dur=\"2.0ms\" attributeName=\"x\" from="
        + "\"10.0\" to=\"13.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"4.0ms\" dur=\"2.0ms\" attributeName=\"y\" from="
        + "\"10.0\" to=\"14.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"4.0ms\" dur=\"2.0ms\" attributeName=\"width\""
        + " from=\"2.0\" to=\"7.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"4.0ms\" dur=\"2.0ms\" attributeName=\"height\""
        + " from=\"3.0\" to=\"8.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"CSS\" begin=\"4.0ms\" dur=\"2.0ms\" attributeName=\"fill\" "
        + "from=\"rgb(244,243,222)\" to=\"rgb(1,2,3)\" fill=\"freeze\" />\n"
        + "</rect>\n"
        + "</svg>\n", svgView.output());

    model.addShape(rectangle);
    model.addMotion(rectangle, rectangleMotion6);
    model.addMotion(rectangle, rectangleMotion7);
    model.addMotion(rectangle, rectangleMotion8);
    model.addMotion(rectangle, rectangleMotion9);
    model.addMotion(rectangle, rectangleMotion10);

    assertEquals("<svg width=\"0\" height=\"0\" viewBox=\"0 0 0 0 \" version=\"1.1\"\n"
        + "    xmlns=\"http://www.w3.org/2000/svg\">\n"
        + "<rect id=\"R\" x=\"200.0\" y=\"200.0\" width=\"50.0\" height=\"100.0\" fill=\""
        + "rgb(255,0,0)\" visibility=\"visible\" >\n"
        + "<animate attributeType=\"xml\" begin=\"2.0ms\" dur=\"18.0ms\" attributeName=\"x\" from="
        + "\"200.0\" to=\"200.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"2.0ms\" dur=\"18.0ms\" attributeName=\"y\" from="
        + "\"200.0\" to=\"200.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"2.0ms\" dur=\"18.0ms\" attributeName=\"width\" "
        + "from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"2.0ms\" dur=\"18.0ms\" attributeName=\"height\" "
        + "from=\"100.0\" to=\"100.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"CSS\" begin=\"2.0ms\" dur=\"18.0ms\" attributeName=\"fill\" "
        + "from=\"rgb(255,0,0)\" to=\"rgb(255,0,0)\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"20.0ms\" dur=\"80.0ms\" attributeName=\"x\" "
        + "from=\"200.0\" to=\"300.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"20.0ms\" dur=\"80.0ms\" attributeName=\"y\" "
        + "from=\"200.0\" to=\"300.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"20.0ms\" dur=\"80.0ms\" attributeName=\"width\" "
        + "from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"20.0ms\" dur=\"80.0ms\" attributeName=\"height\" "
        + "from=\"100.0\" to=\"100.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"CSS\" begin=\"20.0ms\" dur=\"80.0ms\" attributeName=\"fill\" "
        + "from=\"rgb(255,0,0)\" to=\"rgb(255,0,0)\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"2.0ms\" attributeName=\"x\" from"
        + "=\"300.0\" to=\"300.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"2.0ms\" attributeName=\"y\" from="
        + "\"300.0\" to=\"300.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"2.0ms\" attributeName=\"width\""
        + " from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"2.0ms\" attributeName=\"height\" "
        + "from=\"100.0\" to=\"100.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"CSS\" begin=\"100.0ms\" dur=\"2.0ms\" attributeName=\"fill\" "
        + "from=\"rgb(255,0,0)\" to=\"rgb(255,0,0)\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"102.0ms\" dur=\"38.0ms\" attributeName=\"x\" "
        + "from=\"300.0\" to=\"300.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"102.0ms\" dur=\"38.0ms\" attributeName=\"y\" "
        + "from=\"300.0\" to=\"300.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"102.0ms\" dur=\"38.0ms\" attributeName=\"width\" "
        + "from=\"50.0\" to=\"25.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"102.0ms\" dur=\"38.0ms\" attributeName=\"height\""
        + " from=\"100.0\" to=\"100.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"CSS\" begin=\"102.0ms\" dur=\"38.0ms\" attributeName=\"fill\" "
        + "from=\"rgb(255,0,0)\" to=\"rgb(255,0,0)\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"140.0ms\" dur=\"60.0ms\" attributeName=\"x\""
        + " from=\"300.0\" to=\"200.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"140.0ms\" dur=\"60.0ms\" attributeName=\"y\""
        + " from=\"300.0\" to=\"200.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"140.0ms\" dur=\"60.0ms\" attributeName=\"width\""
        + " from=\"25.0\" to=\"25.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"140.0ms\" dur=\"60.0ms\" attributeName=\"height\""
        + " from=\"100.0\" to=\"100.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"CSS\" begin=\"140.0ms\" dur=\"60.0ms\" attributeName=\"fill\" "
        + "from=\"rgb(255,0,0)\" to=\"rgb(255,0,0)\" fill=\"freeze\" />\n"
        + "</rect>\n"
        + "</svg>\n", svgView.output());

    model.addShape(ellipse);
    model.addMotion(ellipse, ellipseMotion3);
    model.addMotion(ellipse, ellipseMotion4);
    model.addMotion(ellipse, ellipseMotion5);
    model.addMotion(ellipse, ellipseMotion6);
    model.addMotion(ellipse, ellipseMotion7);

    assertEquals("<svg width=\"0\" height=\"0\" viewBox=\"0 0 0 0 \" version=\"1.1\"\n"
        + "    xmlns=\"http://www.w3.org/2000/svg\">\n"
        + "<rect id=\"R\" x=\"200.0\" y=\"200.0\" width=\"50.0\" height=\"100.0\" fill=\"rgb"
        + "(255,0,0)\" visibility=\"visible\" >\n"
        + "<animate attributeType=\"xml\" begin=\"2.0ms\" dur=\"18.0ms\" attributeName=\"x\" "
        + "from=\""
        + "200.0\" to=\"200.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"2.0ms\" dur=\"18.0ms\" attributeName=\"y\" "
        + "from=\""
        + "200.0\" to=\"200.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"2.0ms\" dur=\"18.0ms\" attributeName=\"width\" "
        + "from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"2.0ms\" dur=\"18.0ms\" attributeName=\"height\" "
        + "from=\"100.0\" to=\"100.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"CSS\" begin=\"2.0ms\" dur=\"18.0ms\" attributeName=\"fill\" "
        + "from=\"rgb(255,0,0)\" to=\"rgb(255,0,0)\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"20.0ms\" dur=\"80.0ms\" attributeName=\"x\" "
        + "from=\"200.0\" to=\"300.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"20.0ms\" dur=\"80.0ms\" attributeName=\"y\""
        + " from=\"200.0\" to=\"300.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"20.0ms\" dur=\"80.0ms\" attributeName=\"width\" "
        + "from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"20.0ms\" dur=\"80.0ms\" attributeName=\"height\" "
        + "from=\"100.0\" to=\"100.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"CSS\" begin=\"20.0ms\" dur=\"80.0ms\" attributeName=\"fill\" "
        + "from=\"rgb(255,0,0)\" to=\"rgb(255,0,0)\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"2.0ms\" attributeName=\"x\" "
        + "from=\"300.0\" to=\"300.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"2.0ms\" attributeName=\"y\" "
        + "from=\"300.0\" to=\"300.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"2.0ms\" attributeName=\"width\" "
        + "from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"2.0ms\" attributeName=\"height\" "
        + "from=\"100.0\" to=\"100.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"CSS\" begin=\"100.0ms\" dur=\"2.0ms\" attributeName=\"fill\" "
        + "from=\"rgb(255,0,0)\" to=\"rgb(255,0,0)\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"102.0ms\" dur=\"38.0ms\" attributeName=\"x\" "
        + "from=\"300.0\" to=\"300.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"102.0ms\" dur=\"38.0ms\" attributeName=\"y\" "
        + "from=\"300.0\" to=\"300.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"102.0ms\" dur=\"38.0ms\" attributeName=\"width\" "
        + "from=\"50.0\" to=\"25.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"102.0ms\" dur=\"38.0ms\" attributeName=\"height\""
        + " from=\"100.0\" to=\"100.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"CSS\" begin=\"102.0ms\" dur=\"38.0ms\" attributeName=\"fill\""
        + " from=\"rgb(255,0,0)\" to=\"rgb(255,0,0)\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"140.0ms\" dur=\"60.0ms\" attributeName=\"x\" "
        + "from=\"300.0\" to=\"200.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"140.0ms\" dur=\"60.0ms\" attributeName=\"y\" "
        + "from=\"300.0\" to=\"200.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"140.0ms\" dur=\"60.0ms\" attributeName=\"width\" "
        + "from=\"25.0\" to=\"25.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"140.0ms\" dur=\"60.0ms\" attributeName=\"height\""
        + " from=\"100.0\" to=\"100.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"CSS\" begin=\"140.0ms\" dur=\"60.0ms\" attributeName=\"fill\" "
        + "from=\"rgb(255,0,0)\" to=\"rgb(255,0,0)\" fill=\"freeze\" />\n"
        + "</rect>\n"
        + "<ellipse id=\"C\" cx=\"440.0\" cy=\"70.0\" rx=\"60.0\" ry=\"30.0\" fill=\"rgb(0,0,255)\""
        + " visibility=\"visible\" >\n"
        + "<animate attributeType=\"xml\" begin=\"12.0ms\" dur=\"28.0ms\" attributeName=\"cx\" "
        + "from=\"440.0\" to=\"440.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"12.0ms\" dur=\"28.0ms\" attributeName=\"cy\" "
        + "from=\"70.0\" to=\"70.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"12.0ms\" dur=\"28.0ms\" attributeName=\"rx\""
        + " from=\"60.0\" to=\"60.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"12.0ms\" dur=\"28.0ms\" attributeName=\"ry\" "
        + "from=\"30.0\" to=\"30.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"CSS\" begin=\"12.0ms\" dur=\"28.0ms\" attributeName=\"fill\" "
        + "from=\"rgb(0,0,255)\" to=\"rgb(0,0,255)\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"40.0ms\" dur=\"60.0ms\" attributeName=\"cx\" "
        + "from=\"440.0\" to=\"440.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"40.0ms\" dur=\"60.0ms\" attributeName=\"cy\""
        + " from=\"70.0\" to=\"250.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"40.0ms\" dur=\"60.0ms\" attributeName=\"rx\" "
        + "from=\"60.0\" to=\"60.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"40.0ms\" dur=\"60.0ms\" attributeName=\"ry\" "
        + "from=\"30.0\" to=\"30.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"CSS\" begin=\"40.0ms\" dur=\"60.0ms\" attributeName=\"fill\" "
        + "from=\"rgb(0,0,255)\" to=\"rgb(0,0,255)\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"40.0ms\" attributeName=\"cx\""
        + " from=\"440.0\" to=\"440.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"40.0ms\" attributeName=\"cy\" "
        + "from=\"250.0\" to=\"370.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"40.0ms\" attributeName=\"rx\" "
        + "from=\"60.0\" to=\"60.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"40.0ms\" attributeName=\"ry\" "
        + "from=\"30.0\" to=\"30.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"CSS\" begin=\"100.0ms\" dur=\"40.0ms\" attributeName=\"fill\" "
        + "from=\"rgb(0,0,255)\" to=\"rgb(0,170,85)\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"140.0ms\" dur=\"20.0ms\" attributeName=\"cx\" "
        + "from=\"440.0\" to=\"440.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"140.0ms\" dur=\"20.0ms\" attributeName=\"cy\" "
        + "from=\"370.0\" to=\"370.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"140.0ms\" dur=\"20.0ms\" attributeName=\"rx\" "
        + "from=\"60.0\" to=\"60.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"140.0ms\" dur=\"20.0ms\" attributeName=\"ry\" "
        + "from=\"30.0\" to=\"30.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"CSS\" begin=\"140.0ms\" dur=\"20.0ms\" attributeName=\"fill\" "
        + "from=\"rgb(0,170,85)\" to=\"rgb(0,255,0)\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"160.0ms\" dur=\"40.0ms\" attributeName=\"cx\" "
        + "from=\"440.0\" to=\"440.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"160.0ms\" dur=\"40.0ms\" attributeName=\"cy\" "
        + "from=\"370.0\" to=\"370.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"160.0ms\" dur=\"40.0ms\" attributeName=\"rx\" "
        + "from=\"60.0\" to=\"60.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"160.0ms\" dur=\"40.0ms\" attributeName=\"ry\" "
        + "from=\"30.0\" to=\"30.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"CSS\" begin=\"160.0ms\" dur=\"40.0ms\" attributeName=\"fill\" "
        + "from=\"rgb(0,255,0)\" to=\"rgb(0,255,0)\" fill=\"freeze\" />\n"
        + "</ellipse>\n"
        + "</svg>\n", svgView.output());

  }

  @Test
  public void getTempo() {
    assertEquals(500, svgView.getTempo());
  }
}