using DataStructures.sorts;
using DataStructures.util;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Test.util;

namespace Test.sorts
{
    [TestClass]
    public class InsertionSortTest
    {
        [TestMethod]
        public void InsertionSort_SortsCorrectly()
        {
            var input = TestUtil.RandomArray(TestUtil.ARR_SIZE);

            var result = InsertionSort.Sort(input);

            Assert.IsTrue(SortUtil.IsSorted(result));
        }
    }
}
