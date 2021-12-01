using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace AdventOfCode.Solutions
{
    class Year2021Day01
    {
        static void Main(string[] args)
        {

            //Get Input, Convert List<string> to List<int>
            var fileInput = new List<string>(File.ReadAllLines("A:/AOCINPUTS/day01.txt"));
            var x = 0;
            var intList = ConvertToIntList(fileInput,x);

            //Solve Problem
            var p2Answer = PartTwo(intList);
            var p1Answer = PartOne(intList);

            //Display Answers
            Console.WriteLine(p1Answer);
            Console.WriteLine(p2Answer);

        }

        public static int PartOne(List<int> l)
        {
            var bigger = 0;
            for (int i = 1; i < l.Count; i++) 
                if (l[i] > l[i-1]) 
                    bigger++;
            
            return bigger;
        }

        public static int PartTwo(List<int> l)
        {
            var bigger = 0;
            for (int i = 3; i < l.Count; i++) 
                if (l[i-2] + l[i-1] + l[i] > l[i-3] + l[i-2] + l[i-1]) 
                    bigger++;
            
            return bigger;
        }

        public static List<int> ConvertToIntList(List<string> input, int x) => input.Where(c => int.TryParse(c, out x)).Select(c => x).ToList();

    }
}
