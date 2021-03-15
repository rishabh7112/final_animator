package animator;

import shape.ShapeColor;
import shape.IShape;
import shape.Position;

/**
 * Represents a shape's motion.
 */
public class Motion extends ShapeAnimation<IShape> {

  private Position startPoistion;
  private Position startSize;
  private ShapeColor startShapeColor;
  private Position endPosition;
  private Position endSize;
  private ShapeColor endShapeColor;

  /**
   * Constructs the motion.
   *
   * @param shape           the shape type
   * @param startTick       the start time of the animation
   * @param endTick         the end time of the animation
   * @param startPosition   the start position of the animation
   * @param startSize       the start size of the animation
   * @param startShapeColor the start color of the animation
   * @param endPosition     the end position of the animation
   * @param endSize         the end size of the animation
   * @param endShapeColor   the end color of the animation
   */
  public Motion(IShape shape, int startTick, int endTick, Position startPosition,
      Position startSize,
      ShapeColor startShapeColor, Position endPosition, Position endSize,
      ShapeColor endShapeColor) {
    super(shape, startTick, endTick);
    this.startPoistion = startPosition;
    this.startSize = startSize;
    this.startShapeColor = startShapeColor;
    this.endPosition = endPosition;
    this.endSize = endSize;
    this.endShapeColor = endShapeColor;
  }

  /**
   * Gets the start position of the animations shape.
   *
   * @return the start position
   */
  @Override
  public Position getStartPosition() {
    return startPoistion;
  }

  /**
   * Gets the start size of the animations shape.
   *
   * @return the start size
   */
  @Override
  public Position getStartSize() {
    return startSize;
  }

  /**
   * Gets the start color of the animations shape.
   *
   * @return the start color
   */
  @Override
  public ShapeColor getStartColor() {
    return startShapeColor;
  }

  /**
   * Gets the end position of the animations shape.
   *
   * @return the end position
   */
  @Override
  public Position getEndPosition() {
    return endPosition;
  }

  /**
   * Gets the end size of the animations shape.
   *
   * @return the end size
   */
  @Override
  public Position getEndSize() {
    return endSize;
  }

  /**
   * Gets the end color of the animations shape.
   *
   * @return the end color
   */
  @Override
  public ShapeColor getEndColor() {
    return endShapeColor;
  }

  /**
   * Returns the position of an animation at a given tick.
   *
   * @param tick the current tick
   * @return a position
   */
  @Override
  public Position getPositionAt(int tick) {
    if (getEndTick() - getStartTick() == 0) {
      throw new IllegalArgumentException("end tick - start tick = 0");
    }
    if (tick < getStartTick() || tick > getEndTick()) {
      throw new IllegalArgumentException("invalid tick");
    }
    double a = 1.0 * (getEndTick() - tick) / (getEndTick() - getStartTick());
    double b = 1.0 * (tick - getStartTick()) / (getEndTick() - getStartTick());
    return new Position(((getStartPosition().getX() * a) + (getEndPosition().getX() * b)),
        ((getStartPosition().getY() * a) + (getEndPosition().getY() * b)));
  }

  /**
   * Returns the dimensions of an animation as a position at a given tick.
   *
   * @param tick the current tick
   * @return a position
   */
  @Override
  public Position getSizeAt(int tick) {
    if (getEndTick() - getStartTick() == 0) {
      throw new IllegalArgumentException("end tick - start tick = 0");
    }
    if (tick < getStartTick() || tick > getEndTick()) {
      throw new IllegalArgumentException("invalid tick");
    }
    double a = 1.0 * (getEndTick() - tick) / (getEndTick() - getStartTick());
    double b = 1.0 * (tick - getStartTick()) / (getEndTick() - getStartTick());
    return new Position(((getStartSize().getX() * a) + (getEndSize().getX() * b)),
        ((getStartSize().getY() * a) + (getEndSize().getY() * b)));
  }

  /**
   * Returns the color of an animation at a given tick.
   *
   * @param tick the current tick
   * @return a shapes color
   */
  @Override
  public ShapeColor getColorAt(int tick) {
    if (getEndTick() - getStartTick() == 0) {
      throw new IllegalArgumentException("end tick - start tick = 0");
    }
    if (tick < getStartTick() || tick > getEndTick()) {
      throw new IllegalArgumentException("invalid tick");
    }
    float a = (float) ((getEndTick() - tick)) / (float) ((getEndTick() - getStartTick()));
    float b = (float) ((tick - getStartTick())) / (float) ((getEndTick() - getStartTick()));
    float x = ((getStartColor().getX() * a) + (getEndColor().getX() * b));
    float y = ((getStartColor().getY() * a) + (getEndColor().getY() * b));
    float z = ((getStartColor().getZ() * a) + (getEndColor().getZ() * b));
    return new ShapeColor((int) x, (int) y, (int) z);
  }


  /**
   * represents the toString version of the motion.
   *
   * @return the string version of the motion
   */
  @Override
  public String toString() {
    return "motion " + this.getShapeName() + " " + this.getStartTick() + " " + (int) this
        .getStartPosition().getX() + " " + (int) this.startPoistion.getY() + " "
        + (int) this.startSize.getX()
        + " " + (int) this.startSize.getY() + " " + this.getStartColor().getX() + " " + this
        .getStartColor().getY() + " " +
        this.getStartColor().getZ() + "     " + this.getEndTick() + " " + (int) this
        .getEndPosition()
        .getX() + " " + (int) this
        .getEndPosition().getY() + " " +
        (int) this.getEndSize().getX() + " " + (int) this.getEndSize().getY() + " " + this
        .getEndColor().getX()
        + " " + this.getEndColor().getY() + " " + this.getEndColor().getZ();
  }
}