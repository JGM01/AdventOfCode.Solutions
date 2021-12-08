package adventOfCode.year2021;

import java.util.stream.Stream;

import adventOfCode.Problem;

public class Day08A implements Problem {

    @Override
    public int solve(Stream<String> inputStream) {
        return inputStream.map(s -> {
            String output = s.split(" \\| ")[1];
            int count = (int) Stream.of(output.split(" "))
                    .filter(w -> w.length() == 2 || w.length() == 4 || w.length() == 3 || w.length() == 7).count();
            return count;
        }).reduce(Integer::sum).get();
    }

}