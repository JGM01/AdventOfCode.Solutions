import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class Solver {
    private final static String FILE_NAME = "input.txt";

    public static void main(String[] args) {
        // change this to be the current day/part
        Problem problem = new Day02A();

        try (var br = new BufferedReader(new FileReader(FILE_NAME))) {
            Stream<String> input = br.lines();

            int output = problem.solve(input);
            System.out.println(output);
        } catch (IOException e) {
            System.err.println("cant find file " + FILE_NAME);
        }
    }
}