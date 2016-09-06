class DirectedGraphNode
    def initialize(value)
        @value = value
        @neighbors = []
    end

    def neighbors
        @neighbors
    end

    def value
        @value
    end

    def add_neighbor(node)
        raise ArgumentError, 'can only add a DirectedGraphNode as a neighbor to a DirectedGraphNode' if !node.is_a?(DirectedGraphNode)

        @neighbors << node
    end

    def remove_neighbor(node)
        @neighbors -= [node]
    end
end
