using System;
using System.Linq;

namespace DataStructures.sorts
{
    public static class MergeSort
    {
        public static T[] Sort<T>(T[] arr)
            where T : IComparable
        {
            if (arr.Length <= 1)
                return arr;

            int mid = arr.Length / 2;

            T[] left = arr.Take(mid).ToArray();
            T[] right = arr.Skip(mid).ToArray();

            return Merge(Sort(left), Sort(right));
        }

        private static T[] Merge<T>(T[] a, T[] b)
            where T : IComparable
        {
            var output = new T[a.Length + b.Length];

            int i = 0, j = 0;

            while(i < a.Length && j < b.Length)
            {
                if(a[i].CompareTo(b[j]) < 0)
                {
                    output[i + j] = a[i];
                    i++;
                }
                else
                {
                    output[i + j] = b[j];
                    j++;
                }                    
            }

            while(i < a.Length) { output[i + j] = a[i]; i++; }
            while(j < b.Length) { output[i + j] = b[j]; j++; }

            return output;
        }
    }
}
