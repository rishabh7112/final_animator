package cs3500.animator.view;

import java.awt.event.ActionListener;

/**
 * Represents the interface for an interactive view.
 */

public interface IView extends IAnimationView, ActionListener {

  /**
   * Represents changing/setting event handlers.
   *
   * @param listner the event handler inputted
   */
  void setActionListener(ActionListener listner);

  /**
   * Displays the visual representation of the animation.
   */
  void makeVisible();

  /**
   * sets the tick of the animation.
   *
   * @param tick represents the ticks of the animation
   */
  void setTick(int tick);
}
