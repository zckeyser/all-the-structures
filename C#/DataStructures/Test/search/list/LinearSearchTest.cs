using DataStructures.search.list;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Linq;

namespace Test.search.list
{
    [TestClass]
    public class LinearSearchTest
    {
        private int[] arr;

        [TestInitialize]
        public void SetUp()
        {
            arr = Enumerable.Range(0, 1000).ToArray();
        }

        [TestMethod]
        public void LinearSearch_DoesNotContain()
        {
            var result = LinearSearch.IndexOf(arr, 10000);

            Assert.AreEqual(-1, result);
        }

        [TestMethod]
        public void LinearSearch_AtBeginning()
        {
            var result = LinearSearch.IndexOf(arr, 0);

            Assert.AreEqual(0, result);
        }

        [TestMethod]
        public void LinearSearch_InMiddle()
        {
            var result = LinearSearch.IndexOf(arr, 499);

            Assert.AreEqual(499, result);
        }

        [TestMethod]
        public void LinearSearch_AtEnd()
        {
            var result = LinearSearch.IndexOf(arr, 999);

            Assert.AreEqual(999, result);
        }
    }
}
