package shape;

import java.util.Objects;

/**
 * This class represents a 2D position.
 */
public final class Position {

  private double x;
  private double y;

  /**
   * Initialize this object to the specified position.
   *
   * @param x x coordinate
   * @param y y coordinate
   */
  public Position(double x, double y) {
    this.setX(x);
    this.setY(y);
  }

  /**
   * Sets a position.
   *
   * @param v a position
   */
  public Position(Position v) {
    this.setX(v.x);
    this.setY(v.y);
  }

  /**
   * get the x coordinate of this position.
   *
   * @return double
   */
  public double getX() {
    return x;
  }

  /**
   * get the y coordinate of this position.
   *
   * @return double
   */
  public double getY() {
    return y;
  }

  /**
   * Set the x coordinate of this object.
   *
   * @param x given double val
   * @return double
   */
  public double setX(double x) {
    this.x = x;
    return x;
  }

  /**
   * Set the y coordiante of this object.
   *
   * @param y given y val
   * @return double
   */
  public double setY(double y) {
    this.y = y;
    return y;
  }

  /**
   * Compares equality between an object and a given object.
   *
   * @param a an object
   * @return boolean
   */
  @Override
  public boolean equals(Object a) {
    if (this == a) {
      return true;
    }
    if (!(a instanceof Position)) {
      return false;
    }

    Position that = (Position) a;

    return ((Math.abs(this.x - that.x) < 0.01)
        && (Math.abs(this.y - that.y) < 0.01));
  }


  /**
   * Represents the internal memory address of a Position.
   *
   * @return an integer
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.x, this.y);
  }

  @Override
  public String toString() {
    return "(" + x + " " + y + ")";
  }
}