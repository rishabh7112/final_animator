package animator;

import shape.IShape;

/**
 * An abstract class for implementations of an IMotion.
 *
 * @param <K> comparable
 */
public abstract class ShapeAnimation<K> implements IMotion<K> {

  protected IShape shape;
  protected int startTick;
  protected int endTick;

  /**
   * Constructs an animation.
   *
   * @param shape     the shape in the animation
   * @param startTick the start time of the animation
   * @param endTick   the end time of the animation
   */
  public ShapeAnimation(IShape shape, int startTick, int endTick) {
    this.shape = shape;
    if (startTick > endTick) {
      throw new IllegalArgumentException("End Tick is <= Start Tick");
    }
    this.startTick = startTick;
    this.endTick = endTick;
  }

  /**
   * Returns the name of the animations shape.
   */
  @Override
  public String getShapeName() {
    return this.shape.getName();
  }

  /**
   * Gets the shape type.
   *
   * @return the type
   */
  @Override
  public IShape getShape() {
    return shape;
  }

  /**
   * Gets the time the animation begins.
   *
   * @return start tick
   */
  @Override
  public int getStartTick() {
    return startTick;
  }

  /**
   * Gets the time the animation ends.
   *
   * @return end tick
   */
  @Override
  public int getEndTick() {
    return endTick;
  }
}
