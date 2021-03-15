package cs3500.animator.view;

import animator.IMotion;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import model.IViewModel;
import shape.IShape;

/**
 * Displays a textual description of the animation.
 */
public class TextualView implements IAnimationView {

  private final IViewModel model;
  private Appendable ap;
  private int tempo;


  /**
   * represents a 1 argument constructor of the cs3500.animator.view class.
   *
   * @param ap is used to render the toString()
   */
  public TextualView(IViewModel model, int tempo, Appendable ap) {
    this.model = model;
    this.ap = ap;
    this.tempo = tempo;
  }


  /**
   * Returns a string representation of a motion and its parameters.
   *
   * @param m the specified motion
   * @return a string
   */
  private String motionHelper(IMotion m) {
    return "motion " + m.getShapeName() + " " + this.speed(m.getStartTick()) + " " + m
        .getStartPosition()
        .getX() + " "
        + m.getStartPosition().getY() + " " + m.getStartSize().getX() + " " + m.getStartSize()
        .getY()
        + " "
        + m.getStartColor().getX() + " " + m.getStartColor().getY() + " " + m.getStartColor().getZ()
        + "     " + this.speed(m.getEndTick()) + " " + m.getEndPosition().getX() + " "
        + m.getEndPosition().getY() + " " + m.getEndSize().getX() + " " + m.getEndSize().getY()
        + " "
        + m.getEndColor().getX() + " " + m.getEndColor().getY() + " " + m.getEndColor().getZ();
  }


  /**
   * Returns the speed of the animation.
   *
   * @param tick the given tick
   * @return a double representation
   */
  private double speed(int tick) {

    return (double) tick / (double) tempo;
  }


  /**
   * Returns the textual form of the animation.
   *
   * @return a string representation
   */
  @Override
  public String output() throws IOException {
    ap.append(
        "canvas " + model.getX() + " " + model.getY() + " " + model.getW() + " " + model.getH()
            + "\n");
    Set<Entry<IShape, List<IMotion>>> set = model.getMap().entrySet();
    IShape shape;
    for (Entry<IShape, List<IMotion>> entry : set) {
      shape = entry.getKey();
      ap.append(shape.toString() + "\n");
      for (IMotion m : entry.getValue()) {
        ap.append(this.motionHelper(m) + "\n");
      }
    }
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
