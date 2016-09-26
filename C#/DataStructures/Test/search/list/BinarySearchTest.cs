using DataStructures.search.list;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Linq;

namespace Test.search.list
{
    [TestClass]
    public class BinarySearchTest
    {
        private int[] arr;

        [TestInitialize]
        public void SetUp()
        {
            arr = Enumerable.Range(0, 1000).ToArray();
        }

        [TestMethod]
        public void BinarySearch_DoesNotContain()
        {
            var result = BinarySearch.IndexOf(arr, 10000);

            Assert.AreEqual(-1, result);
        }

        [TestMethod]
        public void BinarySearch_AtBeginning()
        {
            var result = BinarySearch.IndexOf(arr, 0);

            Assert.AreEqual(0, result);
        }

        [TestMethod]
        public void BinarySearch_InMiddle()
        {
            var result = BinarySearch.IndexOf(arr, 499);

            Assert.AreEqual(499, result);
        }

        [TestMethod]
        public void BinarySearch_AtEnd()
        {
            var result = BinarySearch.IndexOf(arr, 999);

            Assert.AreEqual(999, result);
        }
    }
}
