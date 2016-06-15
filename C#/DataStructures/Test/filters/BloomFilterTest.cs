using DataStructures.Filters;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Test
{
    /// <summary>
    /// due to the probabilistic nature of this 
    /// algorithm it's somewhat difficult to unit test
    /// </summary>
    [TestClass]
    public class BloomFilterTest
    {
        private BloomFilter filter;

        [TestInitialize]
        public void SetUp()
        {
            filter = new BloomFilter();
        }

        [TestMethod]
        public void BloomFilter_DoesNotContain_ShouldDetectUncontained()
        {
            filter.Add("foo");
            filter.Add("bar");

            Assert.IsTrue(filter.DoesNotContain("foobar"));
        }

        [TestMethod]
        public void BloomFilter_DoesNotContain_ShouldDetectContained()
        {
            filter.Add("foo");
            filter.Add("bar");

            Assert.IsFalse(filter.DoesNotContain("foo"));
        }
    }
}
