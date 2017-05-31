package graphs

type DirectedNode struct {
    value int
    neighbors []DirectedNode
}

func (nodes []*DirectedNode) Contains(target *DirectedNode) {
    for _, n := range nodes {
        if n == target {
            return true
        }
    }

    return false
}