package adventOfCode.year2021;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import adventOfCode.Problem;

public class Day07A implements Problem {

    @Override
    public int solve(Stream<String> inputStream) {
        int[] crabsX = Stream.of(inputStream.findFirst().get().split(",")).mapToInt(Integer::parseInt).toArray();
        int min = IntStream.of(crabsX).min().getAsInt();
        int max = IntStream.of(crabsX).max().getAsInt();

        int[] moveCosts = new int[max - min];

        for (int location = min; location < max; location++) {
            final int locationF = location;
            moveCosts[location] = IntStream.of(crabsX).map(crabLocation -> Math.abs(locationF - crabLocation)).sum();
        }

        return IntStream.of(moveCosts).min().getAsInt();
    }

}