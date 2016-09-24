using DataStructures.stack;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test.stack
{
    [TestClass]
    public class PriorityQueueTest
    {
        private PriorityQueue<int> queue;

        [TestInitialize]
        public void SetUp()
        {
            queue = new PriorityQueue<int>(5);
        }
    }
}
