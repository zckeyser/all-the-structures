using DataStructures.dictionary;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Test.dictionary
{
    [TestClass]
    public class DictTest
    {
        private Dict<string, int> dict;

        [TestInitialize]
        public void SetUp()
        {
            dict = new Dict<string, int>();
        }

        [TestMethod]
        public void Dict_InitializesEmpty()
        {
            Assert.AreEqual(0, dict.Size);
        }

        [TestMethod]
        public void Dict_SingleGetSet()
        {
            dict["foo"] = 10;

            Assert.AreEqual(10, dict["foo"]);
        }

        [TestMethod]
        public void Dict_SizeAfterSingleSet()
        {
            dict["foo"] = 10;

            Assert.AreEqual(1, dict.Size);
        }

        [TestMethod]
        public void Dict_MultipleGetSet()
        {
            dict["foo"] = 10;
            dict["bar"] = 30;
            dict["buzz"] = 50;

            Assert.AreEqual(10, dict["foo"]);
            Assert.AreEqual(30, dict["bar"]);
            Assert.AreEqual(50, dict["buzz"]);
        }

        [TestMethod]
        public void Dict_SizeAfterMultipleSet()
        {
            dict["foo"] = 10;
            dict["bar"] = 30;
            dict["buzz"] = 50;

            Assert.AreEqual(3, dict.Size);
        }

        [TestMethod]
        public void Dict_ManyGetSet()
        {
            var rand = new Random();

            var pairs = new List<KeyValuePair<string, int>>();

            // build out key value pairs and add them
            foreach(var i in Enumerable.Repeat(0, 5000))
            {
                var key = new Guid().ToString();
                var value = rand.Next();
                pairs.Add(new KeyValuePair<string, int>(key, value));

                dict[key] = value;
            }

            // check that the key value pairs are valid when accessed in dict
            foreach(var pair in pairs)
            {
                Assert.AreEqual(pair.Value, dict[pair.Key]);
            }
        }

        [TestMethod]
        public void Dict_ContainsKey_Positive()
        {
            dict["foo"] = 10;

            Assert.IsTrue(dict.ContainsKey("foo"));
        }

        [TestMethod]
        public void Dict_ContainsKey_Negative()
        {
            dict["foo"] = 10;

            Assert.IsFalse(dict.ContainsKey("bar"));
        }

        [TestMethod]
        public void Dict_Clear()
        {
            dict["foo"] = 10;
            dict["bar"] = 30;
            dict["buzz"] = 50;

            dict.Clear();

            Assert.AreEqual(0, dict.Size);
        }
    }
}
