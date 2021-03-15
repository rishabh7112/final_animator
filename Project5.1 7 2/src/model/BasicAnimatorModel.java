package model;

import animator.IMotion;
import animator.Motion;
import animator.util.AnimationBuilder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import shape.ShapeColor;
import shape.IShape;
import shape.Oval;
import shape.Position;
import shape.Rectangle;


/**
 * Represents a model for the animation. This is where all the shapes and motions are stored in a
 * map and are used to complete the functionalities given by the interface.
 */
public class BasicAnimatorModel implements IAnimatorModel {

  private int x;
  private int y;
  private int w;
  private int h;
  private int tick;

  //gets the x coordinate of canvas
  public int getX() {
    return x;
  }

  //gets the y coordinate of canvas
  public int getY() {
    return y;
  }

  //gets the width coordinate of canvas
  public int getW() {
    return w;
  }

  //gets the height coordinate of canvas
  public int getH() {
    return h;
  }

  /**
   * Gets the shape given the name.
   *
   * @param shapeName the name of the shape
   * @return shape given the name
   */
  @Override
  public IShape getShape(String shapeName) {
    IShape shape = null;
    for (IShape s : map.keySet()) {
      if (shapeName.equals(s.getName())) {
        shape = s;
        break;
      }

    }
    return shape;
  }

  @Override
  public int getTick() {
    return tick;
  }


  /**
   * This class is used to read the animations and build the animation accordingly to the
   * AnimationBuilder.
   */
  public static final class Builder implements AnimationBuilder<IAnimatorModel> {

    IAnimatorModel b = new BasicAnimatorModel();

    //returns the model to be built
    @Override
    public IAnimatorModel build() {
      return b;
    }

    /**
     * Sets the bounds of the canvas.
     *
     * @param x      The leftmost x value
     * @param y      The topmost y value
     * @param width  The width of the bounding box
     * @param height The height of the bounding box
     * @return the canvas to be rendered
     */
    @Override
    public AnimationBuilder<IAnimatorModel> setBounds(int x, int y, int width, int height) {
      b.setBounds(x, y, width, height);
      return this;
    }

    /**
     * Adds the shape accordingly to the given type to the animation.
     *
     * @param name The unique name of the shape to be added. No shape with this name should already
     *             exist.
     * @param type The type of shape (e.g. "ellipse", "rectangle") to be added. The set of supported
     *             shapes is unspecified, but should include "ellipse" and "rectangle" as a
     *             minimum.
     * @return an added shape to the animation
     */
    @Override
    public AnimationBuilder<IAnimatorModel> declareShape(String name, String type) {
      if (type.equals("rectangle")) {
        b.addShape(new Rectangle(name));

      } else if (type.equals("ellipse")) {
        b.addShape(new Oval(name));
      }

      return this;
    }

    /**
     * Adds the motion accordingly to the given parameters to the animation.
     *
     * @param name The name of the shape (added with {@link AnimationBuilder#declareShape})
     * @param t1   The start time of this transformation
     * @param x1   The initial x-position of the shape
     * @param y1   The initial y-position of the shape
     * @param w1   The initial width of the shape
     * @param h1   The initial height of the shape
     * @param r1   The initial red color-value of the shape
     * @param g1   The initial green color-value of the shape
     * @param b1   The initial blue color-value of the shape
     * @param t2   The end time of this transformation
     * @param x2   The final x-position of the shape
     * @param y2   The final y-position of the shape
     * @param w2   The final width of the shape
     * @param h2   The final height of the shape
     * @param r2   The final red color-value of the shape
     * @param g2   The final green color-value of the shape
     * @param b2   The final blue color-value of the shape
     * @return an added motion by the given parameters for the animation
     */
    @Override
    public AnimationBuilder<IAnimatorModel> addMotion(String name, int t1, int x1, int y1, int w1,
        int h1, int r1, int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2,
        int b2) {

      b.addMotion(b.getShape(name),
          new Motion(b.getShape(name), t1, t2, new Position(x1, y1), new Position(w1, h1),
              new ShapeColor(r1, g1, b1),
              new Position(x2, y2), new Position(w2, h2), new ShapeColor(r2, g2, b2)));
      return this;
    }

  }


  private Map<IShape, List<IMotion>> map;
  //INVARIANT(1): The motions associated with the shape is specific to that shape
  //INVARIANT(2): Must add a shape in the animation before adding motions to it


  /**
   * Represents a 2 argument constructor for the basic animator model.
   *
   * @param los represents the list of shapes
   * @param lom represents the list of motions that are associated with the shapes
   */

  public BasicAnimatorModel(ArrayList<IShape> los, ArrayList<IMotion> lom) {
    this.map = new LinkedHashMap<>();
    for (IShape shape : los) {
      map.put(shape, new ArrayList<>());
    }

    for (IMotion motion : lom) {
      this.addMotion(motion.getShape(), motion);
    }
  }

  /**
   * Represents the zero argument constructor for the basic animator model where we set the list of
   * IShapes and IMotion to empty lists.
   */
  public BasicAnimatorModel() {
    this(new ArrayList<>(), new ArrayList<>());
  }

  /**
   * Adds the shape to the animation.
   *
   * @param shape the shape that is going to be added.
   */
  @Override
  public void addShape(IShape shape) {
    if (shape == null) {
      throw new IllegalArgumentException("shape is null");
    }
    map.put(shape.copy(), new ArrayList<>());
  }

  /**
   * Gives a list of a copy of all shapes.
   *
   * @return a list of shapes
   */
  @Override
  public List<IShape> copyAllShapes() {
    List losCopy = new ArrayList();
    Set<IShape> set = map.keySet();
    List<IShape> shapes = new ArrayList<>(set);
    //Arrays.asList((IShape[]) set.toArray());
    for (int i = 0; i < map.keySet().size(); i++) {
      losCopy.add(shapes.get(i).copy());
    }
    return losCopy;
  }


  /**
   * Add motions/animations to a specific shape.
   *
   * @param shape       the given shape whose motion is going to be added
   * @param givenMotion the motion that is being added
   */
  @Override
  public void addMotion(IShape shape, IMotion givenMotion)
      throws IllegalArgumentException {

    if (shape == null) {
      throw new IllegalArgumentException("shape is null");
    }
    if (givenMotion == null) {
      throw new IllegalArgumentException("motion is null");
    }

    if (map.containsKey(shape) && givenMotion.getShape().equals(shape)) {
      throwExceptionOverlap(shape, givenMotion);
      map.get(shape).add(givenMotion);

    } else {
      throw new IllegalArgumentException("Incorrect Shape/Motion or didn't add any shapes yet");
    }
  }

  /**
   * Gives a list of motion from a shape.
   *
   * @param s represents the shape
   * @return the list of motion
   */
  @Override
  public List<IMotion> giveMotion(IShape s) {
    if (s == null) {
      throw new IllegalArgumentException("shape is null");
    }
    return new ArrayList<>(map.get(s));
  }

  //Overlap method that goes thru list of motions
  //if same time and ticks same overthrow
  //helper method
  private void throwExceptionOverlap(IShape shape, IMotion givenMotion)
      throws IllegalArgumentException {
    if (shape == null) {
      throw new IllegalArgumentException("shape is null");
    }

    if (givenMotion == null) {
      throw new IllegalArgumentException("motion is null");
    }
    List<IMotion> motions = map.get(shape);

    for (IMotion m : motions) {
      if ((givenMotion.getStartTick() >= m.getStartTick() && givenMotion.getStartTick() < m
          .getEndTick())
          || (givenMotion.getEndTick() >= m.getStartTick() && givenMotion.getEndTick() <= m
          .getEndTick())) {
        throw new IllegalArgumentException("Overlapping occured");
      }
    }
  }

  /**
   * Represents a list of motions for a particular shape at a certain tick.
   *
   * @param shape represents the shape
   * @param tick  represents the specific time at which we are trying to get the motions
   * @return a list of motions for a particular shape at a certain tick
   */
  @Override
  public IMotion currentMotions(IShape shape, int tick) {
    for (IMotion m : map.get(shape)) {
      if (tick >= m.getStartTick() && tick < m.getEndTick()) {
        return m;
      }
    }
    return null;
  }

  //gets the map of shapes and their associated list of motions
  @Override
  public Map<IShape, List<IMotion>> getMap() {
    return map;
  }

  //represents the string form of model
  @Override
  public String toString() {
    Set<Entry<IShape, List<IMotion>>> set = map.entrySet();
    IShape shape;
    StringBuilder builder = new StringBuilder();
    for (Entry<IShape, List<IMotion>> entry : set) {
      shape = entry.getKey();
      builder.append(shape.toString() + "\n");
      for (IMotion m : entry.getValue()) {
        builder.append(m.toString() + "\n");
      }
    }
    return builder.toString();
  }

  /**
   * Sets the x,y,width,height of the canvas.
   *
   * @param p1 x coordinate
   * @param p2 y coordinate
   * @param p3 width
   * @param p4 height
   */
  @Override
  public void setBounds(int p1, int p2, int p3, int p4) {
    x = p1;
    y = p2;
    w = p3;
    h = p4;
  }

  /**
   * Removes a shape from the animation.
   *
   * @param shape represents the shape to be removed
   */
  @Override
  public void removeShape(IShape shape) {
    if (shape == null) {
      throw new IllegalArgumentException("shape is null");
    }
    map.remove(shape.copy(), new ArrayList<>());
  }

  /**
   * Removes the motion from the animation.
   *
   * @param shape       the shape with the given motion
   * @param givenMotion the motion to be removed
   */
  @Override
  public void removeMotion(IShape shape, IMotion givenMotion) {
    if (shape == null) {
      throw new IllegalArgumentException("shape is null");
    }
    if (givenMotion == null) {
      throw new IllegalArgumentException("motion is null");
    }

    if (map.containsKey(shape) && givenMotion.getShape().equals(shape)) {
      throwExceptionOverlap(shape, givenMotion);
      map.get(shape).remove(givenMotion);

    } else {
      throw new IllegalArgumentException("Incorrect Shape/Motion or didn't add any shapes yet");
    }
  }
}