using DataStructures.stack;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Test.stack
{
    [TestClass]
    public class QueueTest
    {
        private Queue<int> queue;

        [TestInitialize]
        public void SetUp()
        {
            queue = new Queue<int>();
        }

        [TestMethod]
        public void Queue_InitializesEmpty()
        {
            Assert.AreEqual(0, queue.Size);
        }

        [TestMethod]
        public void Queue_AfterSingleEnqueue_HasCorrectSize()
        {
            queue.Enqueue(5);

            Assert.AreEqual(1, queue.Size);
        }

        [TestMethod]
        public void Queue_DequeuesSingleItemCorrectly()
        {
            queue.Enqueue(5);

            Assert.AreEqual(5, queue.Dequeue());
        }
    
        [TestMethod]
        public void Queue_AfterMultipleEnqueues_HasCorrectSize()
        {
            queue.Enqueue(5);
            queue.Enqueue(10);

            Assert.AreEqual(2, queue.Size);
        }

        [TestMethod]
        public void Queue_DequeuesMultipleItemsCorrectly()
        {
            queue.Enqueue(5);
            queue.Enqueue(10);

            Assert.AreEqual(5, queue.Dequeue());
            Assert.AreEqual(10, queue.Dequeue());
        }

        [TestMethod]
        public void Queue_IteratesCorrectly()
        {
            queue.Enqueue(5);
            queue.Enqueue(10);
            queue.Enqueue(15);
            queue.Enqueue(20);

            int[] expected = new int[] { 5, 10, 15, 20 };

            int i = 0;
            foreach(var item in queue)
            {
                Assert.AreEqual(item, expected[i]);
                i++;
            }

            Assert.AreEqual(0, queue.Size);
        }
    }
}
