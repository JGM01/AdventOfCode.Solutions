import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class Day02A {
    public static void main(String[] args) {
        try (var br = new BufferedReader(new FileReader("input.txt"))) {
            List<String> input = br.lines().toList();
            int horizontal = 0, depth = 0;
            for (int i = 0; i < input.size(); i++) {
                String[] line = input.get(i).split(" ");
                switch (line[0]) {
                    case "forward" -> horizontal += Integer.parseInt(line[1]);
                    case "down" -> depth += Integer.parseInt(line[1]);
                    case "up" -> depth -= Integer.parseInt(line[1]);
                }
            }
            int finalPos = horizontal * depth;
            System.out.println(finalPos);
        } catch (Exception e) {
        }
    }
}