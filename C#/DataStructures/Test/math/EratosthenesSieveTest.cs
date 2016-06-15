using Microsoft.VisualStudio.TestTools.UnitTesting;
using DataStructures.math;

namespace Test.math
{
    [TestClass]
    public class EratosthenesSieveTest
    {
        [TestMethod]
        public void Sieve_ShouldFindPrimesUpTo100()
        {
            var sieve = new EratosthenesSieve(100);
            int[] expected = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 };

            for (var i = 0; i < expected.Length; i++)
                Assert.AreEqual(expected[i], sieve.Values[i]);
        }
    }
}
