import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Day04B implements Problem {

    @Override
    public int solve(Stream<String> inputStream) {
        final byte FLAG = 100;
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
                for (byte j = 0; j < 5; j++) {
                    String current = line.split(" ")[position];
                    board[i][j] = Byte.parseByte(current);
                    position++;
                }
            }

            boards.add(board);
        }

        // actual problem logic
        int drawnNum = 0;
        int sum = 0;
        ArrayList<byte[][]> validBoards = new ArrayList<>(boards);
        for (int i = 0; i < numbers.length; i++) {
            drawnNum = numbers[i];

            // flagging drawn number
            for (byte[][] b : boards) {
                boardSearch: for (byte j = 0; j < 5; j++) {
                    for (byte k = 0; k < 5; k++) {
                        if (b[j][k] == drawnNum) {
                            b[j][k] = FLAG;
                            break boardSearch;
                        }
                    }
                }
            }

            // checking
            check: for (byte[][] b : boards) {
                // when there is only one left, use that one
                if (validBoards.size() == 1) {
                    b = validBoards.get(0);
                }

                // checks ------
                for (byte j = 0; j < 5; j++) {
                    if (b[j][0] == FLAG && b[j][1] == FLAG && b[j][2] == FLAG && b[j][3] == FLAG && b[j][4] == FLAG) {
                        if (validBoards.size() == 1) {
                            for (byte k = 0; k < 5; k++) {
                                for (byte l = 0; l < 5; l++) {
                                    if (b[k][l] != FLAG)
                                        sum += b[k][l];
                                }
                            }
                            break check;
                        } else {
                            validBoards.remove(b);
                        }
                    }
                }

                // checks |
                for (byte j = 0; j < 5; j++) {
                    if (b[0][j] == FLAG && b[1][j] == FLAG && b[2][j] == FLAG && b[3][j] == FLAG && b[4][j] == FLAG) {
                        if (validBoards.size() == 1) {
                            for (byte k = 0; k < 5; k++) {
                                for (byte l = 0; l < 5; l++) {
                                    if (b[k][l] != FLAG)
                                        sum += b[k][l];
                                }
                            }
                            break check;
                        } else {
                            validBoards.remove(b);
                        }
                    }
                }
            }

            // check to see if we have found a correct answer (sum will not be 0 if there is
            // a correct answer)
            if (sum != 0)
                return drawnNum * sum;
        }

        return -1;
    }

}