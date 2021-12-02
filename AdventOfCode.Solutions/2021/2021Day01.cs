using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace AdventOfCode.Solutions._2021
{
    class _2021Day01 : Solver
    {

        public static readonly List<string> fileInput = new List<string>(File.ReadAllLines("A:/AOCINPUTS/day01.txt"));


        public static int PartOne()
        { 
            var x = 0;
            var l = ConvertToIntList(fileInput, x);

            var bigger = 0;
            for (int i = 1; i < l.Count; i++)
                if (l[i] > l[i - 1])
                    bigger++;

            return bigger;

        }

        public static int PartTwo()
        {
            var x = 0;
            var l = ConvertToIntList(fileInput, x);

            var bigger = 0;
            for (int i = 3; i < l.Count; i++)
                if (l[i - 2] + l[i - 1] + l[i] > l[i - 3] + l[i - 2] + l[i - 1])
                    bigger++;

            return bigger;
        }


        public static List<int> ConvertToIntList(List<string> input, int x) => 
            input.Where(c => int.TryParse(c, out x))
                 .Select(c => x)
                 .ToList();


    }
}
