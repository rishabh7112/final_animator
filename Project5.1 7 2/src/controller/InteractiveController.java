package controller;

import cs3500.animator.view.IView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import model.IAnimatorModel;

/**
 * Represents the controller of the interactive animation. It also implements the ActionListener in
 * order to register button clicks from user. Each button click will alter how the timer operates.
 */
public class InteractiveController implements IController, ActionListener {

  private IView view;
  private Timer t;

  /**
   * Constructs the interactive animation controller.
   *
   * @param model represents the animations model
   * @param view  represents the view of the animation
   */
  public InteractiveController(IAnimatorModel model, IView view) {
    if (model == null || view == null) {
      throw new IllegalArgumentException("model or view is null");
    }

    this.view = view;
    this.t = new Timer(view.getTempo(), new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        view.actionPerformed(e);
        //model.incrementTick();
      }
    });
  }

  /**
   * sets the the ActionListner and makes the panel visible.
   */
  @Override
  public void run() {
    this.view.setActionListener(this);
    this.view.makeVisible();
  }


  /**
   * changes the animation accordingly by each button click.
   *
   * @param e the button that was clicked by the user
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    String s = e.getActionCommand();

    switch (s) {
      case "start button":
        t.start();
        break;
      case "pause button":
        t.stop();
        break;
      case "resume button":
        if (t.isRunning()) {
          break;
        }
        t.start();
        break;
      case "restart button":
        view.setTick(0);
        t.start();
        break;
      default:
        return;
    }
  }
}


