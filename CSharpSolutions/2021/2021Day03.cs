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
        static readonly List<string> fileInput = new List<string>(File.ReadAllLines("A:/AOCINPUTS/day03.txt"));
        static readonly List<string> fileInput2 = new List<string>(File.ReadAllLines("A:/AOCINPUTS/day03.txt"));
        
        public static int PartOne() => FindPowerConsumption(fileInput);

        public static int PartTwo() => FindOxygenRating(fileInput) * FindScrubberRating(fileInput2);

        static (int, int) FindAmountOfEachBitAtGivenIndex(List<string> l, int i)
        {
            var amtZero = 0;
            var amtOne = 0;
            foreach (string j in l)
                if (j[i] == '0')
                    amtZero++;
                else
                    amtOne++;
            return (amtZero , amtOne);
        }
        
        static int FindPowerConsumption(List<string> diagnosticReport)
        {
            var gammaRate = "";
            var epsilonRate = "";
            for (int i = 0; i < 12; i++)
            {
                (var amtZero, var amtOne) = FindAmountOfEachBitAtGivenIndex(diagnosticReport, i);

                epsilonRate += amtZero > amtOne ? '1' : '0';
                gammaRate += amtZero > amtOne ? '0' : '1';
            }
            return Convert.ToInt32(gammaRate, 2)*Convert.ToInt32(epsilonRate,2);
        } 

        static int FindOxygenRating(List<string> diagnosticReport)
        {
            for (int i =0; i < 12; i++)
            {
                (var amtZero, var amtOne) = FindAmountOfEachBitAtGivenIndex(diagnosticReport, i);

                if (diagnosticReport.Count == 1) break; 
                diagnosticReport.RemoveAll(c => c[i] != ((amtOne > amtZero || amtOne == amtZero)? '1' : '0'));
            }

            return Convert.ToInt32(diagnosticReport[0], 2);
        }

        static int FindScrubberRating(List<string> diagnosticReport)
        {
            for (int i =0; i < 12; i++)
            {
                (var amtZero, var amtOne) = FindAmountOfEachBitAtGivenIndex(diagnosticReport, i);

                if (diagnosticReport.Count == 1) break; 
                diagnosticReport.RemoveAll(c => c[i] != ((amtOne > amtZero || amtOne == amtZero)? '0' : '1'));
            }

            return Convert.ToInt32(diagnosticReport[0], 2);
        }

    }
}
