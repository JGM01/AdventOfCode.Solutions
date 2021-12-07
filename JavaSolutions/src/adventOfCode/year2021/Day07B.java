package adventOfCode.year2021;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import adventOfCode.Problem;

public class Day07B implements Problem {

    @Override
    public int solve(Stream<String> inputStream) {
        int[] crabsX = Stream.of(inputStream.findFirst().get().split(",")).mapToInt(Integer::parseInt).toArray();
        int min = IntStream.of(crabsX).min().getAsInt();
        int max = IntStream.of(crabsX).max().getAsInt();

        int[] moveCosts = new int[max - min];

        for (int location = min; location < max; location++) {
            final int locationF = location;
            moveCosts[location] = IntStream.of(crabsX).map(crabLocation -> {
                int distance = Math.abs(locationF - crabLocation);
                int crabCost = 0;
                for (int i = 1; i < distance + 1; i++) {
                    crabCost += i;
                }
                return crabCost;
            }).sum();
        }

        return IntStream.of(moveCosts).min().getAsInt();
    }

}