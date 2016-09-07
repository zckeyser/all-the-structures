class BinarySearchTree
    attr_reader :left, :right, :parent, :value

    def initialize(value, parent)
        @left = nil
        @right = nil
        @parent = parent
        @value = value
    end

    def insert(val)
        if val > @value
            if @right.nil?
                @right = BinarySearchTree.new(val, self)
            else
                @right.insert(val)
            end
        else
            if @left.nil?
                @left = BinarySearchTree.new(val, self)
            else
                @left.insert(val)
            end
        end
    end

    def remove(val)
        
    end

    def contains?(val)
        return true if @value == val

        if val < @value
            return !@left.nil? && @left.contains?(val)
        else
            return !@right.nil? && @right.contains?(val)
        end
    end

    def is_leaf?()

    end

    def has_single_child?()

    end
end
