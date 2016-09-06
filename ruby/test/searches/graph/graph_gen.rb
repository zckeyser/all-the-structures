module GraphGeneration
    def GraphGeneration.generate()
            # This is going to be a bit of a mess because it's pre-planned
            # I'll include a scanned image of the graph later
            # it'll be hand drawn but should at least make this kinda legible
            root = DirectedGraphNode.new(21)
            n1 = DirectedGraphNode.new(14)
            n2 = DirectedGraphNode.new(18)
            n3 = DirectedGraphNode.new(39)
            n4 = DirectedGraphNode.new(51)
            n5 = DirectedGraphNode.new(63)
            n6 = DirectedGraphNode.new(16)
            n7 = DirectedGraphNode.new(27)
            n8 = DirectedGraphNode.new(84)
            n9 = DirectedGraphNode.new(30)
            n10 = DirectedGraphNode.new(33)
            n11 = DirectedGraphNode.new(36)
            n12 = DirectedGraphNode.new(11)

            root.add_neighbor(n1)
            root.add_neighbor(n2)
            root.add_neighbor(n3)
            n1.add_neighbor(n4)
            n2.add_neighbor(n1)
            n2.add_neighbor(n5)
            n3.add_neighbor(n6)
            n3.add_neighbor(n7)
            n5.add_neighbor(n8)
            n6.add_neighbor(n8)
            n6.add_neighbor(n12)
            n7.add_neighbor(n9)
            n9.add_neighbor(n10)
            n10.add_neighbor(n11)

            return root
    end
end
