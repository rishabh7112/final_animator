import controller.Controller;
import controller.IController;
import cs3500.animator.view.IAnimationView;
import java.io.IOException;
import model.BasicAnimatorModel;
import model.IAnimatorModel;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * tests the methods in the Controller class.
 */
public class ControllerTest {

  /**
   * it represents the mock view which will be used in testing the controller.
   */
  public class MockView implements IAnimationView {

    StringBuilder log = new StringBuilder();

    /**
     * 1 argument constructor for the mick view.
     *
     * @param log used to see which method was called in the controller
     */
    MockView(StringBuilder log) {
      this.log = log;
    }


    @Override
    public void setTempo(int tempo) {
      //isn't needed to test the controller
    }

    /**
     * Doesn't return a string, instead the log appends a string in order to make sure it is
     * called.
     *
     * @return a blank string
     * @throws IOException if the appendable is null
     */
    @Override
    public String output() throws IOException {
      log.append("output method called");
      return "";
    }

    @Override
    public int getTempo() {
      return 0;
    }
  }


  IAnimatorModel model = new BasicAnimatorModel();

  StringBuilder log = new StringBuilder();

  IAnimationView mockView = new MockView(log);

  IController c = new Controller(model, mockView);


  StringBuilder log2 = null;

  IAnimationView mockView2 = new MockView(log);

  IController c2 = new Controller(model, mockView);


  //tests the run method of the controller
  @Test
  public void run() throws IOException {
    c.run();
    assertEquals("output method called", log.toString());

    try {
      c.run();
      fail("Didn't throw any exceptions");
    } catch (IOException e) {
      assertEquals("Appendable is null", e.getMessage());
    }
  }
}
