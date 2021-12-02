import java.util.List;
import java.util.stream.Stream;

public class Day02B implements Problem {

    @Override
    public int solve(Stream<String> inputStream) {
        List<String> input = inputStream.toList();
        int horizontal = 0, depth = 0, aim = 0;
        for (int i = 0; i < input.size(); i++) {
            String[] line = input.get(i).split(" ");
            switch (line[0]) {
                case "forward" -> {
                    int X = Integer.parseInt(line[1]);
                    horizontal += X;
                    depth += aim * X;
                }
                case "down" -> aim += Integer.parseInt(line[1]);
                case "up" -> aim -= Integer.parseInt(line[1]);
            }
        }
        int finalPos = horizontal * depth;
        return finalPos;
    }
}