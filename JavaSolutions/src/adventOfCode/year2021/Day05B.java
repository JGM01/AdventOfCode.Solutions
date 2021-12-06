package adventOfCode.year2021;

import java.util.List;
import java.util.stream.Stream;

import adventOfCode.Problem;

public class Day05B implements Problem {

    @Override
    public int solve(Stream<String> inputStream) {
        List<Line> lines = inputStream.map(s -> {
            String[] line = s.split(" -> ");
            return new Line(new Point(line[0].split(",")), new Point(line[1].split(",")));
        }).toList();

        List<Line> straightLines = lines.stream().filter(s -> {
            boolean straight = s.p1().x() != s.p2().x() ^ s.p1().y() != s.p2().y();
            boolean angled = Math.abs(s.p1().x() - s.p2().x()) == Math.abs(s.p1().y() - s.p2().y());
            return angled || straight;
        }).toList();

        int overlapping = 0;
        int boardSize = 1000;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                final int ii = i, jj = j;
                int count = (int) straightLines.stream().filter(s -> s.inLine(jj, ii)).count();
                // System.out.print(count == 0 ? ". " : count + " ");
                if (count > 1)
                    overlapping++;
            }
            // System.out.println();
        }
        return overlapping;
    }

}

record Line(Point p1, Point p2) {
    public boolean inLine(int x, int y) {
        boolean yInRange = (y <= p1.y() && y >= p2.y()) ^ (y >= p1.y() && y <= p2.y());
        boolean xInRange = (x <= p1.x() && x >= p2.x()) ^ (x >= p1.x() && x <= p2.x());
        if (x == p1.x() && x == p2.x()) {
            return yInRange;
        } else if (y == p1.y() && y == p2.y()) {
            return xInRange;
        } else {
            if (xInRange && yInRange) {
                int m = (p1.y() - p2.y()) / (p1.x() - p2.x());
                return y == m * x + (m * -p2.x() + p2.y());
            } else {
                return false;
            }
        }
    }
}

record Point(int x, int y) {
    public Point(String[] input) {
        this(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
    }
}