import java.io.BufferedReader;
import java.io.FileReader;

public class Day01A {
    public static void main(String[] args) {
        try (var br = new BufferedReader(new FileReader("input.txt"))) {
            int[] input = br.lines().mapToInt(Integer::parseInt).toArray();
            int count = 0;
            for(int i = 1; i < input.length; i++) {
                if(input[i] > input[i-1]) count++;
            }
            System.out.println(count);
        } catch (Exception e) {
        }
    }
}