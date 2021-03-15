package model;

import animator.IMotion;
import java.util.List;
import java.util.Map;
import shape.IShape;

/**
 * Represents the readable version of the IAnimatorModel.
 */
public interface IViewModel {

  /**
   * Gives a list of a copy of all shapes.
   *
   * @return a list of shapes
   */

  List<IShape> copyAllShapes();

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

  //gets the tick
  int getTick();
}
