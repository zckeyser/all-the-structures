using DataStructures.trees;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Test.trees
{
    [TestClass]
	public class BinaryTreeTraverserTest
	{
        private IBinaryTree<int> root;
        private BinaryTreeTraverser traverser = new BinaryTreeTraverser();

        [TestInitialize]
        public void SetUp()
        {
            //        1
            //    2       3
            //  4   5   6   7
            // easier if we don't use the root at first
            var test = new BinaryTree<int>(1);
            var left = new BinaryTree<int>(2);
            var right = new BinaryTree<int>(3);
            test.Left = left;
            test.Right = right;
            left.Left = new BinaryTree<int>(4);
            left.Right = new BinaryTree<int>(5);
            right.Left = new BinaryTree<int>(6);
            right.Right = new BinaryTree<int>(7);

            root = test;
        }

        [TestMethod]
        public void TreeTraverser_PreOrder()
        {
            const string expected = "1 2 4 5 3 6 7";

            var result = traverser.PreOrder(root);

            Assert.AreEqual(expected, result);
        }

        [TestMethod]
        public void TreeTraverser_InOrder()
        {
            const string expected = "4 2 5 1 6 3 7";

            var result = traverser.InOrder(root);

            Assert.AreEqual(expected, result);
        }

        [TestMethod]
        public void TreeTraverser_PostOrder()
        {
            const string expected = "4 5 2 6 7 3 1";

            var result = traverser.PostOrder(root);

            Assert.AreEqual(expected, result);
        }
    }
}
