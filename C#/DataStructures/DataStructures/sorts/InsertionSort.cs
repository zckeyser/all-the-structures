using System;

namespace DataStructures.sorts
{
    public static class InsertionSort
    {
        public static T[] Sort<T>(T[] arr)
            where T : IComparable
        {
            T[] output = new T[arr.Length];
            arr.CopyTo(output, 0);

            for (int i = 0; i < output.Length; i++)
            {
                int j = i;

                while(j > 0 && output[j].CompareTo(output[j - 1]) < 0)
                {
                    var tmp = output[j];
                    output[j] = output[j - 1];
                    output[j - 1] = tmp;

                    j--;
                }
            }

            return output;
        }
    }
}
