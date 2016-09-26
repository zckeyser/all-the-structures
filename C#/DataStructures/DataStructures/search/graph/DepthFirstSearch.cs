using System.Collections.Generic;
using System.Linq;

namespace DataStructures.search.graph
{
    public static class DepthFirstSearch
    {
        public static string Traverse<T>(DirectedGraphNode<T> root)
        {
            string output = "";

            var visited = new List<DirectedGraphNode<T>>();
            var stack = new Stack<DirectedGraphNode<T>>();
            stack.Push(root);

            while(stack.Count != 0)
            {
                var curr = stack.Pop();

                foreach(var neighbor in curr.GetNeighbors())
                    if (!(visited.Any(node => node.Equals(neighbor)) || stack.Any(node => node.Equals(neighbor))))
                        stack.Push(neighbor);

                visited.Add(curr);

                output += curr.Data.ToString() + " ";
            }

            return output.Trim();
        }
    }
}
