package adventOfCode.year2021;

import java.util.stream.Stream;

import adventOfCode.Problem;

public class Day03A implements Problem {

    @Override
    public int solve(Stream<String> inputStream) {
        String[] input = inputStream.toArray(String[]::new);
        int[] bitCount = new int[input[0].length()];
        for (int line = 0; line < input.length; line++) {
            for (int bitLocation = 0; bitLocation < input[0].length(); bitLocation++) {
                bitCount[bitLocation] += input[line].charAt(bitLocation) == '1' ? 1 : -1;
            }
        }

        String sNumber = "";
        for (int bit : bitCount) {
            if (bit > 0) {
                sNumber += "1";
            } else {
                sNumber += "0";
            }
        }

        int decimal = Integer.parseInt(sNumber, 2);
        int decimalInverse = Integer.parseInt(sNumber.replace('0', '2').replace('1', '0').replace('2', '1'), 2);
        return decimal * decimalInverse;
    }

}