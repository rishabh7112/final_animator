package drawing;

import animator.IMotion;
import animator.Motion;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import shape.IShape;
import shape.Position;
import shape.Rectangle;
import shape.ShapeColor;

/**
 * Represents an animation that runs by a buuble sorting algorithm.
 */
public class BubbleSort {

  private FileWriter f = new FileWriter(
      "bubble-sort.txt");


  IShape rect1 = new Rectangle("r1", 400, 100, 30, 75, 255, 51, 51);
  IShape rect2 = new Rectangle("r2", 430, 100, 30, 300, 51, 153, 255);
  IShape rect3 = new Rectangle("r3", 460, 100, 30, 200, 0, 255, 51);
  IShape rect4 = new Rectangle("r4", 490, 100, 30, 100, 255, 255, 0);
  IShape rect5 = new Rectangle("r5", 520, 100, 30, 55,
      102, 102, 102);

  /**
   * Constructs a bubble sort animation.
   *
   * @throws IOException when the file writer is null
   */
  public BubbleSort() throws IOException {
    //created due to the file writer
  }


  /**
   * this is the bubble-sorting algorithim in which it sorts the 5 rectangles accrdingly to its
   * height.
   *
   * @throws IOException if the appendable is null
   */
  public void bubbleSort() throws IOException {

    if (f == null) {
      throw new IOException("file is null");
    }
    List<IShape> arr = new ArrayList<>();

    arr.add(rect1);

    arr.add(rect2);

    arr.add(rect3);

    arr.add(rect4);

    arr.add(rect5);

    f.append(rect1.toString() + "\n");
    f.append(rect2.toString() + "\n");
    f.append(rect3.toString() + "\n");
    f.append(rect4.toString() + "\n");
    f.append(rect5.toString() + "\n");

    int n = arr.size();
    int tick = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (arr.get(j).getSize().getY() > arr.get(j + 1).getSize().getY()) {

          IMotion m1 = new Motion(arr.get(j), tick, tick + 5,
              new Position(arr.get(j).getPosition().getX(),
                  arr.get(j).getPosition().getY()), new Position(arr.get(j).getSize().getX(),
              arr.get(j).getSize().getY()), new ShapeColor(arr.get(j).getColor().getX(),
              arr.get(j).getColor().getY(), arr.get(j).getColor().getZ()),
              new Position(arr.get(j + 1).getPosition().getX(),
                  arr.get(j + 1).getPosition().getY()), new Position(arr.get(j).getSize().getX(),
              arr.get(j).getSize().getY()), new ShapeColor(arr.get(j).getColor().getX(),
              arr.get(j).getColor().getY(), arr.get(j).getColor().getZ()));
          IMotion m2 = new Motion(arr.get(j + 1), tick, tick + 5,
              new Position(arr.get(j + 1).getPosition().getX(),
                  arr.get(j + 1).getPosition().getY()),
              new Position(arr.get(j + 1).getSize().getX(),
                  arr.get(j + 1).getSize().getY()), new ShapeColor(arr.get(j + 1).getColor().getX(),
              arr.get(j + 1).getColor().getY(), arr.get(j + 1).getColor().getZ()),
              new Position(arr.get(j).getPosition().getX(),
                  arr.get(j).getPosition().getY()), new Position(arr.get(j + 1).getSize().getX(),
              arr.get(j + 1).getSize().getY()), new ShapeColor(arr.get(j + 1).getColor().getX(),
              arr.get(j + 1).getColor().getY(), arr.get(j + 1).getColor().getZ()));
          IShape s = arr.get(j);
          IShape s2 = arr.get(j + 1);
          s.setPosition(m1.getEndPosition().getX(), m1.getEndPosition().getY());
          s2.setPosition(m2.getEndPosition().getX(), m2.getEndPosition().getY());
          f.append(m1.toString() + "\n");
          f.append(m2.toString() + "\n");
          IMotion m;
          for (int k = 0; k < arr.size(); k++) {
            if (k != j && k != j + 1) {
              m = new Motion(arr.get(k), tick, tick + 5,
                  new Position(arr.get(k).getPosition().getX(),
                      arr.get(k).getPosition().getY()),
                  new Position(arr.get(k).getSize().getX(),
                      arr.get(k).getSize().getY()), new ShapeColor(arr.get(k).getColor().getX(),
                  arr.get(k).getColor().getY(), arr.get(k).getColor().getZ()),
                  new Position(arr.get(k).getPosition().getX(),
                      arr.get(k).getPosition().getY()), new Position(arr.get(k).getSize().getX(),
                  arr.get(k).getSize().getY()), new ShapeColor(arr.get(k).getColor().getX(),
                  arr.get(k).getColor().getY(), arr.get(k).getColor().getZ()));
              f.append(m.toString() + "\n");

            }

          }

          tick = tick + 5;

          IShape y = arr.remove(j + 1);

          IShape x = arr.remove(j);

          arr.add(j, y);

          arr.add(j + 1, x);

        }
      }
    }
    for (int k = 0; k < arr.size(); k++) {
      IMotion m = new Motion(arr.get(k), tick, tick + 20,
          new Position(arr.get(k).getPosition().getX(),
              arr.get(k).getPosition().getY()),
          new Position(arr.get(k).getSize().getX(),
              arr.get(k).getSize().getY()), new ShapeColor(arr.get(k).getColor().getX(),
          arr.get(k).getColor().getY(), arr.get(k).getColor().getZ()),
          new Position(arr.get(k).getPosition().getX(),
              arr.get(k).getPosition().getY()), new Position(arr.get(k).getSize().getX(),
          arr.get(k).getSize().getY()), new ShapeColor(arr.get(k).getColor().getX(),
          arr.get(k).getColor().getY(), arr.get(k).getColor().getZ()));
      f.append(m.toString() + "\n");
    }

    f.flush();
    f.close();
  }


  //prints the string version of the animation to the bubble-sort.txt file
  public static void main(String[] args) throws IOException {
    BubbleSort b = new BubbleSort();
    b.bubbleSort();
  }

}
