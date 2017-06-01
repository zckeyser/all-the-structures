package graphs

import "../core"

func (d *DirectedNode) BreadthFirstSearch() []int {
    q := new(Queue)
    q.Enqueue(d)

    visited := make([]*DirectedNode, 0)

    for n := q.Dequeue(); q != nil; n = q.Dequeue() {
        for neighbor := range n.neighbors {
            if !(visited.Contains(neighbor) || q.Contains(neighbor)) {
                q.Enqueue(neighbor)
            }
        }
        
        visited = append(visited, n)
    }

    return visited
}