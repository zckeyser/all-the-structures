using System.Collections.Generic;
using System.Linq;

namespace DataStructures.search.graph
{
    public class BreadthFirstSearch
    {
        public static string Traverse<T>(DirectedGraphNode<T> root)
        {
            string output = "";

            var visited = new List<DirectedGraphNode<T>>();
            var queue = new Queue<DirectedGraphNode<T>>();
            queue.Enqueue(root);

            while (queue.Count != 0)
            {
                var curr = queue.Dequeue();

                foreach (var neighbor in curr.GetNeighbors())
                    if (!(visited.Any(node => node.Equals(neighbor)) || queue.Any(node => node.Equals(neighbor))))
                        queue.Enqueue(neighbor);

                visited.Add(curr);

                output += curr.Data.ToString() + " ";
            }

            return output.Trim();
        }
    }
}
