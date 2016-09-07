module TreeTraversal
    class Traverser
        def preorder(root)
            return self.preorder_helper(root).strip
        end

        def preorder_helper(root)
            out = ''

            out += root.value.to_s + ' '

            if !root.left.nil?
                out += self.preorder_helper(root.left)
            end

            if !root.right.nil?
                out += self.preorder_helper(root.right)
            end

            return out
        end

        def inorder(root)
            return self.inorder_helper(root).strip
        end

        def inorder_helper(root)
            out = ''

            if !root.left.nil?
                out += self.inorder_helper(root.left)
            end

            out += root.value.to_s + ' '

            if !root.right.nil?
                out += self.inorder_helper(root.right)
            end

            return out
        end

        def postorder(root)
            return self.postorder_helper(root).strip
        end

        def postorder_helper(root)
            out = ''

            if !root.left.nil?
                out += self.postorder_helper(root.left)
            end

            if !root.right.nil?
                out += self.postorder_helper(root.right)
            end

            out += root.value.to_s + ' '

            return out
        end
    end

    def TreeTraversal.preorder(root)
        return Traverser.new.preorder(root)
    end

    def TreeTraversal.inorder(root)
        return Traverser.new.inorder(root)
    end

    def TreeTraversal.postorder(root)
        return Traverser.new.postorder(root)
    end
end
