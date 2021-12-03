using System;
using System.Collections.Generic;
using System.IO;

namespace CSharpSolutions._2021
{
    /* ADVENT OF CODE 2021 DAY 02
     * LINK TO PROBLEM: https://adventofcode.com/2021/day/2
     */
    class _2021Day02 : Solver
    {
        static readonly List<string> fileInput = new List<string>(File.ReadAllLines("A:/AOCINPUTS/day02.txt"));

        public static int PartOne()
        {
            var hVal = 0;
            var depth = 0;

            foreach (string i in fileInput)
            {
                var singleInstruction = i.Split(" ");
                var dir = singleInstruction[0];
                var distance = Convert.ToInt32(singleInstruction[1]);
                switch (dir)
                {
                    case "forward":
                        hVal += distance;
                        break;
                    case "down":
                        depth += distance;
                        break;
                    case "up":
                        depth -= distance;
                        break;
                }
            }
            return depth * hVal;
        }

        public static int PartTwo()
        {

            var hVal = 0;
            var depth = 0;
            var aim = 0;

            foreach (string i in fileInput)
            {
                var singleInstruction = i.Split(" ");
                var dir = singleInstruction[0];
                var distance = Convert.ToInt32(singleInstruction[1]);
                switch (dir)
                {
                    case "forward":
                        depth += aim * distance;
                        hVal += distance;
                        break;
                    case "down":
                        aim += distance;
                        break;
                    case "up":
                        aim -= distance;
                        break;
                }
            }
            return depth * hVal;
        }
    }
}
