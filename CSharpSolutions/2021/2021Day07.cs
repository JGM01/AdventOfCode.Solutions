using System.Collections.Generic;
using System.Linq;
using System.IO;
using static Globals.UtilityMethods;

namespace CSharpSolutions._2021
{
    /* ADVENT OF CODE 2021 DAY 07
     * LINK TO PROBLEM: https://adventofcode.com/2021/day/7
     */
    class _2021Day07 : Solver
    {
        static int[] fileInput = File.ReadAllText("A:/AOCINPUTS/day07.txt").Split(',').Select(int.Parse).ToArray();

        public static int PartOne() => Solve(fileInput.Min(), fileInput.Max(), true);
        public static int PartTwo() => Solve(fileInput.Min(), fileInput.Max(), false);

        public static int Solve(int min, int max, bool part1) => 
            part1? 
                Enumerable
                    .Range(min, max - min + 1)
                    .Min(i => fileInput.Select(x => System.Math.Abs(x - i))
                    .Sum()) : 
                Enumerable
                    .Range(min, max - min + 1)
                    .Min(i => fileInput.Select(x => System.Math.Abs(x - i))
                    .Select(x => x * (x + 1) / 2)
                    .Sum());
    }
}
