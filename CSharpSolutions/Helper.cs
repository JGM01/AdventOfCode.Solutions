using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Globals
{
    public static class UtilityMethods
    { 

        public static List<int> StringToIntList(List<string> input, int x) => input.Where(c => int.TryParse(c, out x)).Select(c => x).ToList();

    }
}
