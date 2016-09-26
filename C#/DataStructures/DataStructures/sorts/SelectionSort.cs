using System;

namespace DataStructures.sorts
{
    public static class SelectionSort
    {
        public static T[] Sort<T>(T[] arr)
            where T : IComparable
        {
            T[] output = new T[arr.Length];
            arr.CopyTo(output, 0);

            for(int i = 0; i < output.Length - 1; i++)
            {
                int min = i;

                for(int j = i; j < output.Length; j++)
                {
                    if (output[j].CompareTo(output[min]) < 0)
                        min = j;
                }

                var tmp = output[i];
                output[i] = output[min];
                output[min] = tmp;
            }

            return output;
        }
    }
}
