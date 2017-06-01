package graphs

import "../core"

func (d *DirectedNode) BreadthFirstSearch() []int {
    q := new(core.Queue)
    q.Enqueue(d)

    var visited []*DirectedNode

    for n, _ := q.Dequeue(); q.Size() != 0; n, _ = q.Dequeue() {
        curr := n.(*DirectedNode)

        for _, neighbor := range curr.neighbors {
            if !(sliceContains(visited, neighbor) || q.Contains(neighbor, compareNode)) {
                q.Enqueue(neighbor)
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
