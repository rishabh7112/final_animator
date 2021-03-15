package shape;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Represent a type of Shape (Rectangle).
 */
public class Rectangle extends AbstractShape {

  /**
   * Construct a Rectangle.
   *
   * @param name the string representation of a rectangle
   * @param x    x coordinate
   * @param y    y coordinate
   * @param w    width
   * @param h    height
   * @param r    red val
   * @param g    green val
   * @param b    blue val
   */
  public Rectangle(String name, double x, double y, double w, double h, int r, int g,
      int b) {
    super(name, x, y, w, h, r, g, b);
  }

  public Rectangle(String name) {
    super(name);
  }

  /**
   * Provides a copy of a Rectangle.
   *
   * @return IShape
   */
  public IShape copy() {
    return new Rectangle(this.name, this.x, this.y, this.w, this.h, this.r, this.g, this.b);
  }

  @Override
  public ShapeType getType() {
    return ShapeType.RECTANGLE;
  }

  @Override
  public void draw(Graphics g) {
    g.setColor(new Color(this.r, this.g, this.b));
    g.fillRect((int) this.x, (int) this.y, (int) this.w, (int) this.h);

  }


  /**
   * Returns a string representation of a Rectangle.
   *
   * @return String
   */
  public String toString() {
    return "shape " + this.getName() + " rectangle";
  }
}
