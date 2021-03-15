package animator;

import shape.ShapeColor;
import shape.IShape;
import shape.Position;

/**
 * Represents a motion in an animation.
 *
 * @param <K> represents a comparable motion
 */
public interface IMotion<K> {

  /**
   * Returns the name of the animations shape.
   */
  String getShapeName();

  /**
   * Gets the shape type.
   *
   * @return the type
   */
  IShape getShape();

  /**
   * Gets the time the animation begins.
   *
   * @return start tick
   */
  int getStartTick();

  /**
   * Gets the time the animation ends.
   *
   * @return end tick
   */
  int getEndTick();

  /**
   * Gets the start position of the animations shape.
   *
   * @return the start position
   */

  Position getStartPosition();

  /**
   * Gets the start size of the animations shape.
   *
   * @return the start size
   */
  Position getStartSize();

  /**
   * Gets the start color of the animations shape.
   *
   * @return the start color
   */
  ShapeColor getStartColor();

  /**
   * Gets the end position of the animations shape.
   *
   * @return the end position
   */
  Position getEndPosition();

  /**
   * Gets the end size of the animations shape.
   *
   * @return the end size
   */
  Position getEndSize();

  /**
   * Gets the end color of the animations shape.
   *
   * @return the end color
   */
  ShapeColor getEndColor();

  Position getPositionAt(int tick);

  Position getSizeAt(int tick);

  ShapeColor getColorAt(int tick);

  String toString();

}
