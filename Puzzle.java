import java.util.Objects;

/**
 * Represents a 6-piece burr puzzle.
 */
public class Puzzle {
  private final Piece[] pieces;

  Puzzle(Piece[] pieces) {
    if (Objects.requireNonNull(pieces).length != 6) {
      throw new IllegalArgumentException("There must be 6 pieces in a puzzle.");
    }
    this.pieces = pieces;
  }

  public boolean[] getFrontLeftValue(int p) {
    boolean[] frontLeft = new boolean[4];
    frontLeft[0] = pieces[p].getCubeValue(0);
    frontLeft[1] = pieces[p].getCubeValue(1);
    frontLeft[2] = pieces[p].getCubeValue(4);
    frontLeft[3] = pieces[p].getCubeValue(5);
    return frontLeft;
  }

  public String[] getFrontLeftName(int p) {
    String[] frontLeft = new String[4];
    frontLeft[0] = pieces[p].getCubeName(0);
    frontLeft[1] = pieces[p].getCubeName(1);
    frontLeft[2] = pieces[p].getCubeName(4);
    frontLeft[3] = pieces[p].getCubeName(5);
    return frontLeft;
  }

  public boolean[] getFrontRightValue(int p) {
    boolean[] frontRight = new boolean[4];
    frontRight[0] = pieces[p].getCubeValue(2);
    frontRight[1] = pieces[p].getCubeValue(3);
    frontRight[2] = pieces[p].getCubeValue(6);
    frontRight[3] = pieces[p].getCubeValue(7);
    return frontRight;
  }

  public String[] getFrontRightName(int p) {
    String[] frontRight = new String[4];
    frontRight[0] = pieces[p].getCubeName(2);
    frontRight[1] = pieces[p].getCubeName(3);
    frontRight[2] = pieces[p].getCubeName(6);
    frontRight[3] = pieces[p].getCubeName(7);
    return frontRight;
  }

  public boolean[] getSideFrontValue(int p) {
    boolean[] sideFront = new boolean[4];
    sideFront[0] = pieces[p].getCubeValue(1);
    sideFront[1] = pieces[p].getCubeValue(2);
    sideFront[2] = pieces[p].getCubeValue(8);
    sideFront[3] = pieces[p].getCubeValue(9);
    return sideFront;
  }

  public String[] getSideFrontName(int p) {
    String[] sideFront = new String[4];
    sideFront[0] = pieces[p].getCubeName(1);
    sideFront[1] = pieces[p].getCubeName(2);
    sideFront[2] = pieces[p].getCubeName(8);
    sideFront[3] = pieces[p].getCubeName(9);
    return sideFront;
  }

  public boolean[] getSideBackValue(int p) {
    boolean[] sideBack = new boolean[4];
    sideBack[0] = pieces[p].getCubeValue(5);
    sideBack[1] = pieces[p].getCubeValue(6);
    sideBack[2] = pieces[p].getCubeValue(10);
    sideBack[3] = pieces[p].getCubeValue(11);
    return sideBack;
  }

  public String[] getSideBackName(int p) {
    String[] sideBack = new String[4];
    sideBack[0] = pieces[p].getCubeName(5);
    sideBack[1] = pieces[p].getCubeName(6);
    sideBack[2] = pieces[p].getCubeName(10);
    sideBack[3] = pieces[p].getCubeName(11);
    return sideBack;
  }
}
