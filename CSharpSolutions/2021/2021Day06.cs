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
            //no fish yet
            long fish = 0;

            //Create an array list which has a row value that represents total days and a col value which represents the state of the fish on a given day
            long[,] dp = new long[T + 1, 9];

            //set all values at day 0 to 1
            for (int i = 0; i <= 8; i++) 
                dp[0, i] = 1;

            //simulate each day, and check if a state is 0 on a given day, if it is, change the state to 6 and add a new 8 value, if not just subtract the state as usual
            for (int days = 1; days <= T; days++)
                for (int state = 0; state <= 8; state++)
                    dp[days, state] = state == 0 ? dp[days-1, 6] + dp[days - 1, 8] : dp[days -1, state - 1];

            foreach (int i in arr) fish += dp[T, i];

            return fish;
        }
    }
}
