package shape;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Represent a type of Shape (Oval).
 */
public class Oval extends AbstractShape {


  /**
   * Construct an Oval.
   *
   * @param name the string representation of an oval
   * @param x    x coordinate
   * @param y    y coordinate
   * @param w    width
   * @param h    height
   * @param r    red val
   * @param g    green val
   * @param b    blue val
   */
  public Oval(String name, double x, double y, double w, double h, int r, int g, int b) {
    super(name, x, y, w, h, r, g, b);
  }

  public Oval(String name) {
    super(name);
  }

  /**
   * Provides a copy of an Oval.
   *
   * @return IShape
   */
  @Override
  public IShape copy() {
    return new Oval(this.name, this.x, this.y, this.w, this.h, this.r, this.g, this.b);
  }

  /**
   * Returns a string representation of an Oval.
   *
   * @return String
   */
  public String toString() {
    return "shape " + this.getName() + " ellipse";
  }

  @Override
  public ShapeType getType() {
    return ShapeType.OVAL;
  }

  @Override
  public void draw(Graphics g) {
    g.setColor(new Color(this.r, this.g, this.b));
    g.fillOval((int) this.x, (int) this.y, (int) this.w, (int) this.h);
  }
}
