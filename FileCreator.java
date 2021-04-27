import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Creates a file containing the generated
 */
public class FileCreator {
  public void writeFile(ArrayList<LinkedHashMap<String, Boolean>> expr) throws IOException {
    FileWriter writer = new FileWriter("generator-output.txt");
    for (LinkedHashMap<String, Boolean> h : expr) {
      writer.write(h.toString());
      writer.write("\n");
    }
    writer.close();
  }
}
