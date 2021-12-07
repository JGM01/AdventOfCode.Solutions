using System.Collections.Generic;
using System.Linq;
using System.IO;
using static Globals.UtilityMethods;
using System;

namespace CSharpSolutions._2021
{
    /* ADVENT OF CODE 2021 DAY 06
     * LINK TO PROBLEM: https://adventofcode.com/2021/day/6
     */
    class _2021Day05 : Solver
    {

        static string fileInput = File.ReadAllText("A:/AOCINPUTS/day05.txt");

        public static string PartOne() => Solve(fileInput, false);
        public static string PartTwo() => Solve(fileInput, true);

        static string Solve(string input, bool includeDiagonals) =>
            input
            .Split("\n")
            .Where(s => !string.IsNullOrEmpty(s))
            .Select(s => s.Split(" -> "))
            .Select(a => (x1(a), y1(a), x2(a), y2(a)))
            .Where(t => includeDiagonals || t.Item1 == t.Item3 || t.Item2 == t.Item4)
            .SelectMany(t => Enumerable
                .Range(0, Math.Max(Math.Abs((int)(t.Item1 - t.Item3)), Math.Abs((int)(t.Item2 - t.Item4))) + 1)
                .Select(i => (
                    t.Item1 > t.Item3 ? t.Item3 + i : t.Item1 < t.Item3 ? t.Item3 - i : t.Item3,
                    t.Item2 > t.Item4 ? t.Item4 + i : t.Item2 < t.Item4 ? t.Item4 - i : t.Item4)))
            .GroupBy(k => k)
            .Count(k => Enumerable.Count(k) >= 2)
            .ToString();

        static private int x1(string[] a) => int.Parse(a[0].Split(",")[0]);
        static private int y1(string[] a) => int.Parse(a[0].Split(",")[1]);
        static private int x2(string[] a) => int.Parse(a[1].Split(",")[0]);
        static private int y2(string[] a) => int.Parse(a[1].Split(",")[1]);
    }
}
