package adventOfCode.year2021;

import java.util.List;
import java.util.stream.Stream;

import adventOfCode.Problem;

public class Day05A implements Problem {

    @Override
    public int solve(Stream<String> inputStream) {
        List<Line> lines = inputStream.map(s -> {
            String[] line = s.split(" -> ");
            return new Line(new Point(line[0].split(",")), new Point(line[1].split(",")));
        }).toList();

        List<Line> straightLines = lines.stream().filter(s -> s.p1().x() != s.p2().x() ^ s.p1().y() != s.p2().y())
                .toList();

        int overlapping = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                final int ii = i, jj = j;
                if (straightLines.stream().filter(s -> s.inLine(ii, jj)).count() > 1)
                    overlapping++;
            }
        }
        return overlapping;
    }

}

record Line(Point p1, Point p2) {
    public boolean inLine(int x, int y) {
        if (x == p1.x() && x == p2.x()) {
            return (y <= p1.y() && y >= p2.y()) ^ (y >= p1.y() && y <= p2.y());
        } else if (y == p1.y() && y == p2.y()) {
            return (x <= p1.x() && x >= p2.x()) ^ (x >= p1.x() && x <= p2.x());
        } else {
            return (y <= p1.y() && y >= p2.y()) ^ (y >= p1.y() && y <= p2.y())
                    && (x <= p1.x() && x >= p2.x()) ^ (x >= p1.x() && x <= p2.x());
        }
    }
}

record Point(int x, int y) {
    public Point(String[] input) {
        this(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
    }
}