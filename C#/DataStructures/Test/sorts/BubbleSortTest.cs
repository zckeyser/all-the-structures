using DataStructures.sorts;
using DataStructures.util;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Test.util;

namespace Test.sorts
{
    [TestClass]
    public class BubbleSortTest
    {
        [TestMethod]
        public void BubbleSort_SortsCorrectly()
        {
            var input = TestUtil.RandomArray(TestUtil.ARR_SIZE);

            var result = BubbleSort.Sort(input);

            Assert.IsTrue(SortUtil.IsSorted(result));
        }
    }
}
