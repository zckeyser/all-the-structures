using DataStructures.search.graph;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Test.search.graph
{
    [TestClass]
    public class BreadthFirstSearchTest
    {
        private DirectedGraphNode<int> root;

        [TestInitialize]
        public void SetUp()
        {
            root = new DirectedGraphNode<int>(21);
            var n1 = new DirectedGraphNode<int>(14);
            var n2 = new DirectedGraphNode<int>(18);
            var n3 = new DirectedGraphNode<int>(39);
            var n4 = new DirectedGraphNode<int>(51);
            var n5 = new DirectedGraphNode<int>(63);
            var n6 = new DirectedGraphNode<int>(16);
            var n7 = new DirectedGraphNode<int>(27);
            var n8 = new DirectedGraphNode<int>(84);
            var n9 = new DirectedGraphNode<int>(30);
            var n10 = new DirectedGraphNode<int>(33);
            var n11 = new DirectedGraphNode<int>(36);
            var n12 = new DirectedGraphNode<int>(11);

            root.AddNeighbor(n1);
            root.AddNeighbor(n2);
            root.AddNeighbor(n3);
            n1.AddNeighbor(n4);
            n2.AddNeighbor(n1);
            n2.AddNeighbor(n5);
            n3.AddNeighbor(n6);
            n3.AddNeighbor(n7);
            n5.AddNeighbor(n8);
            n6.AddNeighbor(n8);
            n6.AddNeighbor(n12);
            n7.AddNeighbor(n9);
            n9.AddNeighbor(n10);
            n10.AddNeighbor(n11);
        }

        [TestMethod]
        public void BreadthFirstSearch_Traverse()
        {
            const string expected = "21 14 18 39 51 63 16 27 84 11 30 33 36";

            var result = BreadthFirstSearch.Traverse(root);

            Assert.AreEqual(expected, result);
        }
    }
}
