package adventOfCode.year2021;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import adventOfCode.Problem;

public class Day06A implements Problem {

    @Override
    public int solve(Stream<String> inputStream) {
        int days = 80;
        List<Integer> population = new ArrayList<Integer>();
        Stream.of(inputStream.findFirst().get().split(",")).mapToInt(Integer::parseInt).forEach(population::add);

        while (days-- > 0) {
            int zeroCount = (int) population.stream().filter(f -> f == 0).count();
            for (int j = 0; j < zeroCount; j++) {
                population.add(9);
            }

            population = new ArrayList<Integer>(
                    population.stream().map(f -> f == 0 ? 6 : --f).toList());
        }

        return population.size();
    }

}