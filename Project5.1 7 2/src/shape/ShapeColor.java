package shape;

import java.util.Objects;

/**
 * This class represents a color.
 */
public class ShapeColor {

  private int x;
  private int y;
  private int z;

  /**
   * Constructs the Color.
   *
   * @param x red value
   * @param y green value
   * @param z blue value
   */
  public ShapeColor(int x, int y, int z) {
    if (x < 0 && x > 255 && y < 0 && y > 255 && z < 0 && z > 255) {
      throw new IllegalArgumentException("incorrect value for color");
    }
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * Gets the red.
   *
   * @return the amount of red color
   */
  public int getX() {
    return x;
  }

  /**
   * Gets the blue.
   *
   * @return the amount of blue color
   */
  public int getY() {
    return y;
  }

  /**
   * Gets the green.
   *
   * @return the amount of green color
   */
  public int getZ() {
    return z;
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
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShapeColor shapeColor = (ShapeColor) o;
    return Double.compare(shapeColor.x, x) == 0 &&
        Double.compare(shapeColor.y, y) == 0 &&
        Double.compare(shapeColor.z, z) == 0;
  }

  /**
   * Represents the internal memory address of a Color.
   *
   * @return an integer
   */
  @Override
  public int hashCode() {
    return Objects.hash(x, y, z);
  }

  @Override
  public String toString() {
    return "(" + x + " " + y + " " + z + ")";
  }
}