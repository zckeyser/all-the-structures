using DataStructures.search.graph;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Test.search.graph
{
    [TestClass]
    public class DirectedGraphNodeTest
    {
        [TestMethod]
        public void DirectedGraphNode_Equals_NoNeighbors_Equal()
        {
            var n1 = new DirectedGraphNode<int>(10);
            var n2 = new DirectedGraphNode<int>(10);

            Assert.IsTrue(n1.Equals(n2));
        }

        [TestMethod]
        public void DirectedGraphNode_Equals_NoNeighbors_Unequal()
        {
            var n1 = new DirectedGraphNode<int>(10);
            var n2 = new DirectedGraphNode<int>(55);

            Assert.IsFalse(n1.Equals(n2));
        }

        [TestMethod]
        public void DirectedGraphNode_Equals_WithNeighbors_Equal()
        {
            var n1 = new DirectedGraphNode<int>(10);
            var n2 = new DirectedGraphNode<int>(100);
            var n3 = new DirectedGraphNode<int>(30);
            var n4 = new DirectedGraphNode<int>(60);
            var n5 = new DirectedGraphNode<int>(70);
            var n6 = new DirectedGraphNode<int>(80);

            n1.AddNeighbor(n2);
            n1.AddNeighbor(n3);
            n3.AddNeighbor(n4);
            n4.AddNeighbor(n5);
            n4.AddNeighbor(n6);

            var n7 = new DirectedGraphNode<int>(10);

            n7.AddNeighbor(n2);
            n7.AddNeighbor(n3);

            Assert.IsTrue(n1.Equals(n7));
        }

        [TestMethod]
        public void DirectedGraphNode_Equals_WithNeighbors_UnequalLengths()
        {
            var n1 = new DirectedGraphNode<int>(10);
            var n2 = new DirectedGraphNode<int>(100);
            var n3 = new DirectedGraphNode<int>(30);
            var n4 = new DirectedGraphNode<int>(60);
            var n5 = new DirectedGraphNode<int>(70);
            var n6 = new DirectedGraphNode<int>(80);

            n1.AddNeighbor(n2);
            n1.AddNeighbor(n3);
            n3.AddNeighbor(n4);
            n4.AddNeighbor(n5);
            n4.AddNeighbor(n6);

            var n7 = new DirectedGraphNode<int>(10);

            n7.AddNeighbor(n3);

            Assert.IsFalse (n1.Equals(n7));
        }

        [TestMethod]
        public void DirectedGraphNode_Equals_WithNeighbors_UnequalNeighborValue()
        {
            var n1 = new DirectedGraphNode<int>(10);
            var n2 = new DirectedGraphNode<int>(10);
            var n3 = new DirectedGraphNode<int>(20);
            var n4 = new DirectedGraphNode<int>(30);
            var n5 = new DirectedGraphNode<int>(40);

            n1.AddNeighbor(n3);
            n1.AddNeighbor(n4);

            n2.AddNeighbor(n3);
            n2.AddNeighbor(n5);

            Assert.IsFalse(n1.Equals(n2));
        }
    }
}
