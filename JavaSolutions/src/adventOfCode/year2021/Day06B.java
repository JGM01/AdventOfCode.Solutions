package adventOfCode.year2021;

import java.math.BigInteger;
import java.util.stream.Stream;

import adventOfCode.Problem;

public class Day06B implements Problem {

    @Override
    public int solve(Stream<String> inputStream) {
        String data = Stream.of(inputStream.findFirst().get().split(",")).reduce(new String(), String::concat);
        BigInteger zeroCount = BigInteger.ZERO;
        BigInteger size = BigInteger.ZERO;
        int days = 256;
        while (days-- > -1) {
            size = data.chars().mapToObj(c -> BigInteger.ONE).reduce(BigInteger.ZERO, BigInteger::add);
            zeroCount = data.chars().filter(f -> f == '0')
                    .mapToObj(f -> BigInteger.ONE).reduce(BigInteger.ZERO,
                            BigInteger::add);

            data = new String(data.chars()
                    .map(f -> f == '0' ? '6' : ((char) f - 1)).mapToObj(Character::toString)
                    .reduce(new String(), String::concat));

            for (BigInteger i = BigInteger.ZERO; i.compareTo(zeroCount) < 0; i = i.add(BigInteger.ONE)) {
                data += "8";
            }

        }

        System.out.println(size);

        return -1;
    }

}