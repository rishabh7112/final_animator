package shape;

import java.awt.Graphics;

/**
 * Represents the shapes of an animation.
 */
public interface IShape {

  /**
   * Returns a copy of a shape.
   *
   * @return an IShape
   */
  IShape copy();

  /**
   * Gets the color of a shape.
   *
   * @return Color
   */
  ShapeColor getColor();

  /**
   * Sets the color of a shape.
   *
   * @param r red int val
   * @param g green int val
   * @param b blue int val
   * @return a Color
   */
  ShapeColor setColor(int r, int g, int b);

  /**
   * Gets the position of a shape.
   *
   * @return position
   */
  Position getPosition();

  /**
   * Sets the position of a shape.
   *
   * @param x x coordinate
   * @param y y coordinate
   * @return a Position
   */
  Position setPosition(double x, double y);

  /**
   * Gets the dimensions of a shape.
   *
   * @return position
   */
  Position getSize();

  /**
   * Sets the dimensions of a shape.
   *
   * @param w coordinate
   * @param h coordinate
   * @return a Position
   */
  Position setSize(double w, double h);

  /**
   * Returns the string representation of a shape.
   *
   * @return String
   */
  String getName();

  ///////////////////////rishabh/////////////////////////////
  ShapeType getType();

  ///////////////////////rishabh/////////////////////////////
  void draw(Graphics g);
}
