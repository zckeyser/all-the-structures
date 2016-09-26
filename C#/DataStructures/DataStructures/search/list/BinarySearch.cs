using System;

namespace DataStructures.search.list
{
    public static class BinarySearch
    {
        public static int IndexOf<T>(T[] arr, T target)
            where T : IComparable
        {
            int left = 0, right = arr.Length - 1;

            while(left <= right)
            {
                int mid = (left + right) / 2;

                // to avoid making 3 calls to CompareTo
                int comparison = target.CompareTo(arr[mid]);

                if (comparison == 0)
                    return mid;
                else if (comparison < 0)
                    right = mid - 1;
                else
                    left = mid + 1;
            }

            return -1;
        }
    }
}
