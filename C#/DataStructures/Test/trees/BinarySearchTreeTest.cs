using DataStructures.trees;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test.trees
{
    [TestClass]
	public class BinarySearchTreeTest
	{
        private BinarySearchTree<int> root;
        private BinaryTreeTraverser traverser = new BinaryTreeTraverser();

        [TestInitialize]
        public void SetUp()
        {
            root = new BinarySearchTree<int>(null, 50);

            root.Insert(10);
            root.Insert(30);
            root.Insert(42);
            root.Insert(15);
            root.Insert(3);
            root.Insert(60);
            root.Insert(80);
            root.Insert(83);
            root.Insert(24);
            root.Insert(73);
            root.Insert(87);
            root.Insert(100);
        }

        [TestMethod]
        public void BinarySearchTree_Insert()
        {
            const string expected = "3 10 15 24 30 42 50 60 73 80 83 87 100";
            var result = traverser.InOrder(root);

            Assert.AreEqual(expected, result);
        }

        [TestMethod]
        public void BinarySerachTree_Remove_Leaf()
        {
            const string expected = "10 15 24 30 42 50 60 73 80 83 87 100";

            root.Remove(3);
            var result = traverser.InOrder(root);

            Assert.AreEqual(expected, result);
        }

        [TestMethod]
        public void BinarySearchTree_Remove_SingleChild()
        {
            const string expected = "3 15 24 30 42 50 60 73 80 83 87 100";

            root.Remove(10);
            var result = traverser.InOrder(root);

            Assert.AreEqual(expected, result);
        }

        [TestMethod]
        public void BinarySearchTree_Remove_TwoChildren()
        {
            const string expected = "3 10 15 24 42 50 60 73 80 83 87 100";

            root.Remove(30);
            var result = traverser.InOrder(root);

            Assert.AreEqual(expected, result);
        }

        [TestMethod]
        public void BinarySearchTree_Remove_Root()
        {
            const string expected = "3 10 15 24 30 42 60 73 80 83 87 100";

            root.Remove(50);
            var result = traverser.InOrder(root);

            Assert.AreEqual(expected, result);
        }

        [TestMethod]
        public void BinarySearchTree_Contains()
        {
            Assert.IsTrue(root.Contains(80));
            Assert.IsFalse(root.Contains(150));
        }
	}
}
