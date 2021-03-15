package cs3500.animator.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.IViewModel;

/**
 * Represents a visualisation of an animation in which the user and program are interactive. The way
 * it's interactive is that users have access to 4 buttons that can start,resume, pause, and restart
 * the animation.
 */
public class InteractiveView extends VisualView implements IView {

  private JButton startButton;
  private JButton resumeButton;
  private JButton pauseButton;
  private JButton restartButton;

  /**
   * Constructs the visual view implementation.
   *
   * @param model represents the model
   * @param delay the speed of the animation
   */
  public InteractiveView(IViewModel model, int delay) {
    super(model, delay);

    JPanel panel = new JPanel();
    startButton = new JButton("start");
    startButton.setActionCommand("start button");
    panel.add(startButton);
    resumeButton = new JButton("resume");
    resumeButton.setActionCommand("resume button");
    panel.add(resumeButton);
    pauseButton = new JButton("pause");
    pauseButton.setActionCommand("pause button");
    panel.add(pauseButton);
    restartButton = new JButton("restart");
    restartButton.setActionCommand("restart button");
    panel.add(restartButton);
    this.add(panel, BorderLayout.EAST);
    this.setVisible(false);
  }

  /**
   * Represents changing/setting event handlers.
   *
   * @param listner the event handler inputted
   */
  public void setActionListener(ActionListener listner) {
    if (listner == null) {
      throw new IllegalArgumentException("listner is null");
    }

    startButton.addActionListener(listner);
    resumeButton.addActionListener(listner);
    pauseButton.addActionListener(listner);
    restartButton.addActionListener(listner);

  }

  /**
   * Displays the visual representation of the animation.
   */
  @Override
  public void makeVisible() {
    this.setVisible(true);
  }

  /**
   * sets the tick of the animation.
   *
   * @param tick represents the ticks of the animation
   */
  @Override
  public void setTick(int tick) {
    panel.setTick(tick);
  }


  /**
   * Invoked when an action occurs (start, resume, pause, restart). It creates the appropriate
   * shapes and motions.
   *
   * @param e the inputted action
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    this.panel.repaint();
  }
}
