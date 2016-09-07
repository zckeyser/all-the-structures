class BinaryTree
    attr_reader :left, :right, :value
    attr_writer :left, :right, :value

    def initialize(val, parent = nil)
        @value = val
        @parent = parent
    end
end
