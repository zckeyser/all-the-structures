package graphs

type DirectedNode struct {
    value int
    neighbors []*DirectedNode
}

func sliceContains(nodes []*DirectedNode, target *DirectedNode) bool {
    for _, n := range nodes {
        if n == target {
            return true
        }
    }

    return false
}

func compareNode(a, b interface{}) bool {
    return a.(*DirectedNode) == b.(*DirectedNode)
}
