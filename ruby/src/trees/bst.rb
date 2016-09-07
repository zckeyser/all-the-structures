class BinarySearchTree
    attr_reader :left, :right, :parent, :count
    attr :value

    def initialize(value, parent)
        @left = nil
        @right = nil
        @parent = parent
        @value = value
        @count = 1
    end

    def insert(val)
        if val == @value
            @count += 1
        elsif val > @value
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
        if val == @value
            # if this number's been inserted multiple times,
            # remove one instance
            if @count > 1
                @count -= 1
            elsif self.is_leaf?
                # just null the reference to this in our parent
                @parent.replace_child(@value, nil)
            elsif self.has_single_child?
                child = @left || @right

                @value = child.value
                @count = child.count

                child.remove(child.value)
            else
                # replace this with the greatest value in its left subtree
                child = @left.max

                # move the child to this node
                @value = child.value
                @count = child.count

                # get rid of the leftover object that we moved up, maintaining BST properties
                child.remove(child.value)
            end
        elsif val < @value
            # remove from left subtree
            if !@left.nil?
                @left.remove(val)
            end
        else
            # remove from right subtree
            if !@right.nil?
                @right.remove(val)
            end
        end
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
        return @left.nil? && @right.nil?
    end

    def has_single_child?()
        return @left.nil? ^ @right.nil?
    end

    protected
        def replace_child(child_val, replacement_node)
            if child_val < value
                @left = replacement_node
            else
                @right = replacement_node
            end
        end

        def max
            return @right.max if !@right.nil? else return self
        end
end
