package graphs

import "../core"

func (d *DirectedNode) BreadthFirstSearch() []int {
    s := new(Stack)
    s.Push(d)

    visited := make([]*DirectedNode, 0)

    for n := s.Pop(); s.Size != 0; n = s.Pop() {
        for neighbor := range n.neighbors {
            if !(visited.Contains(neighbor) || s.Contains(neighbor)) {
                s.Push(neighbor)
            }
        }
        
        visited = append(visited, n)
    }

    return visited
}