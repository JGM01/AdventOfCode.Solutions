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

        static readonly List<int> fileInput = new(File.ReadAllLines("A:/AOCINPUTS/day01.txt").Select(int.Parse));
        public static int PartOne() => Solve(fileInput, true, 0);
        public static int PartTwo() => Solve(fileInput,false, 0);

        public static int Solve(List<int> l, bool part1, int bigger)
        {   
            for (int i = 1; i < l.Count; i++)
                bigger += l[i] > l[i - 1] && part1 ? 1 : 0;
            
            for (int j = 3; j < l.Count; j++)
                bigger += l[j - 2] + l[j - 1] + l[j] > l[j - 3] + l[j - 2] + l[j - 1] && !part1 ? 1 : 0;
            
            return bigger;
        }

    }
}
