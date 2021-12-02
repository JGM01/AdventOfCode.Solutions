import java.util.stream.Stream;

public class Day01B implements Problem {

    @Override
    public int solve(Stream<String> inputStream) {
        int[] input = inputStream.mapToInt(Integer::parseInt).toArray();
        int count = 0;
        for (int i = 2; i < input.length - 1; i++) {
            if (input[i - 1] + input[i] + input[i + 1] > input[i - 2] + input[i - 1] + input[i])
                count++;
        }
        return count;
    }
}