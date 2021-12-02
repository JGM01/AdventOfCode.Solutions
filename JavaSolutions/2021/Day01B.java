import java.io.BufferedReader;
import java.io.FileReader;

public class Day01B {
    public static void main(String[] args) {
        try (var br = new BufferedReader(new FileReader("input.txt"))) {
            int[] input = br.lines().mapToInt(Integer::parseInt).toArray();
            int count = 0;
            for (int i = 2; i < input.length - 1; i++) {
                if (input[i - 1] + input[i] + input[i + 1] > input[i - 2] + input[i - 1] + input[i])
                    count++;
            }
            System.out.println(count);
        } catch (Exception e) {
        }
    }
}