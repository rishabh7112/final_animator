package model;

import animator.IMotion;
import java.util.List;
import java.util.Map;
import shape.IShape;


/**
 * The model for an animation: this maintains the state and enforces the rules of the animation.
 * This interface has all the necessary functionalities to bring the animation to life.
 */
public interface IAnimatorModel extends IViewModel {

  /**
   * Adds the shape to the animation.
   *
   * @param shape the shape that is going to be added
   */
  void addShape(IShape shape);


  /**
   * Gives a list of a copy of all shapes.
   *
   * @return a list of shapes
   */

  List<IShape> copyAllShapes();

  /**
   * Add motions/animations to a specific shape.
   *
   * @param shape       the given shape whose motion is going to be added
   * @param givenMotion the motion that is being added
   */

  void addMotion(IShape shape, IMotion givenMotion);


  /**
   * Gives a list of motion from a shape.
   *
   * @param s represents the shape
   * @return the list of motion
   */

  List<IMotion> giveMotion(IShape s);

  //Gets the map
  Map<IShape, List<IMotion>> getMap();


  /**
   * Represents a list of motions for a particular shape at a certain tick.
   *
   * @param shape represents the shape
   * @param tick  represents the specific time at which we are trying to get the motions
   * @return a list of motions for a particular shape at a certain tick
   */
  IMotion currentMotions(IShape shape, int tick);


  /**
   * Sets the x,y,width,height of the canvas.
   *
   * @param p1 x coordinate
   * @param p2 y coordinate
   * @param p3 width
   * @param p4 height
   */
  void setBounds(int p1, int p2, int p3, int p4);

  //gets the x coordinate of canvas
  int getX();

  //gets the y coordinate of canvas
  int getY();

  //gets the width coordinate of canvas
  int getW();

  //gets the height coordinate of canvas
  int getH();

  /**
   * Gets the shape given the name.
   *
   * @param shapeName the name of the shape
   * @return shape given the name
   */

  IShape getShape(String shapeName);

  /**
   * Removes a shape from the animation.
   *
   * @param shape represents the shape to be removed
   */
  void removeShape(IShape shape);

  /**
   * Removes the motion from the animation.
   *
   * @param shape       the shape with the given motion
   * @param givenMotion the motion to be removed
   */
  void removeMotion(IShape shape, IMotion givenMotion);

  //represents the string form of model
  String toString();

  //gets the tick
  int getTick();

}

