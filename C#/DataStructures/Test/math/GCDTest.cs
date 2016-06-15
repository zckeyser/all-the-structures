using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using DataStructures.Math;

namespace Test.math
{
    [TestClass]
    public class GCDTest
    {
        [TestMethod]
        public void GCD_ShouldFindCorrectly_WithNumbersSharingDenominator()
        {
            Assert.AreEqual(12, GCD.Find(60, 36));
        }

        [TestMethod]
        public void GCD_ShouldFindCorrectly_WithNumbersOnlySharing1ForDenominator()
        {
            Assert.AreEqual(1, GCD.Find(51, 67));
        }
    }
}
