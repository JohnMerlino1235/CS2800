import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    // generate a name for each of the 12 bits of a piece
    String[] p1vars = genVars(1, 12);
    String[] p2vars = genVars(13, 24);
    String[] p3vars = genVars(25, 36);
    String[] p4vars = genVars(37, 48);
    String[] p5vars = genVars(49, 60);
    String[] p6vars = genVars(61, 72);

    // set the 12 boolean values for each piece
    boolean[] p1bits = {false, false, false, false, false, false, false, false, true, true, true, true};
    boolean[] p2bits = {false, false, false, false, false, false, false, false, true, true, true, true};
    boolean[] p3bits = {true, true, true, true, true, true, true, true, true, true, true, true};
    boolean[] p4bits = {false, true, true, false, false, true, true, false, true, true, true, true};
    boolean[] p5bits = {false, false, false, false, false, false, false, false, false, false, true, true};
    boolean[] p6bits = {false, false, false, false, false, false, false, false, false, false, true, true};

    // create the 6 pieces
    Piece p1 = new Piece(p1bits, p1vars);
    Piece p2 = new Piece(p2bits, p2vars);
    Piece p3 = new Piece(p3bits, p3vars);
    Piece p4 = new Piece(p4bits, p4vars);
    Piece p5 = new Piece(p5bits, p5vars);
    Piece p6 = new Piece(p6bits, p6vars);
    Piece[] pieces = {p1, p2, p3, p4, p5, p6};

    Puzzle puzzle = new Puzzle(pieces);

    Generator generator = new Generator(puzzle);

    FileCreator fc = new FileCreator();
    fc.writeFile(generator.genPuzzle());
  }

  private static String[] genVars(int s, int t) {
    String[] vars = new String[12];
    int n = 0;
    for (int i = s; i <= t; i++) {
      vars[n] = String.valueOf(i);
      n++;
    }
    return vars;
  }

}
