using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpSolutions._2021
{
    /* ADVENT OF CODE 2021 DAY 03
     * LINK TO PROBLEM: https://adventofcode.com/2021/day/3
     */
    class _2021Day03 : Solver
    {
        static readonly List<string> fileInput = new(File.ReadAllLines("A:/AOCINPUTS/day03.txt"));
        static readonly List<string> fileInput2 = new(File.ReadAllLines("A:/AOCINPUTS/day03.txt"));
        
        public static int PartOne() => FindPowerConsumption(fileInput, "", "");

        public static int PartTwo() => FindOxygenRating(fileInput) * FindScrubberRating(fileInput2);

        static (int, int) CountBitsPerIndex(List<string> l, int i, int amtZero)
        {
            foreach (string j in l) amtZero += j[i] == '0' ? 1 : 0;
            return (amtZero , l.Count-amtZero);
        }
        
        static int FindPowerConsumption(List<string> diagnosticReport, string gammaRate, string epsilonRate)
        {
            for (int i = 0; i < 12; i++)
            {
                (var amtZero, var amtOne) = CountBitsPerIndex(diagnosticReport, i, 0);

                epsilonRate += amtZero > amtOne ? '1' : '0';
                gammaRate += amtZero > amtOne ? '0' : '1';
            }
            return Convert.ToInt32(gammaRate, 2)*Convert.ToInt32(epsilonRate,2);
        } 

        static int FindOxygenRating(List<string> diagnosticReport)
        {
            for (int i =0; i < 12; i++)
            {
                (var amtZero, var amtOne) = CountBitsPerIndex(diagnosticReport, i, 0);

                if (diagnosticReport.Count == 1) break; 
                diagnosticReport.RemoveAll(c => c[i] != ((amtOne > amtZero || amtOne == amtZero)? '1' : '0'));
            }

            return Convert.ToInt32(diagnosticReport[0], 2);
        }

        static int FindScrubberRating(List<string> diagnosticReport)
        {
            for (int i =0; i < 12; i++)
            {
                (var amtZero, var amtOne) = CountBitsPerIndex(diagnosticReport, i, 0);

                if (diagnosticReport.Count == 1) break; 
                diagnosticReport.RemoveAll(c => c[i] != ((amtOne > amtZero || amtOne == amtZero)? '0' : '1'));
            }

            return Convert.ToInt32(diagnosticReport[0], 2);
        }
    }
}
