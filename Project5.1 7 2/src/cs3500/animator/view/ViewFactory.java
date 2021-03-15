package cs3500.animator.view;

import model.IAnimatorModel;

/**
 * Represents the factory method that creates instances of each view class.
 */
public class ViewFactory {


  /**
   * represents each of the views for the game.
   */
  public enum ViewType {
    TEXTUAL, VISUAL, SVG, INTERACTIVE
  }

  /**
   * represents the factory method that creates instances of each view class.
   *
   * @param type represents each type of model that is used for the animation
   * @return IAnimationView an instance of each view class
   */
  public static IAnimationView create(ViewType type, IAnimatorModel m, int tempo, Appendable a) {
    if (type.equals(ViewType.TEXTUAL)) {
      return new TextualView(m, tempo, a);
    }

    if (type.equals(ViewType.SVG)) {
      return new SVGView(m, tempo, a);
    }

    if (type.equals(ViewType.VISUAL)) {
      return new VisualView(m, tempo);
    }

    if (type.equals(ViewType.INTERACTIVE)) {
      return new InteractiveView(m, tempo);
    }
    throw new IllegalArgumentException("invalid view type");
  }
}
