import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Day04A implements Problem {

    @Override
    public int solve(Stream<String> inputStream) {
        List<String> input = inputStream.toList();
        int[] numbers = Stream.of(input.stream().findFirst().get().split(",")).mapToInt(Integer::parseInt).toArray();

        String[] boardsString = input.stream().skip(2).map(s -> s.equals("") ? "\n" : s)
                .reduce(new String(), (s1, s2) -> s1 + " " + s2).replace("  ", " ").split("\n");

        ArrayList<byte[][]> boards = new ArrayList<>();

        // create and add boards to board list
        for (int boardNum = 0; boardNum < boardsString.length; boardNum++) {
            String line = boardsString[boardNum].strip();
            byte[][] board = new byte[5][5];
            byte position = 0;
            for (byte i = 0; i < 5; i++) {
                for (Byte j = 0; j < 5; j++) {
                    String current = line.split(" ")[position];
                    board[i][j] = Byte.parseByte(current);
                    position++;
                }
            }

            boards.add(board);
        }

        // actual problem logic
        int sum = 0;
        int drawnNum = 0;
        for (int i = 0; i < numbers.length; i++) {
            drawnNum = numbers[i];

            // flagging drawn number
            for (byte[][] b : boards) {
                boardSearch: for (Byte j = 0; j < 5; j++) {
                    for (byte k = 0; k < 5; k++) {
                        if (b[j][k] == drawnNum) {
                            b[j][k] = 100;
                            break boardSearch;
                        }
                    }
                }
            }

            // checking
            boardCheck: for (byte[][] b : boards) {
                // checks ------
                for (byte j = 0; j < 5; j++) {
                    if (b[j][0] == 100 && b[j][1] == 100 && b[j][2] == 100 && b[j][3] == 100 && b[j][4] == 100) {
                        for (byte k = 0; k < 5; k++) {
                            for (byte l = 0; l < 5; l++) {
                                if (b[k][l] != 100)
                                    sum += b[k][l];
                            }
                        }
                        break boardCheck;
                    }
                }

                // checks |
                for (byte j = 0; j < 5; j++) {
                    if (b[0][j] == 100 && b[1][j] == 100 && b[2][j] == 100 && b[3][j] == 100 && b[4][j] == 100) {
                        for (byte k = 0; k < 5; k++) {
                            for (byte l = 0; l < 5; l++) {
                                if (b[k][l] != 100)
                                    sum += b[k][l];
                            }
                        }
                        break boardCheck;
                    }
                }
            }

            // check to see if we have found a correct answer (sum will not be 0 if there is
            // a correct answer)
            if (sum != 0) {
                return drawnNum * sum;
            }
        }

        return -1;
    }

}