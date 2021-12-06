using System.Collections.Generic;
using System.Linq;
using System.IO;
using static Globals.UtilityMethods;

namespace CSharpSolutions._2021
{
    /* ADVENT OF CODE 2021 DAY 06
     * LINK TO PROBLEM: https://adventofcode.com/2021/day/6
     */
    class _2021Day06 : Solver
    {

        static int[] fileInput = File.ReadAllText("A:/AOCINPUTS/day06.txt").Split(',').Select(int.Parse).ToArray();

        public static long PartOne() => Solve(fileInput, 80);
        public static long PartTwo() => Solve(fileInput, 256);
        

        static long Solve(int[] arr, int T)
        {
            long fish = 0;
            long[,] dp = new long[T + 1, 9];
            for (int i = 0; i <= 8; i++) dp[0, i] = 1;

            for (int days = 1; days <= T; days++)
                for (int state = 0; state <= 8; state++)
                    dp[days, state] = state == 0 ? dp[days-1, 6] + dp[days - 1, 8] : dp[days -1, state - 1];
            foreach (int i in arr) fish += dp[T, i];

            return fish;
        }
    }
}
