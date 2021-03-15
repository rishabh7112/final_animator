package cs3500.animator.view;

import java.io.IOException;

/**
 * represents the the interface of the cs3500.animator.view for animations.
 */

public interface IAnimationView {

  /**
   * Adjust the tempo of the animation.
   *
   * @param tempo an integer representation
   */
  void setTempo(int tempo);

  /**
   * Returns the output of the animation.
   *
   * @return a string representation
   */
  String output() throws IOException;

  //gets the tempo
  int getTempo();


}
