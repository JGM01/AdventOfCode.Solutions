import java.util.stream.Stream;

public class Day01A implements Problem {

    @Override
    public int solve(Stream<String> inputStream) {
        int[] input = inputStream.mapToInt(Integer::parseInt).toArray();
        int count = 0;
        for (int i = 1; i < input.length; i++) {
            if (input[i] > input[i - 1])
                count++;
        }
        return count;
    }
}