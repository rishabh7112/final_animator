package shape;

import java.util.Objects;

/**
 * Represents a shape and its properties.
 */
public abstract class AbstractShape implements IShape {

  protected String name;
  protected double x;
  protected double y;
  protected double w;
  protected double h;
  protected int r;
  protected int g;
  protected int b;


  /**
   * Constucts a shape in an animation.
   *
   * @param name the string representation
   * @param x    the x coordinate
   * @param y    the y coordinate
   * @param w    the width of the shape
   * @param h    the height of the shape
   * @param r    the red value of a color
   * @param g    the green value of a color
   * @param b    the blue value of a color
   */
  AbstractShape(String name, double x, double y, double w, double h, int r, int g, int b) {
    this.name = name;
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.r = r;
    this.g = g;
    this.b = b;
  }

  AbstractShape(String name) {
    this.name = name;
    this.x = 2;
    this.y = 3;
    this.w = 4;
    this.h = 5;
    this.r = 6;
    this.g = 7;
    this.b = 8;
  }

  /**
   * Gets Color of shape.
   */
  @Override
  public ShapeColor getColor() {
    return new ShapeColor(this.r, this.g, this.b);
  }

  /**
   * Sets Color to a new Color.
   */
  @Override
  public ShapeColor setColor(int r, int g, int b) {
    return new ShapeColor(r, g, b);
  }

  /**
   * Gets the position of the shape.
   */
  @Override
  public Position getPosition() {
    return new Position(this.x, this.y);
  }

  /**
   * Sets the new position of the shape.
   */
  @Override
  public Position setPosition(double x, double y) {
    this.x = x;
    this.y = y;

    return new Position(x, y);
  }

  /**
   * Gets the dimensions of the shape.
   */
  @Override
  public Position getSize() {
    return new Position(this.w, this.h);
  }

  /**
   * Sets the new dimensions of the shape.
   */
  @Override
  public Position setSize(double w, double h) {
    return new Position(w, h);
  }

  /**
   * Returns the string name of the shape.
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Compares equality between an object and a given object.
   *
   * @param o an object
   * @return boolean
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }
    AbstractShape that = (AbstractShape) o;
    return Double.compare(that.x, x) == 0 &&
        Double.compare(that.y, y) == 0 &&
        Double.compare(that.w, w) == 0 &&
        Double.compare(that.h, h) == 0 &&
        Double.compare(that.r, r) == 0 &&
        Double.compare(that.g, g) == 0 &&
        Double.compare(that.b, b) == 0 &&
        name.equals(that.name);
  }

  /**
   * Represents the internal memory address of a Shape.
   *
   * @return an integer
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, x, y, w, h, r, g, b);
  }
}
