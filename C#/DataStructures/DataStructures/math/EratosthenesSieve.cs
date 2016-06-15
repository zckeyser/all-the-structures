using System.Collections.Generic;
using System.Linq;

namespace DataStructures.Math
{
    /// <summary>
    /// sieve to find prime numbers up to whatever size it's instantiated with,
    /// which are held in the Values property of the sieve
    /// </summary>
    public class EratosthenesSieve
    {
        public List<int> Values { get; private set; }

        public EratosthenesSieve(int size)
        {
            Values = PrimesUpTo(size);
        }

        private List<int> PrimesUpTo(int n)
        {
            var primes = Enumerable.Range(2, n - 1).ToList();

            for(var i = 0; i < primes.Count / 2; i++)
            {
                // go through the array and remove every value which
                // is divisible by the value at index i
                for(var j = i + 1; j < primes.Count; j++)
                {
                    if (primes[j] % primes[i] == 0)
                    {
                        primes.RemoveAt(j);
                        // want to make sure we stay at the same position for the next
                        // iteration, since we removed a value here.
                        j--;
                    }
                }
            }

            return primes;
        }
    }
}
