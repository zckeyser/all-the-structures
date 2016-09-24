using System;

namespace DataStructures.util
{
    public static class SortUtil
    {
        public static bool IsSorted<T>(T[] arr)
            where T : IComparable
        {
            for(int i = 0; i < arr.Length - 1; i++)
            {
                if (arr[i].CompareTo(arr[i + 1]) > 0)
                    return false;
            }

            return true;
        }
    }
}
