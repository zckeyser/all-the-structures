using System;

namespace Test.util
{
    public static class TestUtil
    {
        public const int ARR_SIZE = 10;

        public static int[] RandomArray(int length)
        {
            var rand = new Random();

            int[] output = new int[length];

            for (int i = 0; i < length; i++)
                output[i] = rand.Next();

            return output;
        }
    }
}
