package cs3500.animator.view;

import animator.IMotion;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import model.IViewModel;
import shape.IShape;
import shape.ShapeType;

/**
 * Returns a textual description of the animation that is compliant with the popular SVG file
 * format.
 */
public class SVGView implements IAnimationView {

  private Appendable ap;
  private final IViewModel model;
  private int tempo;

  /**
   * Constucts the SVG output representation of the animation.
   *
   * @param ap represents an appendable
   */

  public SVGView(IViewModel model, int tempo, Appendable ap) {
    this.model = model;
    this.ap = ap;
    this.tempo = tempo;
  }


  /**
   * helper for returning the svg representation for motion.
   *
   * @param type represents the shape type
   * @param m    represents the motion of shape
   * @return the svg representation of motion
   */
  private String out(ShapeType type, IMotion m) {
    String s = "";
    String attributeNameX = "";
    String attributeNamey = "";
    String attributeNameW = "";
    String attributeNameH = "";
    int radiusDivisor = 0;

    if (type.equals(ShapeType.RECTANGLE)) {
      attributeNameX = "x";
      attributeNamey = "y";
      attributeNameW = "width";
      attributeNameH = "height";
      radiusDivisor = 1;
    }

    if (type.equals(ShapeType.OVAL)) {
      attributeNameX = "cx";
      attributeNamey = "cy";
      attributeNameW = "rx";
      attributeNameH = "ry";
      radiusDivisor = 2;

    }

    s += "<animate attributeType=\"xml\" begin=\""
        + ((double) m.getStartTick() / (double) tempo) * 1000
        + "ms\" dur=\""
        +
        (((double) (m.getEndTick() - m.getStartTick())) / (double) tempo) * 1000
        + "ms\" attributeName=\"" + attributeNameX + "\" from=\"" + m.getStartPosition().getX()
        + "\" " + "to=\"" + m.getEndPosition().getX()
        + "\" fill=\"freeze\" />\n";

    s += "<animate attributeType=\"xml\" begin=\""
        + ((double) m.getStartTick() / (double) tempo) * 1000
        + "ms\" dur=\""
        +
        (((double) (m.getEndTick() - m.getStartTick())) / (double) tempo) * 1000
        + "ms\" attributeName=\"" + attributeNamey + "\" from=\"" + m.getStartPosition().getY()
        + "\" " + "to=\"" + m.getEndPosition().getY()
        + "\" fill=\"freeze\" />\n";

    s += "<animate attributeType=\"xml\" begin=\""
        + ((double) m.getStartTick() / (double) tempo) * 1000
        + "ms\" dur=\""
        +
        (((double) (m.getEndTick() - m.getStartTick())) / (double) tempo) * 1000
        + "ms\" attributeName=\"" + attributeNameW + "\" from=\""
        + m.getStartSize().getX() / radiusDivisor
        + "\" " + "to=\"" + m.getEndSize().getX() / radiusDivisor
        + "\" fill=\"freeze\" />\n";

    s += "<animate attributeType=\"xml\" begin=\""
        + ((double) m.getStartTick() / (double) tempo) * 1000
        + "ms\" dur=\""
        +
        (((double) (m.getEndTick() - m.getStartTick())) / (double) tempo) * 1000
        + "ms\" attributeName=\"" + attributeNameH + "\" from=\""
        + m.getStartSize().getY() / radiusDivisor
        + "\" " + "to=\"" + m.getEndSize().getY() / radiusDivisor
        + "\" fill=\"freeze\" />\n";

    s += "<animate attributeType=\"CSS\" begin=\""
        + ((double) m.getStartTick() / (double) tempo) * 1000
        + "ms\" dur=\""
        +
        (((double) (m.getEndTick() - m.getStartTick())) / (double) tempo) * 1000
        + "ms\" attributeName=\"fill\" from=\"rgb(" + m.getStartColor().getX() + "," + m
        .getStartColor().getY() + "," + m.getStartColor().getZ() + ")\" " + "to=\"rgb(" + m
        .getEndColor()
        .getX() + "," + m.getEndColor()
        .getY() + "," + m.getEndColor()
        .getZ() + ")\" fill=\"freeze\" />\n";

    return s;
  }

  /**
   * Returns the svg representation of an animation.
   *
   * @return the svg representation of an animation
   */
  @Override
  public String output() throws IOException {
    String s = "";

    s += "<svg width=\"" + model.getW() + "\" height=\"" + model.getH() + "\" viewBox=\"" + model
        .getX() + " " + model.getY() + " " + model.getW() + " " + model.getH() + " "
        + "\" version=\"1.1\"\n"
        + "    xmlns=\"http://www.w3.org/2000/svg\">";
    ap.append(s + "\n");
    s = "";
    Set<Entry<IShape, List<IMotion>>> set = model.getMap().entrySet();
    IShape shape;
    for (Entry<IShape, List<IMotion>> entry : set) {
      shape = entry.getKey();
      if (shape.getType().equals(ShapeType.RECTANGLE)) {
        IMotion m = model.giveMotion(shape).get(0);
        s += "<rect id=\"" + shape.getName() + "\" x=\"" + m.getStartPosition().getX() + "\" y=\""
            + m.getStartPosition().getY()
            + "\" width=\"" + m.getStartSize().getX() + "\" height=\"" + m.getStartSize().getY()
            + "\" fill=\"rgb("
            + m.getStartColor().getX() + ","
            + m.getStartColor().getY() + "," + m.getStartColor().getZ()
            + ")\" visibility=\"visible\" >";
      }

      if (shape.getType().equals(ShapeType.OVAL)) {
        IMotion m = model.giveMotion(shape).get(0);
        s += "<ellipse id=\"" + shape.getName() + "\" cx=\"" + m.getStartPosition().getX()
            + "\" cy=\"" + m.getStartPosition().getY()
            + "\" rx=\"" + m.getStartSize().getX() / 2 + "\" ry=\"" + m.getStartSize().getY() / 2
            + "\" fill=\"rgb(" + m.getStartColor().getX() + ","
            + m.getStartColor().getY() + "," + m.getStartColor().getZ()
            + ")\" visibility=\"visible\" >";
      }
      ap.append(s + "\n");
      s = "";
      for (IMotion m : entry.getValue()) {
        s += out(shape.getType(), m);
      }

      if (shape.getType().equals(ShapeType.RECTANGLE)) {
        s += "</rect>";
        ap.append(s + "\n");
        s = "";
      }

      if (shape.getType().equals(ShapeType.OVAL)) {
        s += "</ellipse>";
        ap.append(s + "\n");
        s = "";
      }
    }
    s += "</svg>";
    ap.append(s + "\n");
    s = "";
    return ap.toString();
  }

  /**
   * Adjust the tempo of the animation.
   *
   * @param tempo an integer representation
   */
  public void setTempo(int tempo) {
    if (tempo == 0) {
      tempo = 1;
    }
    this.tempo = tempo;
  }


  //gets the tempo
  public int getTempo() {
    return tempo;
  }


}
