using System.Collections.Generic;

namespace DataStructures.search.graph
{
    public class DirectedGraphNode<T>
    {
        public T Data { get; private set; }

        private List<DirectedGraphNode<T>> neighbors;

        public DirectedGraphNode(T data)
        {
            this.neighbors = new List<DirectedGraphNode<T>>();
            this.Data = data;
        }

        public void AddNeighbor(DirectedGraphNode<T> neighbor)
        {
            neighbors.Add(neighbor);
        }

        public List<DirectedGraphNode<T>> GetNeighbors()
        {
            return new List<DirectedGraphNode<T>>(neighbors);
        }

        public override bool Equals(object obj)
        {
            var node = obj as DirectedGraphNode<T>;

            // wrong type or wrong value
            if (node == null || !node.Data.Equals(Data)) return false;

            // make sure all neighbors are equal
            if (node.neighbors.Count != neighbors.Count) return false;

            for (int i = 0; i < neighbors.Count; i++)
                if (!node.neighbors[i].Equals(neighbors[i]))
                    return false;

            return true;
        }
    }
}
