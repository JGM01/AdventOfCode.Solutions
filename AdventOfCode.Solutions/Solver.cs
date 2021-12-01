using AdventOfCode.Solutions._2021;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace AdventOfCode.Solutions
{
    class Solver
    {
        public static readonly List<string> fileInput = new List<string>(File.ReadAllLines("A:/AOCINPUTS/day01.txt"));

        static void Main(string[] args)
        {

            Console.WriteLine($"DAY 1 PART 1: {_2021Day01.PartOne()}");
            Console.WriteLine($"DAY 1 PART 2: {_2021Day01.PartTwo()}");

        }
    }
}
