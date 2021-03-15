package controller;

import cs3500.animator.view.IAnimationView;
import java.io.IOException;
import model.IAnimatorModel;

/**
 * Represents the controller class of an animation. Mainly produces the string from the output
 * method produced by the SVGView and TextualView. For VisualView it sets the animation visible and
 * runs the timer.
 */

public class Controller implements IController {

  private IAnimationView view;

  /**
   * Constructs the controller of an animation.
   *
   * @param model represents the model of an animation
   * @param view  represents the view of an animation
   */
  public Controller(IAnimatorModel model, IAnimationView view) {
    if (model == null || view == null) {
      throw new IllegalArgumentException("model or view is null");
    }

    this.view = view;
  }


  /**
   * The interactive animation view is executed and outputs the string form of the animation.
   *For VisualView it sets the animation visible and runs the timer.
   * @throws IOException when the appendable is null
   */
  @Override
  public void run() throws IOException {
    view.output();
  }
}

