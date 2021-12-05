import collections


def day05(lines, includeHorizontal):
    points = collections.defaultdict(int)

    for line in lines.splitlines():
        a, b = line.split("->")
        x1, y1 = map(int, a.split(","))
        x2, y2 = map(int, b.split(","))

        if x1 != x2 and y1 != y2 and abs(x1 - x2) != abs(y1 - y2):
            continue

        if y1 == y2:
            for i in range(min(x1, x2), max(x1, x2) + 1):
                points[(i, y1)] += 1

        if x1 == x2:
            for i in range(min(y1, y2), max(y1, y2) + 1):
                points[(x1, i)] += 1

        if includeHorizontal:
            if abs(x1 - x2) == abs(y1 - y2):
                y_mult = -1 if y1 > y2 else 1
                x_mult = -1 if x1 > x2 else 1
                for i in range(abs(x1 - x2) + 1):
                    points[(x1 + (x_mult * i), y1 + (y_mult * i))] += 1

    print(sum(i > 1 for i in points.values()))


if __name__ == "__main__":
    with open("A:/AOCINPUTS/day05.txt") as f:
        data = f.read()
    day05(data, False)
    day05(data, True)
