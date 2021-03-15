package cs3500.animator.view;

import animator.IMotion;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import model.IViewModel;
import shape.IShape;
import shape.Oval;
import shape.Position;
import shape.Rectangle;
import shape.ShapeType;
import shape.ShapeColor;

/**
 * Creates a new panel for the visualization of an animation.
 */
public class Panel extends JPanel {

  private IViewModel model;
  private int tick;

  /**
   * Constructs the panel.
   *
   * @param model the model interface
   */
  public Panel(IViewModel model) {
    super();
    setPreferredSize(new Dimension(1000, 1000));
    this.setBackground(Color.WHITE);
    this.model = model;
    tick = 0;
  }

  /**
   * Draws the animation with its position, dimensions, and color.
   *
   * @param g represents Graphic objects
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    /*if(model.getTick() != tick) {
      tick = model.getTick();
    }*/

    for (IShape s : model.copyAllShapes()) {
      IMotion motion1 = model.currentMotions(s, tick);
      if (motion1 == null) {
        continue;
      }
      Position p = motion1.getPositionAt(tick);
      Position size = motion1.getSizeAt(tick);
      ShapeColor c = motion1.getColorAt(tick);

      if (s.getType().equals(ShapeType.RECTANGLE)) {
        IShape newShape = new Rectangle(s.getName(), p.getX(), p.getY(), size.getX(), size.getY(),
            c.getX(), c.getY(), c.getZ());
        newShape.draw(g);
      }

      if (s.getType().equals(ShapeType.OVAL)) {
        IShape newShape = new Oval(s.getName(), p.getX(), p.getY(), size.getX(), size.getY(),
            c.getX(), c.getY(), c.getZ());
        newShape.draw(g);
      }

    }
    tick++;
  }

  //sets the tick of the panel
  public void setTick(int tick) {
    this.tick = tick;
  }

}
