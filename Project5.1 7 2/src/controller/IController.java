package controller;

import java.io.IOException;

/**
 * Represents the interface of the controller classes. Uses the run method to execute and render the
 * appropriate animation.
 */
public interface IController {

  /**
   * The interactive animation view is executed and outputs the string form of the animation. For
   * VisualView it sets the animation visible and runs the timer.
   *
   * @throws IOException when the appendable is null
   */
  void run() throws IOException;
}
