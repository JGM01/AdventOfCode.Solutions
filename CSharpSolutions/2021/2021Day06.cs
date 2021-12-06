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
            var dp = Enumerable.Range(0, 8).Select(i => (long)arr.Count(n => n == i)).ToArray();
            for (var day = 1; day <= T; day++)
            {
                var zeroes = dp[0];
                for (var i = 0; i <= 7; i++) dp[i] = dp[i + 1];
                
                dp[6] += zeroes;
                dp[8] = zeroes;
            }
            return dp.Sum();
        }
    }
}
