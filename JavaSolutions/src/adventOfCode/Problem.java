package adventOfCode;

/**
 * Represents a solution with a standard input stream that returns an integer
 * value.
 */
public interface Problem {
    /**
     * Executes the problem's logic.
     * 
     * @param inputStream the stream of data to be proccessed
     * @return The solution to the problem
     */
    public int solve(java.util.stream.Stream<String> inputStream);
}