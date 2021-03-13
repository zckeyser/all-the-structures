import structures.src.graph.directed as graph

def get_graph():
    root = graph.Node(21)
    n1 = graph.Node(14)
    n2 = graph.Node(18)
    n3 = graph.Node(39)
    n4 = graph.Node(51)
    n5 = graph.Node(63)
    n6 = graph.Node(16)
    n7 = graph.Node(27)
    n8 = graph.Node(84)
    n9 = graph.Node(30)
    n10 = graph.Node(33)
    n11 = graph.Node(36)
    n12 = graph.Node(11)

    root.addNeighbor(n1)
    root.addNeighbor(n2)
    root.addNeighbor(n3)
    n1.addNeighbor(n4)
    n2.addNeighbor(n1)
    n2.addNeighbor(n5)
    n3.addNeighbor(n6)
    n3.addNeighbor(n7)
    n5.addNeighbor(n8)
    n6.addNeighbor(n8)
    n6.addNeighbor(n12)
    n7.addNeighbor(n9)
    n9.addNeighbor(n10)
    n10.addNeighbor(n11)

    return root
