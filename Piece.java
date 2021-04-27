/**
 * Represents a puzzle piece.
 */
public class Piece {
  private final boolean[] bit; // 12 bit num for describing shape of piece
  private final String[] vars;

  Piece(boolean[] bit, String[] vars) {
    this.bit = bit;
    this.vars = vars;
  }

  public boolean getCubeValue(int c) {
    return bit[c];
  }

  public String getCubeName(int c) { return vars[c]; }
}
