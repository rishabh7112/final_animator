package cs3500.animator.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import model.IViewModel;

/**
 * Represents the visual view of an animation.
 */
public class VisualView extends JFrame implements IAnimationView {

  protected Panel panel;
  private int tempo;
  private int delay;

  /**
   * Constructs the visual view implementation.
   *
   * @param delay the speed of the animation
   */
  public VisualView(IViewModel model, int delay) {
    super();
    this.setTempo(delay);
    this.setTitle("Shapes");
    this.delay = delay;
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(new Dimension(1300, 800));

    //use a border layout with drawing panel in center and button panel in south
    this.setLayout(new BorderLayout());
    panel = new Panel(model);
    panel.setPreferredSize(new Dimension(1000, 800));
    JScrollPane scroller = new JScrollPane(panel);
    this.add(scroller, BorderLayout.CENTER);
    setResizable(false);

    /*new Timer(delay, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        panel.repaint();
      }
    }).start();*/

  }

  /**
   * Adjust the tempo of the animation.
   *
   * @param tempo an integer representation
   */
  @Override
  public void setTempo(int tempo) {
    if (tempo == 0) {
      throw new IllegalArgumentException("tempo is 0");
    }
    this.tempo = tempo;
  }

  /**
   * Returns the output of the animation.
   *
   * @return a string representation
   */
  @Override
  public String output() {
    setVisible(true);
    new Timer(delay, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("hi");
        panel.repaint();
      }
    }).start();

    return null;
  }


  //gets the tempo/delay
  @Override
  public int getTempo() {
    return tempo;
  }
}
