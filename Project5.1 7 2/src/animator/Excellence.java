package animator;

import animator.util.AnimationReader;
import controller.Controller;
import controller.IController;
import controller.InteractiveController;
import cs3500.animator.view.IAnimationView;
import cs3500.animator.view.IView;
import cs3500.animator.view.ViewFactory;
import cs3500.animator.view.ViewFactory.ViewType;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.BasicAnimatorModel;
import model.IAnimatorModel;

/**
 * Represents the main class that renders the animation.
 */
public final class Excellence {

  static String in;
  static String viewType;
  static String out;
  static int speed = 35;
  static String interactive;
  static FileWriter f;


  /**
   * Renders the appropriate animation.
   * @param args represents the users input
   * @throws IOException when file reader is null
   */
  public static void main(String[] args) throws IOException {
    for (int i = 0; i < args.length - 1; i += 2) {
      switch (args[i]) {
        case "-view":
          viewType = args[i + 1];
          interactive = args[i + 1];
          break;

        case "-in":
          in = args[i + 1];
          break;

        case "-out":
          out = args[i + 1];
          break;

        case "-speed":
          speed = Integer.parseInt(args[i + 1]);
          break;

        default:
          JPanel panel = new JPanel();
          JOptionPane.showMessageDialog(panel, "Invalid input");
          System.exit(0);
      }

    }

    IAnimatorModel m = AnimationReader
        .parseFile(new FileReader(in), new BasicAnimatorModel.Builder());
    IAnimationView view;
    switch (viewType) {

      case "text":
        view = ViewFactory.create(ViewType.TEXTUAL, m, 1000 / speed, System.out);

        break;

      case "svg":
        f = new FileWriter(
            out);
        view = ViewFactory.create(ViewType.SVG, m, 1000 / speed, f);
        break;

      case "visual":
        view = ViewFactory.create(ViewType.VISUAL, m, 1000 / speed, null);
        break;

      case "interactive":
        view = ViewFactory.create(ViewType.INTERACTIVE, m, 1000 / speed, null);
        break;

      default:
        return;
    }

    if (viewType.equals("interactive")) {
      IController controller = new InteractiveController(m, (IView) view);
      controller.run();
    } else {
      IController controller = new Controller(m, view);
      controller.run();
    }
    if (viewType.equals("svg")) {
      f.flush();
      f.close();
    }

  }
}
