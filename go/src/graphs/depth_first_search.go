package graphs

import "../core"

func (d *DirectedNode) DepthFirstSearch() []int {
    s := new(core.Stack)
    s.Push(d)

    var visited []*DirectedNode

    for n, _ := s.Pop(); s.Size() != 0; n, _ = s.Pop() {
        curr := n.(*DirectedNode)

        for _, neighbor := range curr.neighbors {
            if !(sliceContains(visited, neighbor) || s.Contains(neighbor, compareNode)) {
                s.Push(neighbor)
            }
        }

        visited = append(visited, curr)
    }

    // extract the actual values
    var out []int

    for _, n := range visited {
      out = append(out, n.value)
    }

    return out
}
