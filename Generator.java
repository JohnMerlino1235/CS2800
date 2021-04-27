import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Contains methods to generate a boolean expression for a given puzzle to be
 * given to a SAT solver.
 */
public class Generator {
  private Puzzle puzzle;

  public Generator(Puzzle puzzle) {
    this.puzzle = puzzle;
  }

  // compares the left side of p1 to the front side of p2
  public LinkedHashMap<String, Boolean> genLF(int p1, int p2) {
    LinkedHashMap<String, Boolean> expr = new LinkedHashMap<String, Boolean>();
    expr.put(puzzle.getFrontLeftName(p1)[0], puzzle.getFrontLeftValue(p1)[0]);
    expr.put(puzzle.getSideFrontName(p2)[2], puzzle.getSideFrontValue(p2)[2]);
    expr.put(puzzle.getFrontLeftName(p1)[1], puzzle.getFrontLeftValue(p1)[1]);
    expr.put(puzzle.getSideFrontName(p2)[0], puzzle.getSideFrontValue(p2)[0]);
    expr.put(puzzle.getFrontLeftName(p1)[2], puzzle.getFrontLeftValue(p1)[2]);
    expr.put(puzzle.getSideFrontName(p2)[3], puzzle.getSideFrontValue(p2)[3]);
    expr.put(puzzle.getFrontLeftName(p1)[3], puzzle.getFrontLeftValue(p1)[3]);
    expr.put(puzzle.getSideFrontName(p2)[1], puzzle.getSideFrontValue(p2)[1]);
    return expr;
  }

  // compares the left side of p1 to the back side of p2
  public LinkedHashMap<String, Boolean> genLB(int p1, int p2) {
    LinkedHashMap<String, Boolean> expr = new LinkedHashMap<String, Boolean>();
    expr.put(puzzle.getFrontLeftName(p1)[0], puzzle.getFrontLeftValue(p1)[0]);
    expr.put(puzzle.getSideBackName(p2)[3], puzzle.getSideBackValue(p2)[3]);
    expr.put(puzzle.getFrontLeftName(p1)[1], puzzle.getFrontLeftValue(p1)[1]);
    expr.put(puzzle.getSideBackName(p2)[1], puzzle.getSideBackValue(p2)[1]);
    expr.put(puzzle.getFrontLeftName(p1)[2], puzzle.getFrontLeftValue(p1)[2]);
    expr.put(puzzle.getSideBackName(p2)[2], puzzle.getSideBackValue(p2)[2]);
    expr.put(puzzle.getFrontLeftName(p1)[3], puzzle.getFrontLeftValue(p1)[3]);
    expr.put(puzzle.getSideBackName(p2)[0], puzzle.getSideBackValue(p2)[0]);
    return expr;
  }

  // compares the right side of p1 to the front side of p2
  public LinkedHashMap<String, Boolean> genRF(int p1, int p2) {
    LinkedHashMap<String, Boolean> expr = new LinkedHashMap<String, Boolean>();
    expr.put(puzzle.getFrontRightName(p1)[0], puzzle.getFrontRightValue(p1)[0]);
    expr.put(puzzle.getSideFrontName(p2)[1], puzzle.getSideFrontValue(p2)[1]);
    expr.put(puzzle.getFrontRightName(p1)[1], puzzle.getFrontRightValue(p1)[1]);
    expr.put(puzzle.getSideFrontName(p2)[3], puzzle.getSideFrontValue(p2)[3]);
    expr.put(puzzle.getFrontRightName(p1)[2], puzzle.getFrontRightValue(p1)[2]);
    expr.put(puzzle.getSideFrontName(p2)[0], puzzle.getSideFrontValue(p2)[0]);
    expr.put(puzzle.getFrontRightName(p1)[3], puzzle.getFrontRightValue(p1)[3]);
    expr.put(puzzle.getSideFrontName(p2)[2], puzzle.getSideFrontValue(p2)[2]);
    return expr;
  }

  // compares the right side of p1 to the back side of p2
  public LinkedHashMap<String, Boolean> genRB(int p1, int p2) {
    LinkedHashMap<String, Boolean> expr = new LinkedHashMap<String, Boolean>();
    expr.put(puzzle.getFrontRightName(p1)[0], puzzle.getFrontRightValue(p1)[0]);
    expr.put(puzzle.getSideBackName(p2)[0], puzzle.getSideBackValue(p2)[0]);
    expr.put(puzzle.getFrontRightName(p1)[1], puzzle.getFrontRightValue(p1)[1]);
    expr.put(puzzle.getSideBackName(p2)[2], puzzle.getSideBackValue(p2)[2]);
    expr.put(puzzle.getFrontRightName(p1)[2], puzzle.getFrontRightValue(p1)[2]);
    expr.put(puzzle.getSideBackName(p2)[1], puzzle.getSideBackValue(p2)[1]);
    expr.put(puzzle.getFrontRightName(p1)[3], puzzle.getFrontRightValue(p1)[3]);
    expr.put(puzzle.getSideBackName(p2)[3], puzzle.getSideBackValue(p2)[3]);
    return expr;
  }

  // generates a representation of a boolean expression for one instance of the puzzle
  public LinkedHashMap<String, Boolean> genPosition(ArrayList<Integer> position) {
    LinkedHashMap<String, Boolean> expr = new LinkedHashMap<String, Boolean>();
    expr.putAll(genLF(position.get(0), position.get(2)));
    expr.putAll(genRB(position.get(0), position.get(3)));
    expr.putAll(genLB(position.get(1), position.get(2)));
    expr.putAll(genRF(position.get(1), position.get(3)));
    expr.putAll(genLF(position.get(2), position.get(4)));
    expr.putAll(genRB(position.get(2), position.get(5)));
    expr.putAll(genLB(position.get(3), position.get(4)));
    expr.putAll(genRF(position.get(3), position.get(5)));
    expr.putAll(genLF(position.get(4), position.get(0)));
    expr.putAll(genRB(position.get(4), position.get(1)));
    expr.putAll(genLB(position.get(5), position.get(0)));
    expr.putAll(genRF(position.get(5), position.get(1)));
    return expr;
  }

  // generates a representation of a boolean expression for every instance of the puzzle
  public ArrayList<LinkedHashMap<String, Boolean>> genPuzzle() {
    ArrayList<LinkedHashMap<String, Boolean>> expr = new ArrayList<LinkedHashMap<String, Boolean>>();
    int num[] = new int[6];
    for (int i = 0; i < 6; i++) {
      num[i] = i;
    }
    ArrayList<ArrayList<Integer>> permutations = permute(num);
    for (int i = 0; i < permutations.size(); i++) {
      expr.add(new LinkedHashMap<String, Boolean>());
      expr.get(i).putAll(genPosition(permutations.get(i)));
    }
    return expr;
  }

  // generates list of permutations of numbers 1 through 6
  public ArrayList<ArrayList<Integer>> permute(int[] num) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    result.add(new ArrayList<Integer>());
    for (int i = 0; i < num.length; i++) {
      ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
      for (ArrayList<Integer> l : result) {
        for (int j = 0; j < l.size()+1; j++) {
          l.add(j, num[i]);
          ArrayList<Integer> temp = new ArrayList<Integer>(l);
          current.add(temp);
          l.remove(j);
        }
      }
      result = new ArrayList<ArrayList<Integer>>(current);
    }
    return result;
  }
}
