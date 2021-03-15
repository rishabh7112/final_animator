import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import controller.IController;
import controller.InteractiveController;
import cs3500.animator.view.IView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import model.BasicAnimatorModel;
import model.IAnimatorModel;


/**
 * tests all the function of the InteractiveController class.
 */
public class InteractiveControllerTest {

  /**
   * it represents the mock view which will be used in testing the interactive controller.
   */
  public class MockView implements IView {

    StringBuilder log = new StringBuilder();

    /**
     * 1 argument constructor for the mick view.
     *
     * @param log used to see which method was called in the interactive controller
     */
    MockView(StringBuilder log) {
      this.log = log;
    }

    //checks if this method is called
    @Override
    public void setActionListener(ActionListener listner) {

      log.append("setActionListner called\n");
    }

    //checks if this method is called
    @Override
    public void makeVisible() {
      log.append("makeVisible called\n");
    }

    //checks if this method is called
    @Override
    public void setTick(int tick) {
      log.append("setTick method called\n" + " " + tick);
    }

    @Override
    public void setTempo(int tempo) {
      //isn't needed to test the controller
    }

    //checks if this method is called
    @Override
    public String output() throws IOException {
      return "output method";
    }

    @Override
    public int getTempo() {
      return 0;
    }

    //checks if this method is called
    @Override
    public void actionPerformed(ActionEvent e) {
      log.append("actionPerfomed method called");
    }
  }

  /**
   * represents a mock class for the ActionEvent. This is used to test the actionPerformed method.
   */
  public class MockActionEvent extends ActionEvent {

    /**
     * 3 argument constructor of ActionEvent.
     *
     * @param source  the button
     * @param id the identification of an ActionEvent
     * @param command the button command
     */
    public MockActionEvent(Object source, int id, String command) {
      super(source, id, command);
    }

    /**
     * this is the button that is being tested as a view function is called when this command in
     * invoked.
     *
     * @return the restart button command string
     */
    @Override
    public String getActionCommand() {
      return "restart button";
    }
  }

  StringBuilder log = new StringBuilder();
  IView mockView = new MockView(log);
  IAnimatorModel model = new BasicAnimatorModel();
  IController c = new InteractiveController(model, mockView);

  //tests the run method of the controller
  @Test
  public void run() throws IOException {
    c.run();
    assertEquals("setActionListner called\n"
        + "makeVisible called\n", log.toString());

    try {
      c.run();
      fail("Didn't throw any exceptions");
    } catch (IOException e) {
      assertEquals("Appendable is null", e.getMessage());
    }
  }

  //tests the actionPerformed method of interactive controller
  @Test
  public void actionPerformed() {
    JButton b = new JButton();
    MockActionEvent m = new MockActionEvent(b, 12, "restart button");
    ((InteractiveController) c).actionPerformed(m);
    assertTrue(log.toString().contains("setTick method called\n 0"));
  }
}