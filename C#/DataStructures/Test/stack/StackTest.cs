using DataStructures.stack;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Test.stack
{
    [TestClass]
    public class StackTest
    {
        private Stack<int> stack;

        [TestInitialize]
        public void SetUp()
        {
            stack = new Stack<int>();
        }

        [TestMethod]
        public void Stack_InitializesEmpty()
        {
            Assert.AreEqual(0, stack.Size);
        }

        [TestMethod]
        public void Stack_AfterSinglePush_HasCorrectSize()
        {
            stack.Push(5);

            Assert.AreEqual(1, stack.Size);
        }

        [TestMethod]
        public void Stack_PopsSingleItemCorrectly()
        {
            stack.Push(5);

            Assert.AreEqual(5, stack.Pop());
        }

        [TestMethod]
        public void Stack_AfterMultiplePushs_HasCorrectSize()
        {
            stack.Push(5);
            stack.Push(10);

            Assert.AreEqual(2, stack.Size);
        }

        [TestMethod]
        public void Stack_PopsMultipleItemsCorrectly()
        {
            stack.Push(5);
            stack.Push(10);

            Assert.AreEqual(10, stack.Pop());
            Assert.AreEqual(5, stack.Pop());
        }

        [TestMethod]
        public void Stack_IteratesCorrectly()
        {
            stack.Push(5);
            stack.Push(10);
            stack.Push(15);
            stack.Push(20);

            int[] expected = new int[] { 20, 15, 10, 5 };

            int i = 0;
            foreach (var item in stack)
            {
                Assert.AreEqual(item, expected[i]);
                i++;
            }

            Assert.AreEqual(0, stack.Size);
        }
    }
}
