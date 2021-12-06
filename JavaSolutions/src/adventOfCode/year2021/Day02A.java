package adventOfCode.year2021;

import java.util.List;
import java.util.stream.Stream;

import adventOfCode.Problem;

public class Day02A implements Problem {

    @Override
    public int solve(Stream<String> inputStream) {
        List<String> input = inputStream.toList();
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
        return finalPos;
    }
}