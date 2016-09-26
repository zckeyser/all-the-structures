using DataStructures.sorts;
using DataStructures.util;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Test.util;

namespace Test.sorts
{
    [TestClass]
    public class SelectionSortTest
    {
        [TestMethod]
        public void SelectionSort_SortsCorrectly()
        {
            var input = TestUtil.RandomArray(TestUtil.ARR_SIZE);

            var result = MergeSort.Sort(input);

            Assert.IsTrue(SortUtil.IsSorted(result));
        }
    }
}
