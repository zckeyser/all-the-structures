namespace DataStructures.Math
{
    /// <summary>
    /// classic euclidian Greatest Common Denominator algorithm implementation
    /// </summary>
    public static class GCD
    {
        public static int Find(int a, int b)
        {
            if (a % b == 0)
                return b;
            else if (b > a)
                return Find(b, a);
            else
                return Find(a % b, b);
        } 
    }
}
