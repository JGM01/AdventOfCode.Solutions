using System.Collections.Generic;
using System.Linq;
using System.IO;
using static Globals.UtilityMethods;

namespace CSharpSolutions._2021
{
    /* ADVENT OF CODE 2021 DAY 01
     * LINK TO PROBLEM: https://adventofcode.com/2021/day/1
     */
    class _2021Day01 : Solver
    {

        static readonly List<string> fileInput = new List<string>(File.ReadAllLines("A:/AOCINPUTS/day01.txt"));
        public static int PartOne()
        {
            var x = 0;
            var l = StringToIntList(fileInput, x);

            var bigger = 0;
            for (int i = 1; i < l.Count; i++)
                if (l[i] > l[i - 1])
                    bigger++;

            return bigger;

        }

        public static int PartTwo()
        {
            var x = 0;
            var l = StringToIntList(fileInput, x);

            var bigger = 0;
            for (int i = 3; i < l.Count; i++)
                if (l[i - 2] + l[i - 1] + l[i] > l[i - 3] + l[i - 2] + l[i - 1])
                    bigger++;

            return bigger;
        }


    }
}
