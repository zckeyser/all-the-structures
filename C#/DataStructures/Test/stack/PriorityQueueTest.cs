using DataStructures.stack;
using Microsoft.VisualStudio.TestTools.UnitTesting;

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

        [TestMethod]
        public void PriorityQueue_InitializedEmpty()
        {
            Assert.AreEqual(0, queue.Size);
        }

        [TestMethod]
        public void PriorityQueue_InitializesWithCorrectLevelCount()
        {
            Assert.AreEqual(4, queue.MaxPriority);
        }

        [TestMethod]
        public void PriorityQueue_DefaultEnqueue_ChangesSizeCorrectly()
        {
            queue.Enqueue(5);
            queue.Enqueue(10);
            queue.Enqueue(15);
            queue.Enqueue(20);

            Assert.AreEqual(4, queue.Size);
        }

        [TestMethod]
        public void PriorityQueue_DefaultEnqueue_DequeuesItemsCorrectly()
        {
            queue.Enqueue(5);
            queue.Enqueue(10);
            queue.Enqueue(15);
            queue.Enqueue(20);

            Assert.AreEqual(5, queue.Dequeue());
            Assert.AreEqual(10, queue.Dequeue());
            Assert.AreEqual(15, queue.Dequeue());
            Assert.AreEqual(20, queue.Dequeue());
        }

        [TestMethod]
        public void PriorityQueue_EnqueueWithLevel_EqualDist_ReflectsSize()
        {
            queue.Enqueue(5, 0);
            queue.Enqueue(10, 0);
            queue.Enqueue(15, 2);
            queue.Enqueue(20, 2);
            queue.Enqueue(25, 1);
            queue.Enqueue(30, 1);
            queue.Enqueue(35, 3);
            queue.Enqueue(40, 3);
            queue.Enqueue(45, 4);
            queue.Enqueue(50, 4);

            Assert.AreEqual(10, queue.Size);
        }

        [TestMethod]
        public void PriorityQueue_EnqueueWithLevel_EqualDist_DequeuesCorrectly()
        {
            queue.Enqueue(5, 0);
            queue.Enqueue(10, 0);
            queue.Enqueue(15, 2);
            queue.Enqueue(20, 2);
            queue.Enqueue(25, 1);
            queue.Enqueue(30, 1);
            queue.Enqueue(35, 3);
            queue.Enqueue(40, 3);
            queue.Enqueue(45, 4);
            queue.Enqueue(50, 4);

            int[] expected = new[] { 45, 50, 35, 40, 15, 20, 25, 30, 5, 10 };

            foreach (int item in expected)
                Assert.AreEqual(item, queue.Dequeue());

            Assert.AreEqual(0, queue.Size);
        }

        [TestMethod]
        public void PriorityQueue_EnqueueWithLevel_UnevenDist_ReflectsSize()
        {
            queue.Enqueue(5, 0);
            queue.Enqueue(10, 2);
            queue.Enqueue(15, 2);
            queue.Enqueue(20, 2);
            queue.Enqueue(25, 1);
            queue.Enqueue(30, 1);
            queue.Enqueue(35, 3);
            queue.Enqueue(40, 3);
            queue.Enqueue(45, 3);
            queue.Enqueue(50, 4);

            Assert.AreEqual(10, queue.Size);
        }

        [TestMethod]
        public void PriorityQueue_EnqueueWithLevel_UnevenDist_DequeuesCorrectly()
        {
            queue.Enqueue(5, 0);
            queue.Enqueue(10, 2);
            queue.Enqueue(15, 2);
            queue.Enqueue(20, 2);
            queue.Enqueue(25, 1);
            queue.Enqueue(30, 1);
            queue.Enqueue(35, 3);
            queue.Enqueue(40, 3);
            queue.Enqueue(45, 3);
            queue.Enqueue(50, 4);

            int[] expected = new[] { 50, 35, 40, 45, 10, 15, 20, 25, 30, 5 };

            foreach (int item in expected)
                Assert.AreEqual(item, queue.Dequeue());

            Assert.AreEqual(0, queue.Size);
        }

        [TestMethod]
        public void PriorityQueue_DequeueWithLevel()
        {
            queue.Enqueue(5, 0);
            queue.Enqueue(10, 2);
            queue.Enqueue(15, 2);
            queue.Enqueue(20, 2);
            queue.Enqueue(25, 1);
            queue.Enqueue(30, 1);
            queue.Enqueue(35, 3);
            queue.Enqueue(40, 3);
            queue.Enqueue(45, 3);
            queue.Enqueue(50, 4);

            Assert.AreEqual(5, queue.Dequeue(0));
            Assert.AreEqual(25, queue.Dequeue(1));
            Assert.AreEqual(10, queue.Dequeue(2));
            Assert.AreEqual(35, queue.Dequeue(3));
            Assert.AreEqual(50, queue.Dequeue(4));

            Assert.AreEqual(5, queue.Size);
        }

        [TestMethod]
        public void PriorityQueue_IteratesCorrectly()
        {
            queue.Enqueue(5, 0);
            queue.Enqueue(10, 0);
            queue.Enqueue(15, 2);
            queue.Enqueue(20, 2);
            queue.Enqueue(25, 1);
            queue.Enqueue(30, 1);
            queue.Enqueue(35, 3);
            queue.Enqueue(40, 3);
            queue.Enqueue(45, 4);
            queue.Enqueue(50, 4);

            int[] expected = new[] { 45, 50, 35, 40, 15, 20, 25, 30, 5, 10 };

            int i = 0;
            foreach (int item in queue)
            {
                Assert.AreEqual(expected[i], item);
                i++;
            }

            Assert.AreEqual(0, queue.Size);
        }
    }
}
