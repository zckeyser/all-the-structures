using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataStructures.sorts
{
    public static class QuickSort
    {
        private static Random rand = new Random();

        public static T[] Sort<T>(T[] arr)
            where T : IComparable
        {
            T[] output = new T[arr.Length];
            arr.CopyTo(output, 0);

            return QSort(output);
        }

        private static T[] QSort<T>(T[] arr)
            where T : IComparable
        {
            // base condition
            if (arr.Length <= 1)
                return arr;

            // take random element to pivot around
            var pivot = arr[0];

            // partition around pivot
            int i = 0, j = arr.Length - 1;

            while(i < j)
            {
                // find values that are out of place
                while (i < arr.Length && arr[i].CompareTo(pivot) < 0) i++;
                while (j > 0 && arr[j].CompareTo(pivot) > 0) j--;

                // swap the values
                if(i < j)
                {
                    var tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;

                    i++;
                    j--;
                }
            }

            // take the subarrays
            var left = arr.Take(j).ToArray();
            var right = arr.Skip(i).ToArray();

            return QSort(left).Concat(QSort(right)).ToArray();
        }
    }
}
