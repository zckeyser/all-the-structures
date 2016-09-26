using DataStructures.util;
using System;

namespace DataStructures.sorts
{
    public static class BubbleSort
    {
        public static T[] Sort<T>(T[] input)
            where T : IComparable
        {
            T[] output = new T[input.Length];
            input.CopyTo(output, 0);

            while(!SortUtil.IsSorted(output))
            {
                for(int i = 0; i < output.Length - 1; i++)
                {
                    if(output[i].CompareTo(output[i + 1]) > 0)
                    {
                        var tmp = output[i];
                        output[i] = output[i + 1];
                        output[i + 1] = tmp;
                    }
                }
            }

            return output;
        }
    }
}
