package adventOfCode.year2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import adventOfCode.Problem;

public class Day03B implements Problem {

    @Override
    public int solve(Stream<String> inputStream) {
        String[] input = inputStream.toArray(String[]::new);
        List<String> mostSignificant = Arrays.asList(input);
        for (int bitLocation = 0; bitLocation < input.length; bitLocation++) {
            int significantBitCount = 0;
            for (String line : mostSignificant) {
                significantBitCount += line.charAt(bitLocation) == '1' ? 1 : -1;
            }

            final int stupidLambda = bitLocation;
            if (significantBitCount >= 0) {
                mostSignificant = new ArrayList<String>(
                        mostSignificant.stream().filter(s -> s.charAt(stupidLambda) == '1').toList());
            } else {
                mostSignificant = new ArrayList<String>(
                        mostSignificant.stream().filter(s -> s.charAt(stupidLambda) == '0').toList());
            }

            if (mostSignificant.size() == 1)
                break;
        }

        List<String> leastSignificant = Arrays.asList(input);
        for (int bitLocation = 0; bitLocation < input.length; bitLocation++) {
            int significantBitCount = 0;
            for (String line : leastSignificant) {
                significantBitCount += line.charAt(bitLocation) == '1' ? 1 : -1;
            }

            final int stupidLambda = bitLocation;
            if (significantBitCount >= 0) {
                leastSignificant = new ArrayList<String>(
                        leastSignificant.stream().filter(s -> s.charAt(stupidLambda) == '0').toList());
            } else {
                leastSignificant = new ArrayList<String>(
                        leastSignificant.stream().filter(s -> s.charAt(stupidLambda) == '1').toList());
            }

            if (leastSignificant.size() == 1)
                break;
        }

        return Integer.parseInt(leastSignificant.get(0), 2) * Integer.parseInt(mostSignificant.get(0), 2);
    }

}