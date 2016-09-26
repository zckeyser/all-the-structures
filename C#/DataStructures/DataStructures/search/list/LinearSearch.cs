using System;

namespace DataStructures.search.list
{
    public static class LinearSearch
    {
        public static int IndexOf<T>(T[] arr, T target)
            where T : IComparable
        {
            for (int i = 0; i < arr.Length; i++)
                if (arr[i].CompareTo(target) == 0)
                    return i;

            return -1;
        }
    }
}
